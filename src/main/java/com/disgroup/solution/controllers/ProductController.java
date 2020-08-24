package com.disgroup.solution.controllers;

import com.disgroup.solution.interfaces.IProductService;
import com.disgroup.solution.models.Article;
import com.disgroup.solution.models.Product;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/product")
public class ProductController {
    private IProductService iProductService;

    public ProductController(IProductService iProductService){
        this.iProductService=iProductService;
    }
    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return iProductService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id){
        return iProductService.readProduct(id).orElseThrow(() ->new ResponseStatusException
                (HttpStatus.NOT_FOUND,"no entity found"));
    }


    @PutMapping
    public Product replaceProduct(@RequestBody Product product){
        return iProductService.updateProduct(product);
    }

    @DeleteMapping()
    public void deleteProduct(@RequestBody Product product){
        iProductService.deleteProduct(product);
    }

    @GetMapping("/all")
    public Iterable<Product> getSorted(@RequestParam(required=false) String fieldName,@RequestParam(required=false) String order){
        return iProductService.getSorted(fieldName,order);
    }

    @GetMapping(params = "name")
    public Iterable<Product> getByName(@RequestParam String name){
        return iProductService.filter(name,"name");
    }
    @GetMapping(params = "description")
    public Iterable<Product> getByContent(@RequestParam String description){
        return iProductService.filter(description,"description");
    }
    @GetMapping(params = "price")
    public Iterable<Product> getByPrice(Double price){
        return iProductService.filter(price.toString(),"price");
    }

}
