package com.example.crmplay.controller;

import com.example.crmplay.domain.Customer;
import com.example.crmplay.service.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping
    public String showCustomers(Model model){

        model.addAttribute("customers",customerService.getAllCustomers());

        return "customers";
    }

    @GetMapping("/add")
    public ModelAndView addCustomer(){

        return new ModelAndView("addCustomer","customer", new Customer());
    }

    @RequestMapping("/add")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.addCustomer(customer);
        return "redirect:/";
    }

}
