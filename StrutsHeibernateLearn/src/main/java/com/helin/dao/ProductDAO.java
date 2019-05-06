package com.helin.dao;

import com.helin.pojo.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

    public void add(Product p) {

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        Transaction transaction = s.beginTransaction();
        s.save(p);
        transaction.commit();
        s.close();
        sf.close();
    }

    public Product get(int id) {
        Product result;

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        result =  s.get(Product.class, id);

        s.close();
        sf.close();
        return result;
    }

    public void delete(int id) {
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        Transaction tran = s.beginTransaction();
        Product p = s.get(Product.class, id);
        s.delete(p);
        tran.commit();
        s.close();
        sf.close();
    }

    public void update(Product p) {
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        Transaction tran = s.beginTransaction();
        s.update(p);

        tran.commit();
        s.close();
        sf.close();
    }

    public List<Product> listProduct() {
        List<Product> result;

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Product p");

        result = q.list();

        s.close();
        sf.close();
        return result;
    }
}