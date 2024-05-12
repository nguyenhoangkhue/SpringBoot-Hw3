package com.example.springboothw3.service;

import com.example.springboothw3.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    List<Product> searchProduct(String prefix);
    List<Product> getProductsInRangeYear(int min, int max);
    List<Product> searchByBrand(String brand);
    Product MaxPriceProductOfBrand(String brand);
}
