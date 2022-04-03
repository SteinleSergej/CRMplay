package com.example.crmplay.service;

import com.example.crmplay.domain.Customer;

import java.util.List;

public interface CustomerService {

    public void addCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public List<Customer> getAllCustomers();
}
