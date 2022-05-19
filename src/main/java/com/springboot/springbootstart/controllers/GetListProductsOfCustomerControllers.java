package com.springboot.springbootstart.controllers;

import com.springboot.springbootstart.entity.Customer;
import com.springboot.springbootstart.entity.Product;
import com.springboot.springbootstart.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GetListProductsOfCustomerControllers {

    @Autowired
    private InfoService infoService;

    @GetMapping("/get_products")
    public String getProductListPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "get_products";
    }

    @PostMapping("/get_products")
    public String getProducts(Customer customer, Model model) {
        Customer searchCustomer = new Customer();
        model.addAttribute("customer", searchCustomer);
        List<Product> list = infoService.getProductListOfCustomer(customer.getId());
        model.addAttribute("list", list);
        return "get_products";
    }
}
