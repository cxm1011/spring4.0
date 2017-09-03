package logging_annotation;

/**
 * Created by chen on 2017/8/27.
 */
public class Main {
    public static void main(String[] args){
        ArithmeticCalculartor target = null;
        target = new ArithmeticCalculartorImpl();

        ArithmeticCalculartor proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        int res = proxy.add(1,2);
        System.out.println(res);

        res = proxy.sub(1,2);
        System.out.println(res);

        res = proxy.div(1,2);
        System.out.println(res);


    }
}
