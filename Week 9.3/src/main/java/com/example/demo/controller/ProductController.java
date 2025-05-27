package com.example.demo.controller;

import com.example.demo.exception.ProductErrorResponse;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/display/{id}")
    public Product display(@PathVariable int id) {
        System.out.println(id+"=====================================");
        if (id <= 0) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }

        Product product = productService.getProduct(id);

        if (product == null) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }

        return product;

    }
    @GetMapping("/displayAllProduct")
    public List<Product> displayAllProducts() {

       List<Product> products =productService.getProducts();
        return products;

    }
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);

    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleProductNotFound(ProductNotFoundException ex){
        ProductErrorResponse error = new ProductErrorResponse();
        error.setMessage(ex.getMessage());
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

}
