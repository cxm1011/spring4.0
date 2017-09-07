package jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class JDBCTest {

   private ApplicationContext ctx = null;
   private JdbcTemplate jdbcTemplate;
   private GirlDao girlDao;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext_JDBC.xml");
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        girlDao = ctx.getBean(GirlDao.class);
    }
   @Test
   public void testGirlDao(){
       System.out.println(girlDao.get(6));
   }

   @Test
   public void testDataSource() throws SQLException{
       DataSource dataSource = (DataSource)ctx.getBean("dataSource");
       System.out.println(dataSource.getConnection());
   }
    @Test
   public void testUpdate(){
       String sql = "update girl set age=? where id=?";
       jdbcTemplate.update(sql,99,6);
   }

   /*

     批量插入
    */
    @Test
    public void testBatchUpdate(){
       String sql="insert into girl(name,height,age) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();

        batchArgs.add(new Object[]{"vcm",190,29});
        batchArgs.add(new Object[]{"aasd",132,1239});
        batchArgs.add(new Object[]{"sadm",154,1239});

        jdbcTemplate.update(sql,batchArgs);

   }

   /*
   从数据库中获取一条记录，得到对应的对象
   注意调用的是jdbcTemplate. queryForObject(String sql, RowMapper<T> rowMapper,Object...args).
   查集合则直接使用query方法
    */
   @Test
    public void testQueryForObject(){
       String sql = "select id,name,height,age from Girl where id=?";
       RowMapper<Girl> rowMapper=new BeanPropertyRowMapper<Girl>(Girl.class);
       Girl girl = jdbcTemplate.queryForObject(sql,rowMapper,3);
       System.out.println(girl);
   }

   /*
   统计数据总数
    */
    @Test
    public void testCount(){
        String sql = "select count(id) from Girl ";
        long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

}
