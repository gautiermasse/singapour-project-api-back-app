package com.example.demo.Brands;

import com.example.demo.Products.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BrandsRepository extends CrudRepository<Brands,Integer> {

    Optional <Brands> findByNameBrands(String nameBrands);
}
