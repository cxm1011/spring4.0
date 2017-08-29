package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/15.
 */
public class Main {
    public static void main(String[] args){
        //spring做前两步
//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("spring");
//        helloWorld.hello();

        //1创建Spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationConfig.xml");

        //2.从IOC容器获取Bean实例
        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
        //利用类名获取，要求该类名在xml中具有唯一性
        //HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.hello();

        //调用构造器方法的设置
        Car car = (Car)ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car)ctx.getBean("car2");
        System.out.println(car2);

        Person person = (Person)ctx.getBean("person");
        System.out.println(person);

        Person person2 = (Person)ctx.getBean("person2");
        System.out.println(person2);

    }
}
