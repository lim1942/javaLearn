package com.kevin.action;

import com.kevin.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserActionTest {

    @Test
    public void getUser() {
        UserAction userAction = new UserAction();
        Object c =  userAction.getUser();
        System.out.println(c);
    }

    @Test
    public void setUser() {
        User user = new User();
        user.setPassword("user2");
        user.setUsername("435");
        UserAction userAction = new UserAction();
        userAction.setUser(user);
        System.out.println(userAction.login());

    }

    @Test
    public void login() {
    }
}