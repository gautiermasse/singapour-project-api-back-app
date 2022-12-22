package com.example.demo.Products;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    private static final String template = "Hello, %s!";


    @GetMapping("/")
    public List<String> home(){
        return List.of("Welcome","to","the","homepage");
    }
    @GetMapping("/toto")
    public Products products(@RequestParam(value = "name") String name){
        return new Products(1,String.format(template,name));
    }

    @GetMapping("/product")
    public Products OneProduct(@RequestParam(value = "id") String id){
        return new Products(2,"Test");
    }



}
