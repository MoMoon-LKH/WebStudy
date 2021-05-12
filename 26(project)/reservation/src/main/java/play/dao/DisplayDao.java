package play.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import play.dto.Display;
import play.dto.Item;
import play.dto.UserComment;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static play.dao.DisplaySqls.*;

@Repository
public class DisplayDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;
    private RowMapper<UserComment> commentMap = BeanPropertyRowMapper.newInstance(UserComment.class);
    private RowMapper<Display> disMap = BeanPropertyRowMapper.newInstance(Display.class);

    public DisplayDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("display_info")
                .usingGeneratedKeyColumns("id");
    }

    public List<Display> getDisplay(Integer displayId){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", displayId);
        return jdbc.query(SELECT_DISPLAY, param, disMap);
    }

    public List<UserComment> getUserComment(Integer displayId){
        Map<String, Integer> params = new HashMap<>();
        params.put("id", displayId);
        return jdbc.query(SELECT_COMMENT, params, commentMap);
    }
}
