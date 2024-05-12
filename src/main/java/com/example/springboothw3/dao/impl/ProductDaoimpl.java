package com.example.springboothw3.dao.impl;

import com.example.springboothw3.dao.ProductDAO;
import com.example.springboothw3.database.ProductDB;
import com.example.springboothw3.model.Product;
import com.example.springboothw3.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class ProductDaoimpl implements ProductDAO {
    @Override
    public List<Product> findAll(){
        return ProductDB.products;
    }
    @Override
    public Product findByID(int id){
        for (Product product:ProductDB.products){
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }
    @Override
    public List<Product>searchProduct(String prefix){
        List<Product>result=new ArrayList<>();
        for (Product product : ProductDB.products) {
            if(product.getName().toLowerCase().startsWith(prefix.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
    @Override
    public List<Product>getProductsInRangeYear(int min,int max){
        List<Product>result=new ArrayList<>();
        for (Product product : ProductDB.products) {
            if(product.getPrice()<=max&&product.getPrice()>=min){
                result.add(product);
            }
        }
        return result;
    }
    @Override
    public List<Product>searchByBrand(String brand){
        List<Product>result=new ArrayList<>();
        for(Product product:ProductDB.products){
            if(product.getBrand().toLowerCase().equals(brand.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
    @Override
    public Product MaxPriceProductOfBrand(String brand){
        ProductDB.products.sort(new Comparator<Product>(){
            @Override
            public int compare(Product o1,Product o2){
                return o2.getPrice()-o1.getPrice();
            }
        });
        for(Product product:ProductDB.products){
            if(product.getBrand().toLowerCase().equals(brand.toLowerCase())){
                return product;
            }
        }
        return null;
    }
}
