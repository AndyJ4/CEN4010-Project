package net.Library.Springboot.service;

import net.Library.Springboot.entity.User1;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserService {

    List<User1> searchUsers(String query);

    User1 createUser(User1 user);
}
