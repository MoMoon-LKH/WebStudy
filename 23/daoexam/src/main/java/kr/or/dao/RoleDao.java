package kr.or.dao;

import kr.or.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
    private SimpleJdbcInsert insertAction;

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");

    }

    public List<Role> selectAll(){
        return jdbc.query(RoleDaoSqls.SELECT_ALL , Collections.EMPTY_MAP, rowMapper);
    }

    public int insert(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return insertAction.execute(params);
    }

    public int update(Role role){
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbc.update(RoleDaoSqls.UPDATE, params);
    }

    public int delete(Integer id) {
        Map<String, ?> params = Collections.singletonMap("roleId", id);
        return jdbc.update(RoleDaoSqls.DELETE, params);
    }

    public Role selectOne(Integer id) {
        try {
            Map<String, ?> params = Collections.singletonMap("roleId", id);
            return jdbc.queryForObject(RoleDaoSqls.FIND, params, rowMapper);
        } catch (Exception e) {
            return null;
        }

    }


}
