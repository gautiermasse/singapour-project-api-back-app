package com.example.demo.CategoriesSports;

import com.example.demo.Products.Products;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class CategoriesSports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "categoriesSports")
    private List<Products> products;

    @Column(name = "nameOfCatSport" )
    private String nameOfCatSport;

    public CategoriesSports() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getNameOfCatSport() {
        return nameOfCatSport;
    }

    public void setNameOfCatSport(String nameOfCatSport) {
        this.nameOfCatSport = nameOfCatSport;
    }

    public CategoriesSports(String nameCategoriesSports) {
        this.nameOfCatSport = nameCategoriesSports;
    }

    @Override
    public String toString() {
        return "CategoriesSports{" +
                "id=" + id +
                ", products=" + products +
                ", nameOfCatSport='" + nameOfCatSport + '\'' +
                '}';
    }
}
