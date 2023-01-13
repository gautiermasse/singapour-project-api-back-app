package com.example.demo.Controller;

import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;
import com.example.demo.CategoriesSports.CategoriesSports;
import com.example.demo.Products.Products;
import com.example.demo.Services.ServicesBrands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@org.springframework.stereotype.Controller
@RequestMapping(path = "/api/brands/")
public class ControllerBrands {

    @Autowired
    private ServicesBrands servicesBrands;
    @GetMapping("/all")
    public @ResponseBody Iterable<Brands> getAllBrands() {
        System.out.println(servicesBrands.brandsList());
        return servicesBrands.brandsList();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Brands> getOneBrandsById(@PathVariable Integer id) {
        return servicesBrands.findById(id);
    }

    @PostMapping(path = "/add") // NOK
    public @ResponseBody Optional<Brands> addNewProducts(@RequestParam String nameBrands) {
        Brands myNewBrands = servicesBrands.AddNewBrands(nameBrands);
        return Optional.ofNullable(myNewBrands);
    }

    @DeleteMapping("/del/{id}") // OK
    public @ResponseBody Boolean delOneProductsById(@PathVariable Integer id) {
        return servicesBrands.delById(id);
    }

}
