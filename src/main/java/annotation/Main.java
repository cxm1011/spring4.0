package annotation;

import annotation.controller.UserController;
import annotation.repository.UserRepository;
import annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//        TestObject to = (TestObject)ctx.getBean("testObject");
//        System.out.println(to);
//
        UserController userController = (UserController)ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();
        UserService userService = (UserService)ctx.getBean("userService");
        System.out.println(userService);
        UserRepository userRepository = (UserRepository)ctx.getBean("userRepositoryImpl");
        System.out.println(userRepository);

    }
}
