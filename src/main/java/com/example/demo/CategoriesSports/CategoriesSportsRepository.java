package com.example.demo.CategoriesSports;

import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriesSportsRepository  extends CrudRepository<CategoriesSports,Integer> {

    Optional <CategoriesSports> findById(Integer id);

    Optional <CategoriesSports> findByNameOfCatSport(String name);
}
