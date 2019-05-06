package com.helin;

import com.helin.pojo.AnnotationTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateAnnotation {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();

        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.setName("helin122");
        session.save(annotationTest);

        tran .commit();
        session.close();
        sessionFactory.close();
    }
}
