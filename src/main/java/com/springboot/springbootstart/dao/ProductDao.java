package com.springboot.springbootstart.dao;

import com.springboot.springbootstart.entity.Product;

import java.util.List;

public interface ProductDao {

    Product saveOrUpdate(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}
