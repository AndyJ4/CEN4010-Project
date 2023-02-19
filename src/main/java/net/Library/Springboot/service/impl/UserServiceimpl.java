package net.Library.Springboot.service.impl;

import net.Library.Springboot.entity.User1;
import net.Library.Springboot.repository.UserRepository;
import net.Library.Springboot.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceimpl implements UserService {


    private UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User1> searchUsers(String query) {
        List<User1> users = userRepository.searchUsers(query);
        return users;
    }

    @Override
    public User1 createUser(User1 user) {
        return userRepository.save(user);
    }
}
