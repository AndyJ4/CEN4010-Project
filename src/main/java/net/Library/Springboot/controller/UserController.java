package net.Library.Springboot.controller;

import net.Library.Springboot.entity.User1;
import net.Library.Springboot.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<User1>> searchUsers(@RequestParam("query") String query){
        return ResponseEntity.ok(userService.searchUsers(query));
    }

    @PostMapping
    public User1 createUser(@RequestBody User1 user){
        return userService.createUser(user);
    }
}
