package com.example.demo.Services;

import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;
import com.example.demo.CategoriesSports.CategoriesSports;
import com.example.demo.CategoriesSports.CategoriesSportsRepository;
import com.example.demo.Products.Products;
import com.example.demo.Products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ServicesProducts {

    private ProductsRepository productsRepository;
    private final BrandsRepository brandsRepository;
    private final CategoriesSportsRepository categoriesSportsRepository;

    @Autowired
    public ServicesProducts(ProductsRepository productsRepository,
                            BrandsRepository brandsRepository,
                            CategoriesSportsRepository categoriesSportsRepository) {
        this.productsRepository = productsRepository;
        this.brandsRepository = brandsRepository;
        this.categoriesSportsRepository = categoriesSportsRepository;
    }

    public Iterable<Products> productsList(){
        return productsRepository.findAll();
    }

    public Optional<Products> findById(Integer id){
        return productsRepository.findById(id);
    }

    public Products AddNewProducts(String desc, String name, Float price, Integer myBrands, Integer myCategoriesSports){

        if(brandsRepository.findById(myBrands).isPresent() && categoriesSportsRepository.findById(myCategoriesSports).isPresent()){
            Brands mb = brandsRepository.findById(myBrands).get();
            CategoriesSports mCs = categoriesSportsRepository.findById(myCategoriesSports).get();
            Products products = new Products(desc, name, price, mb, mCs);
            System.out.println(products);
            productsRepository.save(products);
            return products;
        }else {
            return null;
        }
    }

    public Boolean delById(Integer id ){

        productsRepository.findById(id);
        System.out.println(productsRepository.findById(id).isPresent());
        if ( productsRepository.findById(id).isPresent()){
            productsRepository.delete(productsRepository.findById(id).get());
            return true ;
        }
        return false;
    }

    public Boolean delByName(String name ){

        productsRepository.findByName(name);
        System.out.println(productsRepository.findByName(name).isPresent());
        if ( productsRepository.findByName(name).isPresent()){
            productsRepository.delete(productsRepository.findByName(name).get());
            return true ;
        }
        return false;
    }
}
