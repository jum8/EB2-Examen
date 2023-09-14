package com.example.msusers.controller;

import com.example.msusers.domain.User;
import com.example.msusers.dto.UserBills;
import com.example.msusers.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("{id}")
    public UserBills findById(@PathVariable String id) {
        return userService.findUserBillsByUserId(id);
    }


}
