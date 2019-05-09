package com.example.service;

import com.example.Mapper.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getById(int id){
        return userMapper.getById(id);
    }
}