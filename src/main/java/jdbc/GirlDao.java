package jdbc;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by chen on 2017/9/7.
 */
@Repository
public class GirlDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Girl get(Integer id){
        String sql = "select id,name,height,age from Girl where id=?";
        RowMapper<Girl> rowMapper=new BeanPropertyRowMapper<Girl>(Girl.class);
        Girl girl = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return girl;
    }

}
