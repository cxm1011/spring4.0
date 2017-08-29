package annotation.service;

import annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by chen on 2017/8/26.
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;
    public void add(){
        System.out.println("UserService ADD...");
        userRepository.save();
    }
}
