package com.example.demojee.controller;

import com.example.demojee.entity.Personne;
import com.example.demojee.entity.Product;
import com.example.demojee.inderfaces.IProductService;
import com.example.demojee.service.ProductService;
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
    ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        if(productService.create(product)){
            return product;
        }
        return null;
    }


    /*
    @Autowired
    private IProductService productService=new ProductService();

    @GetMapping("/get")
    public List<Product> getProduct(){return productService.getProducts();}

    @GetMapping("/getFromDB")
    public List<Product> getProductsFromDB(){
        productService.begin();
        List<Product> lp = productService.getProductsFromDB();
        productService.envoie();
        return lp;
    }

    @GetMapping("/getFromDB/{id}")
    public String getProductsFromDBbyID(@PathVariable Integer id){
        Product p = productService.findById(id);
        productService.envoie();
        return p.toString();
    }

    @PostMapping("/post")
    public Product postProduct(@RequestParam String nom, @RequestParam Double price, @RequestParam String ref, @RequestParam int qty){
        return new Product(1,nom,price,ref,qty,new Date());
    }



    // recup prod by id
    // supp
    // MAJ
    // ADD

     */




}
