package com.example.demo.Products;

import com.example.demo.Brands.Brands;
import com.example.demo.CategoriesSports.CategoriesSports;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="CatSport_id")
    private CategoriesSports categoriesSports;

    @ManyToOne
    @JoinColumn(name="brands_id")
    private Brands brands;

    private String vDesc;

    private String name;
    private float price;

    public Products(){

    }
    public Products(String desc, String name, float price, Brands brands, CategoriesSports myCategoriesSports) {
        this();
        this.vDesc = desc;
        this.name = name;
        this.price = price;
        this.brands = brands;
        this.categoriesSports = myCategoriesSports;
    }

    public int getId() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoriesSports(CategoriesSports categoriesSports) {
        this.categoriesSports = categoriesSports;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public void setvDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
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
