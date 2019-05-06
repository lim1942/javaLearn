package com.helin;

import com.helin.pojo.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.helin.service.ProductService;

import com.helin.pojo.Category;

public class TestSpring {

//    public static void main(String[] args) {

//        1 测试测试获取反转对象
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[] { "applicationContext.xml" });
//
//        Category c = (Category) context.getBean("c");
//
//        System.out.println(c.getName());
//    }

//    2 测试测试获取注入对象
//    public static void main(String[] args) {
//    ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
//    Product p = (Product) context.getBean("p");
//    System.out.println(p.getName());
//    System.out.println(p.getCategory().getName());
//}

//    3 测试aop编程
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
            ProductService s = (ProductService) context.getBean("s");
            s.doSomeService();
        }
    }
