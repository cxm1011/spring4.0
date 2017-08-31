package logging.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
    //定义一个方法，用于声明切入点表达式。一般不在需要添加其它方法
    //使用@Pointcut 来声明切入点表达式
    // 后面直接使用切入点表达式即可  不用每个都需要写 execution(public int logging.aop.impl.ArithmeticCalculartorImpl.*(int,int))
    @Pointcut("execution(public int logging.aop.impl.ArithmeticCalculartorImpl.*(int,int))")
    public void declareJointPointExpression(){

    }
    //声明该方法是一个前置通知。在目标方法开始之前执行
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins:"+methodName+"   args:"+args);
    }

    //后置通知：在目标方法执行后执行的通知。无论是否发生异常都会执行
    //在后置通知中还不能返回目标方法执行的结果
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends:"+methodName+"   args:"+args);
    }

    //在方法正常结束执行的代码
    //可以返回方法的返回值
    @AfterReturning(value = "declareJointPointExpression()",returning = "res")
    public void afterReturning(JoinPoint joinPoint,Object res){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends:"+methodName+"   args:"+args+" result："+res);
    }

    //在目标方法出现异常时会执行的代码
    //可以访问异常，且可以指定特定的异常
    @AfterThrowing(value = "declareJointPointExpression()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+"   occurs excetion:"+ex);
    }

    //环绕通知需要携带ProceedingJoinPoint类型的参数
    //环绕通知类似于动态代理的全过程 ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
    //且环绕通知必须有返回值。返回值即为目标方法的返回值
    @Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object res = null;
        String methodName = pjd.getSignature().getName();
        //执行目标方法
        try{
            //前置通知
            System.out.println("The method begins:"+methodName+"   args:"+Arrays.asList(pjd.getArgs()));
            res = pjd.proceed();
            //返回通知
        }
        catch (Throwable e){
            //异常通知
            e.printStackTrace();
        }
        //后置通知
        return res;
    }
}
