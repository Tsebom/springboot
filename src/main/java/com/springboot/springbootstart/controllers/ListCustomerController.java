package com.springboot.springbootstart.controllers;

import com.springboot.springbootstart.dao.CustomerDao;
import com.springboot.springbootstart.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ListCustomerController {
    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/list_customers")
    public String getForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        setModelAttribute(model);
        return "list_customers";
    }

    @PostMapping("/list_customers")
    public String create (Customer customer, Model model) {
        customerDao.saveOrUpdate(customer);
        setModelAttribute(model);
        return "list_customers";
    }

    @GetMapping("/list_customers/delete")
    public String delete (@RequestParam Long id, HttpServletResponse response) {
        customerDao.deleteById(id);
        return "redirect:/list_customers";
    }

    private void setModelAttribute (Model model) {
        List<Customer> view = customerDao.findAll();
        model.addAttribute("view", view);
    }
}