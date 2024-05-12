package com.example.springboothw3.controller;

import com.example.springboothw3.model.Product;
import com.example.springboothw3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable int id){
        Product product=productService.getProductById(id);
        if(product!=null){
            return ResponseEntity.ok(product);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/name-start/{prefix}")
    public ResponseEntity<List<Product>>getProductByPrefix(@PathVariable String prefix){
        List<Product>searchByPrefix=productService.searchProduct(prefix);
        return ResponseEntity.ok(searchByPrefix);
    }
    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<List<Product>>getProductByPrice(@PathVariable int min,@PathVariable int max){
        List<Product> productsByPrice=productService.getProductsInRangeYear(min,max);
        return ResponseEntity.ok(productsByPrice);
    }
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductByBrand(@PathVariable String brand){
        List<Product>searchByBrand=productService.searchByBrand(brand);
        return ResponseEntity.ok(searchByBrand);
    }
    @GetMapping("/brand/{brand}/max-price")
    public ResponseEntity<Product> getMaxPriceProductOfBrand(@PathVariable String brand){
        Product product=productService.MaxPriceProductOfBrand(brand);
        return ResponseEntity.ok(product);
    }
}