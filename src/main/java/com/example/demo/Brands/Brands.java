package com.example.demo.Brands;

import com.example.demo.Products.Products;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "brands")
    private List<Products> products;

    @Column(name = "nameBrands" )
    private String nameBrands;
    public Brands() {
    }
    public Brands(String nameBrands) {
        this.nameBrands = nameBrands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getNameBrands() {
        return nameBrands;
    }

    public void setNameBrands(String nameBrands) {
        this.nameBrands = nameBrands;
    }
    @Override
    public String toString() {
        return "Brands{" +
                "id=" + id +
                ", products=" + products +
                ", nameBrands='" + nameBrands + '\'' +
                '}';
    }
}
