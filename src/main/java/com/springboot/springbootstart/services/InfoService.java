package com.springboot.springbootstart.services;

import com.springboot.springbootstart.entity.Customer;
import com.springboot.springbootstart.entity.Product;
import com.springboot.springbootstart.session.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfoService extends SessionUtil {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    public List<Product> getProductListOfCustomer(Long id) {
        return customerService.findById(id).getProducts();
    }

    public List<Customer> getCustomerListOfProduct(Long id) {
        return productService.findById(id).getCustomers();
    }
}
