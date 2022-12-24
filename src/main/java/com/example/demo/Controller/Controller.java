package com.example.demo.Controller;


import com.example.demo.Products.Products;
import com.example.demo.Products.ProductsRepository;
import com.example.demo.Users.Users;
import com.example.demo.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/api")
public class Controller {

    private static final String template = "Hello, %s!";
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ProductsRepository productsRepository;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UsersRepository userRepository;

    @GetMapping("/products/all")
    public Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public @ResponseBody Optional<Products> getOneProductsById(@PathVariable Integer id) {
        //return productsRepository.findById();
        System.out.println("[DEBUG] -> Recuperation id : getOneProductsById");
        return productsRepository.findById(id);
    }

    @PostMapping(path = "/product/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String desc,@RequestParam Float price) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Products newProduct = new Products(desc,name,price);
        productsRepository.save(newProduct);
        return "Saved";
    }

    @GetMapping(path = "/users/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }


    }