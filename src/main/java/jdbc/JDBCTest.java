package jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class JDBCTest {

   private ApplicationContext ctx = null;
   private JdbcTemplate jdbcTemplate;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext_JDBC.xml");
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
    }
   @Test
   public void test(){
     fail("Not yet completed");
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

}
