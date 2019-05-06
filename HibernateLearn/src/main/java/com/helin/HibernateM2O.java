package com.helin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.helin.pojo.Category;
import com.helin.pojo.Product;

public class HibernateM2O {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();

        Category category = new Category();
        category.setName("cate1");
        session.save(category);

        Product product = session.get(Product.class,10);
        product.setCategory(category);
        session.update(product);

        tran .commit();
        session.close();
        sessionFactory.close();
    }
}
