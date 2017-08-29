package cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/22.
 */
public class Main {
    public static void  main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
        Car car = (Car)ctx.getBean("car");

        System.out.println(car);

        //关闭IOC容器
        ctx.close();
    }
}
