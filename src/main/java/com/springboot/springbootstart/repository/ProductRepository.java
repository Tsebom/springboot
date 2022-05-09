package com.springboot.springbootstart.repository;

import com.springboot.springbootstart.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    public ProductRepository() {
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(int id) {
        for (Product p: productList) {
            if (p.getId() == id) {
                productList.remove(p);
                return;
            }
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductById(int id) {
        Product product = null;

        for (Product p: productList) {
            if (p.getId() == id) {
                product = p;
            }
        }
        return product;
    }
}
