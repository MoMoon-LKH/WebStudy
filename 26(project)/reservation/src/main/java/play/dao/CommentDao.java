package play.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import play.dto.CommentEntity;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;

import static play.dao.CommentSql.*;

@Repository
public class CommentDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;
    private RowMapper<CommentEntity> rowMapper = BeanPropertyRowMapper.newInstance(CommentEntity.class);

    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment")
                .usingGeneratedKeyColumns("id");
    }

    public int insertComment(CommentEntity comment ,int productId) {

        comment.setProductId(productId);

        SqlParameterSource params = new BeanPropertySqlParameterSource(comment);

        return insert.executeAndReturnKey(params).intValue();
    }

    public int insertCommentImage(int reservationId, int commentId, int fileId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationId", reservationId);
        params.put("commentId", commentId);
        params.put("fileId", fileId);

        return jdbc.update(INSERT_IMAGE, params);
    }

}
