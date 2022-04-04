package com.example.crmplay.controller;

import com.example.crmplay.domain.Customer;
import com.example.crmplay.service.implementation.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
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

    @PostMapping("/add")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, Errors errors){
        if(errors.hasErrors()){
            return "addCustomer";
        }
        customerService.addCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdateCustomer(@RequestParam(value = "id",required = true) Integer id,Model model){
        Customer customer = customerService.getCustomer(id);
        log.info("Customer ID: " + customer.getId());
        model.addAttribute("UpdateCustomer",customer);

        return "updateCustomer";
    }

    @PostMapping("/update")
    public String updateCustomer(@Valid @ModelAttribute("UpdateCustomer") Customer customer, Errors errors){

        if(errors.hasErrors()){
            return "updateCustomer";
        }
        customerService.updateCustomer(customer);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "id") Integer id){

        customerService.deleteCustomer(id);

        return "redirect:/";
    }

}
