package com.example.demo.Controller;

import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;
import com.example.demo.CategoriesSports.CategoriesSports;
import com.example.demo.Products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@org.springframework.stereotype.Controller
@RequestMapping(path = "/api/brands/")
public class ControllerBrands {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BrandsRepository brandsRepository;

    // GET ALL
    @GetMapping("/all")
    public @ResponseBody Iterable<Brands> getAllBrands() {
        System.out.println(brandsRepository.findAll());
        return brandsRepository.findAll();
    }

    // GET ONE BY ID
    // prevoir retour si il trouve rien différent de null.
    @GetMapping("/{id}")
    public @ResponseBody Optional<Brands> getOneBrandsById(@PathVariable Integer id) {
        return brandsRepository.findById(id);
    }

    // DELETE BY ID
    /*
    @DeleteMapping
    public @ResponseBody Optional<Brands> delOneBrandsById(@PathVariable Integer id) {

        Optional<Brands> myBrands = brandsRepository.findById(id);

        if(myBrands != null){

        }

        int toto = brandsRepository.delete( myBrands);

        return Optional.of(myBrands);
    }

     */

    // POST
    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody Optional<Brands> addNewProducts(@RequestParam  String nameBrands) {

        Brands myBrands = new Brands(nameBrands);
        // Rechercher si le nom n'existe pas déjà
        brandsRepository.save(myBrands);
        int id = myBrands.getId();
        return brandsRepository.findById(id);

    }
    // GET ONE BY NAME

    // GET ONE BY ID

    // SEARCH ALL BRAND WHO START BY XXX.
    //
}
