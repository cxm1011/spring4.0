package logging_annotation;

/**
 * Created by chen on 2017/8/27.
 */
public class ArithmeticCalculartorLoggingImpl {
    public int add(int i, int j) {
        System.out.println("the method add begin with["+i+","+j+"]");
        int res = i+j;
        System.out.println("the method add end with["+res);
        return res;
    }

    public int sub(int i, int j) {
        System.out.println("the method sub begin with["+i+","+j+"]");
        int res = i-j;
        System.out.println("the method sub end with["+res);
        return res;
    }

    public int mul(int i, int j) {
        System.out.println("the method mul begin with["+i+","+j+"]");
        int res = i*j;
        System.out.println("the method mul end with["+res);
        return res;
    }

    public int div(int i, int j) {
        System.out.println("the method div begin with["+i+","+j+"]");
        int res = i/j;
        System.out.println("the method div end with["+res);
        return res;
    }
}
