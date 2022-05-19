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
public class GetListCustomersOfProductControllers {

    @Autowired
    private InfoService infoService;

    @GetMapping("/get_customers")
    public String getProductListPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "get_customers";
    }

    @PostMapping("/get_customers")
    public String getProducts(Product product, Model model) {
        Product searchProduct = new Product();
        model.addAttribute("product", searchProduct);
        List<Customer> list = infoService.getCustomerListOfProduct(product.getId());
        model.addAttribute("list", list);
        return "get_customers";
    }
}
