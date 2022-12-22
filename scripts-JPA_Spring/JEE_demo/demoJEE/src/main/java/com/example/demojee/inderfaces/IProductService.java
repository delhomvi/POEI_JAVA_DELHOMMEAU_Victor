package com.example.demojee.inderfaces;

import com.example.demojee.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getProducts();
    public List<Product> getProductsFromDB();

    void begin();

    boolean create(Product o);

    boolean update(Product o);

    boolean delete(Product o);

    Product findById(int id);

    void envoie();

    void close();
}
