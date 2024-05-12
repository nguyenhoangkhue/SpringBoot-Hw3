package com.example.springboothw3.untils.file;

import com.example.springboothw3.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}
