package com.example.demojee.controller;

import com.example.demojee.entity.Personne;
import com.example.demojee.entity.Product;
import com.example.demojee.inderfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/get")
    public List<Product> getProduct(){return productService.getProducts();}

    @PostMapping("/post")
    public Product postProduct(@RequestParam String nom, @RequestParam Double price, @RequestParam String ref, @RequestParam int qty){
        return new Product(1,nom,price,ref,qty,new Date());
    }





}
