package com.example.crmplay.service.implementation;

import com.example.crmplay.domain.Customer;
import com.example.crmplay.repository.CustomerRepository;
import com.example.crmplay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {

        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
