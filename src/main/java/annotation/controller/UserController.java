package annotation.controller;

import annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by chen on 2017/8/26.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }
}
