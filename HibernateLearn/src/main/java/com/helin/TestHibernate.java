package com.helin;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.helin.pojo.Product;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

import org.hibernate.Query;
import java.util.Iterator;
import java.util.List;


public class TestHibernate
{
    public static void main( String[] args )
    {
        // 1 普通增删改查
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        OpenSession每次都会得到一个新的Session对象，如果是同一个线程(本例是在主线程里)，getCurrentSession每次获取的都是相同的Session
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tran = session.beginTransaction();
//         插入
//        for(int i=0;i<10;i++){
//            Product product = new Product();
//            product.setName("helin"+i);
//            product.setPrice(999909);
//            session.save(product);
//        }
//        //获取,get与load的区别，get是非延迟加载
//        Product product = (Product) session.get(Product.class,6);
//        Product product = (Product) session.load(Product.class,6);
//        System.out.println("log1");
//        当开启lazy时，获取属性才访问数据库
//        System.out.println(product.getName());
//        System.out.println("log1");
          //删除
//        session.delete(product);
////         获取更新
//        product.setName("韩瑞");
//        session.update(product);

        // 2 hql 批量查询
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tran = session.beginTransaction();
//        String name = "helin";
//        Query q = session.createQuery("from Product p where p.name like ?");
//        ((org.hibernate.query.Query) q).setString(0,"%"+name+"%");
//        List<Product> productList = q.list();
//        for(Product product:productList){
//            System.out.println(product.getName());
//        }

//        // 3 criteria 批量查询
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tran = session.beginTransaction();
//        Criteria criteria = session.createCriteria(Product.class);
//        String name = "helin";
//        criteria.add((Restrictions.like("name","%"+name+"%")));
//        List<Product> productList = criteria.list();
//        for(Product product:productList){
//            System.out.println(product.getName());
//        }

        // 4 使用标准sql查询
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tran = session.beginTransaction();
//        String name = "helin";
//        String sql = "select * from product_ p where p.name like '%"+ name+"%'";
//        NativeQuery query = session.createNativeQuery(sql);
//        List<Object[]> list = query.getResultList();
//        for (Object[] os :list){
//            for (Object filed:os){
//                System.out.println(filed+"\t");
//            }
//        }

//         5 使用标准sql查询，迭代对象
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        String name = "helin";
        String sql = "from Product p where p.name like ?";
        Query query = session.createQuery(sql);
        query.setString(0, "%"+name+"%");
        Iterator<Product> it = query.iterate();
        while(it.hasNext()){
            Product p =it.next();
            System.out.println(p.getName());
        }
        // 6 查询总数
        Query q =session.createQuery("select count(*) from Product p where p.name like ?");
        q.setString(0, "%"+name+"%");
        long total= (Long) q.uniqueResult();
        System.out.println(total);

        tran.commit();
        session.close();
        sessionFactory.close();
    }
}
