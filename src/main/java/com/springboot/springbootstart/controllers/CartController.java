package com.springboot.springbootstart.controllers;

import com.springboot.springbootstart.model.Product;
import com.springboot.springbootstart.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private ProductDao productDao;

    @GetMapping("/cart")
    public String getForm(Model model, Model modell) {
        Product product = new Product();
        model.addAttribute("product", product);
        setModelAttribute(modell);
        return "cart";
    }

    @PostMapping("/cart")
    public String create (Product product, Model model) {
        productDao.saveOrYUpdate(product);
        setModelAttribute(model);
        return "cart";
    }

    @GetMapping("/cart/delete")
    public String delete (@RequestParam int id, HttpServletResponse response) {
        productDao.deleteById(id);
        return "redirect:/cart";
    }

    private void setModelAttribute (Model model) {
        List<Product> view = productDao.findAll();
        model.addAttribute("view", view);
    }
}