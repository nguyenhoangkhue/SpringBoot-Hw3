package com.example.springboothw3.dao;

import com.example.springboothw3.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product>findAll();
    Product findByID(int id);
    List<Product>searchProduct(String prefix);
    List<Product>getProductsInRangeYear(int min,int max);
    List<Product>searchByBrand(String brand);
    Product MaxPriceProductOfBrand(String brand);
}
