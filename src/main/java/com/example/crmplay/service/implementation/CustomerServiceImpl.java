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
    public void deleteCustomer(Integer id) {
        customerRepository.delete(customerRepository.getById(id));
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer cus = customerRepository.getById(customer.getId());
        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setEmail(customer.getEmail());
        customerRepository.save(cus);


    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerRepository.getById(id);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
