package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}