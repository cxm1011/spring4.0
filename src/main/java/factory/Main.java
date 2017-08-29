package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/23.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
        Car car = (Car)ctx.getBean("car");
        System.out.println(car);

        Car car3 = (Car)ctx.getBean("car3");
        System.out.println(car3);
    }
}
