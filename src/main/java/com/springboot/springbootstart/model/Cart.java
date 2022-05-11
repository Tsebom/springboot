package com.springboot.springbootstart.model;

import com.springboot.springbootstart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Scope("prototype")
public class Cart {
    private final Map<Long, Product> productCart = new HashMap<>();

    @Autowired
    private ProductRepository productRepository;

    public Map<Long, Product> getProductCart() {
        return productCart;
    }

    public void printCart() {
        for (Map.Entry<Long, Product> entry: productCart.entrySet()) {
            Product p = entry.getValue();
            System.out.println(p.getTitle() + ": " + p.getCost());
        }
    }

    public void addProduct(Product product) {
        productCart.put(product.getId(), product);
    }

    public void removeProduct(Product product) {
        productCart.remove(product.getId());
    }
}
