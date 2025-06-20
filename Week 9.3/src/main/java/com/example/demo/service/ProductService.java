package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product getProduct(int id);
    public Product addProduct(Product product);

}
