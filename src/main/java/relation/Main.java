package relation;

import Autowired.Address;
import Autowired.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/21.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
//        Address address = (Address) ctx.getBean("address"); //抽象bean
//        System.out.println(address);

        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

    }
}
