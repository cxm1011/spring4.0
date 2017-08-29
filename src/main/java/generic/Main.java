package generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-generic.xml");
        UserService userService = (UserService)ctx.getBean("userService");
        userService.add();
    }
}
