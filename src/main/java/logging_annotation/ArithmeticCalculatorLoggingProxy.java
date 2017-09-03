package logging_annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by chen on 2017/8/27.
 */
public class ArithmeticCalculatorLoggingProxy {
    //要代理的对象
    private ArithmeticCalculartor target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculartor target) {
        this.target = target;
    }

    public ArithmeticCalculartor getLoggingProxy(){
        ArithmeticCalculartor proxy = null;

        //代理对象由哪个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        Class [] interfaces = new Class[]{ArithmeticCalculartor.class};
        //当调用代理对象其中的方法时，该执行的方法
        InvocationHandler h = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("The method"+methodName+"begin with"+ Arrays.asList(args));
                //执行方法
                Object res = null;
                try{
                    //前置通知
                    res = method.invoke(target,args);
                    //返回通知
                }catch (Exception e){
                    e.printStackTrace();
                    //异常通知
                }
                //后置通知
                System.out.println("The method"+methodName+"ends with"+res);
                return 0;
            }
        };
        proxy = (ArithmeticCalculartor)Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
