package logging.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chen on 2017/8/30.
 */
//把这个类声明为一个切面：需要把该类放入IOC容器中：@Component ，再声明为一个切面：@Aspect
@Aspect
@Component
public class LoggingAspect {
    //声明该方法是一个前置通知。在目标方法开始之前执行
    @Before("execution(public int logging.aop.impl.ArithmeticCalculartorImpl.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins:"+methodName+"   args:"+args);
    }

    //后置通知：在目标方法执行后执行的通知。无论是否发生异常都会执行
    //在后置通知中还不能返回目标方法执行的结果
    @After("execution(public int logging.aop.impl.ArithmeticCalculartorImpl.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends:"+methodName+"   args:"+args);
    }

    //在方法正常结束执行的代码
    //可以返回方法的返回值
    @AfterReturning(value = "execution(public int logging.aop.impl.ArithmeticCalculartorImpl.*(int,int))",returning = "res")
    public void afterReturning(JoinPoint joinPoint,Object res){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends:"+methodName+"   args:"+args+" result："+res);
    }
}
