package com.example.demo.Controller;


import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;
import com.example.demo.CategoriesSports.CategoriesSports;
import com.example.demo.CategoriesSports.CategoriesSportsRepository;
import com.example.demo.Products.Products;
import com.example.demo.Products.ProductsRepository;
import com.example.demo.Services.ServicesProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/api/products")
public class ControllerProducts {

    @Autowired
    private ServicesProducts servicesProducts;

    @GetMapping("/all") // OK
    public @ResponseBody Iterable<com.example.demo.Products.Products> getAllProducts() {
        System.out.println(servicesProducts.productsList());
        return servicesProducts.productsList();
    }

    @GetMapping("/{id}") // OK
    public @ResponseBody Optional<com.example.demo.Products.Products> getOneProductsById(@PathVariable Integer id) {
        return servicesProducts.findById(id);
    }

    @PostMapping(path = "/add") // NOK
    public @ResponseBody Optional<com.example.demo.Products.Products> addNewProducts(@RequestParam String name, @RequestParam String desc, @RequestParam Float price, @RequestParam int brands_id, @RequestParam int catSport_id) {
        Products myNewProducts = servicesProducts.AddNewProducts(desc,name,price,brands_id,catSport_id);
        return Optional.ofNullable(myNewProducts);
    }

}
