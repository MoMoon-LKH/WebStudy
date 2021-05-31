package play.dao;

import com.mysql.cj.result.Row;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
    private RowMapper<ReservationInfo> reservationInfoMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
    private RowMapper<ReservationPrice> priceMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);


    public ReservationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
    }

    public int insertReservationInfo(ReservationInfo ri) {
        Map<String, Integer> params = new HashMap<>();

        params.put("id", ri.getDisplayInfoId());
        ri.setProductId(jdbc.queryForObject(SELECT_PRODUCT_ID, params, Integer.class));

        List<String> date = dateSet();
        ri.setCreateDate(date.get(0));
        ri.setModifyDate(date.get(1));

        SqlParameterSource param = new BeanPropertySqlParameterSource(ri);
        return insert.executeAndReturnKey(param).intValue();
    }

    public int insertReservationPrice(int reservationId, int productId,List<ReservationPrice> reservationPrice) {
        ReservationPriceEntity res = new ReservationPriceEntity();
        int countNum = 0;

        for (int i = 0; i < reservationPrice.size(); i++) {
            if (reservationPrice.get(i).getCount() > 0) {
                //res.setProduct_price_id(jdbc.query());
                res.setCount(reservationPrice.get(i).getCount());

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

}
