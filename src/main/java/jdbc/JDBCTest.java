package jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

   private ApplicationContext ctx = null;
   private JdbcTemplate jdbcTemplate;
   private GirlDao girlDao;
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext_JDBC.xml");
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        girlDao = ctx.getBean(GirlDao.class);
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate)ctx.getBean("namedParameterJdbcTemplate");
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


    /*
    可以为参数取名字。好处：若有多个参数，则不用去对应位置，直接对应参数名，易维护
    缺点：较为麻烦
     */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "insert into girl(id,name,height,age) values(:id,:named,:height,:age)";
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id",10);
        paramMap.put("named","cxm2");
        paramMap.put("height",190);
        paramMap.put("age",29);
        namedParameterJdbcTemplate.update(sql,paramMap);
    }

    /*
   使用具名参数时可以使用 update(String sql, SqlParameterSource paramSource)方法进行更新操作
   使用BeanPropertySqlParameterSource实现类作为参数
     */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "insert into girl(id,name,height,age) values(:id,:name,:height,:age)";
        Girl girl = new Girl();
        girl.setId(11);
        girl.setAge(13);
        girl.setHeight(111);
        girl.setName("hc");

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(girl);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }
}
