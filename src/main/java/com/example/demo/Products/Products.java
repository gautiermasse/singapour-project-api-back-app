package com.example.demo.Products;

import jakarta.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String vDesc;

    private String name;
    private float price;

    public Products() {
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return vDesc;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Products( Integer id, String desc, String name, float price) {
        this.id = id ;
        this.vDesc = desc;
        this.name = name;
        this.price = price;
    }

    public Products( String desc, String name, float price) {
        this.vDesc = desc;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", desc='" + vDesc + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
