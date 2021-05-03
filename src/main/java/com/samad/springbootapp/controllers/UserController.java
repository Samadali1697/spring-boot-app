package com.samad.springbootapp.controllers;

import com.samad.springbootapp.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserController {
    private List<User> users = new ArrayList<>();
    private AtomicInteger userId = new AtomicInteger();

    @GetMapping("/api/user")
    public String getHelloMessage(
        @RequestParam("name") String username
    ) {
        return String.format("hello %s!", username);
    }

    @PostMapping("/api/user")
    public User saveUser(
        @RequestBody User user
    ) {
        user.setId(userId.incrementAndGet());

        users.add(user);
        return user;
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return users;
    }
}
