package com.helin;

import com.helin.pojo.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class _1hibernatePage {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();

        Criteria criteria = session.createCriteria(Product.class);
        String name = "helin";
        criteria.add(Restrictions.like("name","%"+name+"%"));
        criteria.setFirstResult(2);
        criteria.setMaxResults(5);
        List<Product> products = criteria.list();
        for(Product product:products){
            System.out.println(product.getName());
        }

        tran .commit();
        session.close();
        sessionFactory.close();
    }
}
