package logging_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chen on 2017/8/30.
 */

public class LoggingAspect {


    public void declareJointPointExpression(){

    }

    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins:"+methodName+"   args:"+args);
    }


    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends:"+methodName+"   args:"+args);
    }


    public void afterReturning(JoinPoint joinPoint,Object res){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method ends:"+methodName+"   args:"+args+" result："+res);
    }


    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+"   occurs excetion:"+ex);
    }


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
