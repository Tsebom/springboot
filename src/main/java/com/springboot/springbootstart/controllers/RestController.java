package com.springboot.springbootstart.controllers;

import com.springboot.springbootstart.dao.ProductSpringDataJPA;
import com.springboot.springbootstart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestController {
    @Autowired
    private ProductSpringDataJPA productSpringDataJPA;

    private List<Product> productList;

    @GetMapping("/rest_products")
    public String pageManager(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("view", productList);
        return "rest_products";
    }

    @GetMapping("/rest_products/get_all")
    private String getProducts(
            @RequestParam(value = "min", required = false) Double min,
            @RequestParam(value = "max", required = false) Double max
    ) {
        getRangeList(min, max);

        return "redirect:/rest_products";
    }

    @PostMapping("/rest_products/create_new")
    public String createProduct(Product product, Model model) {
        productSpringDataJPA.save(product);
        productList = productSpringDataJPA.findAll();
        return "redirect:/rest_products";
    }

    @PostMapping("/rest_products/get_id")
    public String searchProduct(Product product, Model model) {
        productList = new ArrayList<>(1);
        productList.add(productSpringDataJPA.findById(product.getId()).get());
        return "redirect:/rest_products";
    }

    @PostMapping("/rest_products/delete")
    public String deleteProduct(Product product, Model model) {
        productSpringDataJPA.delete(product);
        productList = productSpringDataJPA.findAll();
        return "redirect:/rest_products";
    }

    private void getRangeList(Double min, Double max) {
        if (min != null & max != null) {
            productList = productSpringDataJPA.findByCostBetween(min, max);
        } else if (min == null & max != null) {
            productList = productSpringDataJPA.findByCostLessThanEqual(max);
        } else if (min != null){
            productList = productSpringDataJPA.findByCostGreaterThanEqual(min);
        } else {
            productList = productSpringDataJPA.findAll();
        }
    }
}
