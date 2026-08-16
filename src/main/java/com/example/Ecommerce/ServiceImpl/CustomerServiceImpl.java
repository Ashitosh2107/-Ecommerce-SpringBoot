package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.Exceptions.ProductNotFoundException;
import com.example.Ecommerce.Model.Customer;
import com.example.Ecommerce.Repository.CustomerRepo;
import com.example.Ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Customer Not Found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existing = customerRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Customer Not Found"));

        existing.setFullName(customer.getFullName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());
        existing.setPassword(customer.getPassword());

        return customerRepo.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {

        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Customer Not Found"));

        customerRepo.delete(customer);
    }
}