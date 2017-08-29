package collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/19.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Person person3 = (Person)ctx.getBean("person3");
        System.out.println(person3);

        MapPerson person4 = (MapPerson)ctx.getBean("mapPerson");
        System.out.println(person4);

        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        System.out.println(dataSource);

        Person personP = (Person)ctx.getBean("personP");
        System.out.println(personP);

    }
}
