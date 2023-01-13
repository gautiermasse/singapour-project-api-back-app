package com.example.demo.Services;

import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;
import com.example.demo.CategoriesSports.CategoriesSports;
import com.example.demo.CategoriesSports.CategoriesSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicesCategoriesSports {

    private CategoriesSportsRepository categoriesSportsRepository;
    @Autowired
    public ServicesCategoriesSports(CategoriesSportsRepository categoriesSportsRepository) {
        this.categoriesSportsRepository = categoriesSportsRepository;
    }

    public Iterable<CategoriesSports> categoriesSportsList(){
        return categoriesSportsRepository.findAll();
    }

    public Optional<CategoriesSports> findById(Integer id){
        return categoriesSportsRepository.findById(id);
    }

    public CategoriesSports addNewCategoriesSports(String nameCategoriesSports){
        System.out.println(categoriesSportsRepository.findByNameOfCatSport(nameCategoriesSports).isPresent());
        if(!categoriesSportsRepository.findByNameOfCatSport(nameCategoriesSports).isPresent()){
            CategoriesSports myNewCategoriesSports = new CategoriesSports(nameCategoriesSports);
            System.out.println(myNewCategoriesSports);
            categoriesSportsRepository.save(myNewCategoriesSports);
            return myNewCategoriesSports;
        }else {
            return null;
        }
    }

}
