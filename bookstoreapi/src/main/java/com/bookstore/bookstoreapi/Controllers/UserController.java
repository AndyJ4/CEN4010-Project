package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Entities.User;
import com.bookstore.bookstoreapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users/search")
    public List<User> searchUsers(@RequestParam("query") String query){
        return userRepository.searchUsers(query);
    }

    @PostMapping(value = "/api/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/api/users/update/{username}")
    public User updateUser (@PathVariable String username, @RequestBody User user){
        User userToUpdate = userRepository.getReferenceByUsername(username);
        userToUpdate.setUsername(username);
        userToUpdate.setName(user.getName());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setPassword(user.getPassword());

        return userRepository.save(userToUpdate);
    }


}
