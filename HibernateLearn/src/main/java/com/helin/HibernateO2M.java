package com.helin;


import com.helin.pojo.Category;
import com.helin.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class HibernateO2M {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        //设置1对多
//        Category category = session.get(Category.class,1);
//        Set<Product> products= category.getProducts();
//        for(Product product:products){
//            System.out.println(product.getName());
//        }
        // 级联删除
//        Category category = session.get(Category.class,2);
//        session.delete(category);

        //级联update
//        Category category = session.get(Category.class,1);
//        Product product1 = new Product();
//        product1.setName("save_update_01");
//        Product product2 = new Product();
//        product2.setName("save_update_02");
//        Product product3 = new Product();
//        product3.setName("save_update_03");
//        category.getProducts().add(product1);
//        category.getProducts().add(product2);
//        category.getProducts().add(product3);

        //开启二级缓存测试sql
        Category category1 = session.get(Category.class,1);
        System.out.println("log1");
        Category category2 = session.get(Category.class,1);
        System.out.println("log2");
        tran.commit();
        Session session2 = sessionFactory.openSession();
        Transaction tran2 = session2.beginTransaction();
        Category category3 = session2.get(Category.class,1);
        System.out.println("log3");


        tran2.commit();
        session.close();
        sessionFactory.close();
    }
}
