package generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chen on 2017/8/26.
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add");
        System.out.println(repository);
    }
}
