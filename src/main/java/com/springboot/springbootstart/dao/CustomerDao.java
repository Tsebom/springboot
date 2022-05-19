package com.springboot.springbootstart.dao;

import com.springboot.springbootstart.entity.Customer;
import com.springboot.springbootstart.entity.Product;

import java.util.List;

public interface CustomerDao {

    Customer saveOrUpdate(Customer customer);

    Customer findById(Long id);

    List<Customer> findAll();

    void deleteById(Long id);
}
