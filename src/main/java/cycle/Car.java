package cycle;

/**
 * Created by chen on 2017/8/22.
 */
public class Car {
    public Car(){
        System.out.println("car's constructor...");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public void init(){
        System.out.println("init....");
    }

    public void destroy(){
        System.out.println("destory...");
    }
}
