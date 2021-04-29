package guestbook.dao;

import guestbook.dto.Log;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class LogDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;

    public LogDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate((dataSource));
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("log")
                .usingGeneratedKeyColumns("id");
    }

    public Long insertRow(Log log) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(log);
        return insert.executeAndReturnKey(params).longValue();
    }

}
