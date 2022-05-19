package com.springboot.springbootstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", "Manager of products");
        model.addAttribute("customers", "Manager of customers");
        model.addAttribute("get_products", "Get products by customer ID");
        model.addAttribute("get_customers", "Get customers by product ID");
        return "index";
    }
}
