package com.example.demo.Products;

import com.example.demo.Users.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends  CrudRepository<Products,Integer> {

}