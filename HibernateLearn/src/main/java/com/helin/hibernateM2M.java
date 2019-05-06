package com.helin;

import java.util.*;

import com.helin.pojo.User;
import com.helin.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernateM2M {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();

        Set<User> users = new HashSet<>();
        for(int i=0;i<3;i++){
            User user = new User();
            user.setName("user"+i);
            users.add(user);
            session.save(user);
        }
        Product product = session.get(Product.class,19);
        product.setUsers(users);
        session.save(product);

        tran .commit();
        session.close();
        sessionFactory.close();
    }
}
