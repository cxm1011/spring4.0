package factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法即先需要创建工厂本身，再调用工厂的实例方法来返回Bean的实例
 */
public class InstanceCarFactory {

    private Map<String,Car> cars = null;

    public InstanceCarFactory(){
        cars = new HashMap<String, Car>();
        cars.put("audi",new Car("audi",3000000));
        cars.put("bmw",new Car("bmw",5000000));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }

}
