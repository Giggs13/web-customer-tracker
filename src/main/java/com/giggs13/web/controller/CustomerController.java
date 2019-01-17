package com.giggs13.web.controller;

import com.giggs13.web.entity.Customer;
import com.giggs13.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getList(Model model) {
        model.addAttribute("customers", customerService.getCustomers());

        return "customers";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(name = "id", required = false) Integer id,
                           Model model) {
        Customer customer;
        if (id == null) {
            customer = new Customer();
        } else {
            customer = customerService.getCustomer(id);
        }
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping
    public String save(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete")
    public String save(@RequestParam(name = "id") Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchName") String searchName,
                         Model model) {
        List<Customer> customers = customerService.searchByName(searchName);
        model.addAttribute("customers", customers);

        return "customers";
    }
}
