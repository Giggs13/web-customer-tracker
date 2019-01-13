package com.giggs13.web.controller;

import com.giggs13.web.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerDAO customerDAO;

    public CustomerController(@Autowired CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping
    public String getList(Model model) {
        model.addAttribute("customers", customerDAO.getCustomers());

        return "list-customers";
    }
}
