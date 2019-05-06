package com.helin.pojo;


import javax.persistence.*;

@Entity
@Table(name = "NewProduct")
public class Product {

    private int id;
    private String name;
    private float price;
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
        System.out.println(name);

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