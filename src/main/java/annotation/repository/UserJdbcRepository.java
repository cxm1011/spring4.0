package annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by chen on 2017/8/26.
 */
@Repository
public class UserJdbcRepository implements UserRepository {
    public void save() {
        System.out.println("UserJdbcRepository save...");
    }
}
