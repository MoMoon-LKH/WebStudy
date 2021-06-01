package play.dao;

import com.mysql.cj.result.Row;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import play.dto.*;

import javax.sql.DataSource;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

import static play.dao.ReservationSqls.*;

@Repository
public class ReservationDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;
    private RowMapper<ReservationUser> userMapper = BeanPropertyRowMapper.newInstance(ReservationUser.class);
    private RowMapper<ReservationPrice> priceMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);
    private RowMapper<ReservationPriceEntity> priceEntity = BeanPropertyRowMapper.newInstance(ReservationPriceEntity.class);

    public ReservationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
    }

    public int insertReservationInfo(ReservationInfo ri, int product_id) {

        ri.setProductId(product_id);

        List<String> date = dateSet();
        ri.setCreateDate(date.get(0));
        ri.setModifyDate(date.get(1));

        SqlParameterSource param = new BeanPropertySqlParameterSource(ri);
        return insert.executeAndReturnKey(param).intValue();
    }

    public int insertReservationPrice(int reservationId, int productId,List<ReservationPrice> reservationPrice) {
        int countNum = 0;

        for (int i = 0; i < reservationPrice.size(); i++) {
            if (reservationPrice.get(i).getCount() > 0) {
                SqlParameterSource param = new MapSqlParameterSource()
                        .addValue("product_id", productId)
                        .addValue("price_type", reservationPrice.get(i).getPriceTypeName());
                int priceId = jdbc.queryForObject(SELECT_PRODUCT_PRICE_ID, param, Integer.class);

                Map<String, Integer> params = new HashMap<>();
                params.put("reservation_info_id", reservationId);
                params.put("product_price_id", priceId);
                params.put("count", reservationPrice.get(i).getCount());
                jdbc.update(INSERT_RESERVATION_PRICE, params);
                countNum++;
            }
        }
        return countNum;
    }

    public List<String> dateSet() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        String create = dateFormat.format(date);
        String modify = dateFormat.format(date);

        List<String> list = new ArrayList<>();
        list.add(create);
        list.add(modify);
        return list;
    }

    public int getProductId(int id){
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(SELECT_PRODUCT_ID, params, Integer.class);
    }

    public String getEmail(String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        try {
            return jdbc.queryForObject(SELECT_RESERVATION_EMAIL, params, String.class);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ReservationUser> getReservationUser(String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return jdbc.query(SELECT_RESERVATION_USER, params, userMapper);
    }

    public List<ReservationPrice> getReservationPrice(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbc.query(SELECT_RESERVATION_PRICE, params, priceMapper);
    }

    public List<ReservationInfo> getReservationInfo(String email) {
        List<ReservationUser> list = getReservationUser(email);
        List<ReservationInfo> reservation = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ReservationInfo info = defineInfo(list.get(i));
            List<ReservationPrice> prices = getReservationPrice(info.getId());
            info.setPrices(prices);
            reservation.add(info);
        }

        return reservation;
    }

    public ReservationInfo defineInfo(ReservationUser user) {
        ReservationInfo reservationInfo = new ReservationInfo(user);

        return reservationInfo;
    }

}
