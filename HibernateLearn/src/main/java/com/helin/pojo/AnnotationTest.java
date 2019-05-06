package com.helin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity 表示这是一个实体类，用于映射表
//@Table(name = "product_") 表示这是一个类，映射到的表名:product_
@Entity
@Table(name = "Annotation_")
public class AnnotationTest {

    int id;
    String name;
    float price;

//    @Id 表示这是主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增长方式使用mysql自带的
//    @Column(name = "id") 表示映射到字段id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "price")
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

}
