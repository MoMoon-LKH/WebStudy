package play.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import play.dto.CommentEntity;
import play.dto.FileEntity;

import javax.sql.DataSource;

@Repository
public class FileDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insert;

    public FileDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("file_info")
                .usingGeneratedKeyColumns("id");
    }

    public int insertFile(MultipartFile file, String createDate, String modifyDate) {
        FileEntity fileEntity = new FileEntity(file, createDate, modifyDate);

        SqlParameterSource params = new BeanPropertySqlParameterSource(fileEntity);
        return insert.executeAndReturnKey(params).intValue();
    }

}
