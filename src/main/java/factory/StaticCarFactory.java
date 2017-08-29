package factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法，直接调用某一个类的实例就可以返回Bean的实例
 */
public class StaticCarFactory {
    private static Map<String,Car> cars = new HashMap<String, Car>();

    static{
        cars.put("audi",new Car("audi",3000000));
        cars.put("bmw",new Car("bmw",5000000));
    }

    //静态工厂方法
    public static Car getCar(String name){
        return cars.get(name);
    }
}
