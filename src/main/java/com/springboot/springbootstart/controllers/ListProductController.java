package com.springboot.springbootstart.controllers;

import com.springboot.springbootstart.model.Product;
import com.springboot.springbootstart.servises.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ListProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping("/list_products")
    public String getForm(Model model, Model modell) {
        Product product = new Product();
        model.addAttribute("product", product);
        setModelAttribute(modell);
        return "list_products";
    }

    @PostMapping("/list_products")
    public String create (Product product, Model model) {
        productDao.saveOrYUpdate(product);
        setModelAttribute(model);
        return "list_products";
    }

    @GetMapping("/list_products/delete")
    public String delete (@RequestParam Long id, HttpServletResponse response) {
        productDao.deleteById(id);
        return "redirect:/list_products";
    }

    private void setModelAttribute (Model model) {
        List<Product> view = productDao.findAll();
        model.addAttribute("view", view);
    }
}