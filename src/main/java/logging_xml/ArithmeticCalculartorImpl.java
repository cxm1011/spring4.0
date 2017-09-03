package logging_xml;

/**
 * Created by chen on 2017/8/27.
 */
public class ArithmeticCalculartorImpl implements ArithmeticCalculartor {
    public int add(int i, int j) {
        int res = i+j;
        return res;
    }

    public int sub(int i, int j) {
        int res = i-j;
        return res;
    }

    public int mul(int i, int j) {
        int res = i*j;
        return res;
    }

    public int div(int i, int j) {
        int res = i/j;
        return res;
    }
}
