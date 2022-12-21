package com.example.demojee.service;

import com.example.demojee.entity.Product;
import com.example.demojee.inderfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Override
    public List<Product> getProducts() {
        return Arrays.asList(new Product(1,"Salade",1.00,"EEEEE",5,new Date(01/01/2000)),new Product(2,"Tomate",1.00,"EEEEE",5,new Date(01/01/2000)),new Product(3,"Oignons",1.00,"EEEEE",5,new Date(01/01/2000)));
    }
}
