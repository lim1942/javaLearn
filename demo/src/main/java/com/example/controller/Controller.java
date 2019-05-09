package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index") //在类上使用RequestMapping，里面设置的value就是方法的父路径
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/hi")  //如果方法上的RequestMapping没有value，则此方法默认被父路径调用
    public String index(){
        return "hello spring boot";
    }
    @RequestMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") int userId){
        User user = userService.getById(userId);
        return user;
    }
}