package com.helin.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("p")
public class Product {

    private int id;
    private String name="product 1";

    // 注解的方式
//    也可以在setCategory方法前加上@Autowired
//    除了@Autowired之外，@Resource也是常用的手段
    @Autowired
//    @Resource(name="c")
    private Category category;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}