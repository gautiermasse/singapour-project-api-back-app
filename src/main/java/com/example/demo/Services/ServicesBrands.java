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
public class ServicesBrands {

    private BrandsRepository brandsRepository;

    @Autowired
    public ServicesBrands(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }


    public Iterable<Brands> brandsList(){
        return brandsRepository.findAll();
    }

    public Optional<Brands> findById(Integer id){
        return brandsRepository.findById(id);
    }
    public Optional<Brands> findByName(String nameBrands){
        return brandsRepository.findByNameBrands(nameBrands);
    }

    public Brands AddNewBrands(String nameBrands){

        if(!brandsRepository.findByNameBrands(nameBrands).isPresent()){
            Brands myNewBrands = new Brands(nameBrands);
            System.out.println(myNewBrands);
            brandsRepository.save(myNewBrands);
            return myNewBrands;
        }else {
            return null;
        }
    }
}
