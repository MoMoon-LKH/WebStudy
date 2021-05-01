package play.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import play.dto.Item;
import play.dto.Product;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Item> products(Integer start, Integer limit) {
        Map<String, Integer> params = new HashMap<>();
        params.put("start", start);
        params.put("limit", limit);
        return jdbc.query(SELECT_PRODUCTS, params, rowMapper);

    }
}
