package play.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import play.dto.Item;
import play.dto.ItemPrice;

import javax.sql.DataSource;
import java.util.*;

import static play.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;
    private RowMapper<Item> rowMapper = BeanPropertyRowMapper.newInstance(Item.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }

    public List<Item> products(Integer tabNum, Integer start, Integer limit) {
        Map<String, Integer> params = new HashMap<>();

        if (tabNum > 0) {
            params.put("id", tabNum);
            params.put("start", start);
            params.put("limit", limit);
            return jdbc.query(SELECT_CATEGORY_PRODUCTS, params, rowMapper);
        } else {
            params.put("start", start);
            params.put("limit", limit);
            return jdbc.query(SELECT_PRODUCTS, params, rowMapper);
        }
    }




    public List<Integer> productCount() {
        return jdbc.queryForList(SELECT_COUNT, Collections.emptyMap(), Integer.class);
    }

    public List<String> promotion(){
        return jdbc.queryForList(SELECT_PROMOTION, Collections.emptyMap(), String.class);
    }

}
