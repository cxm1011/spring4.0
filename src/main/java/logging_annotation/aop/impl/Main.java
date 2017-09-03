package logging_annotation.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/28.
 */
public class Main {
    public static void main(String[] args){
        //创建spring IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_annotation.xml");

        //从IOC容器获取bean的实例
        ArithmeticCalculartor arithmeticCalculartor = ctx.getBean(ArithmeticCalculartor.class);

        //使用bean

        int res = arithmeticCalculartor.add(2,3);
        System.out.println(res);

        res = arithmeticCalculartor.div(2,3);
        System.out.println(res);
    }
}
