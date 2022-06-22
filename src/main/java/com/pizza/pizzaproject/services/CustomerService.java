package com.pizza.pizzaproject.services;

import com.pizza.pizzaproject.models.Customer;
import com.pizza.pizzaproject.models.Pizza;
import com.pizza.pizzaproject.repos.CustomerRepository;
import com.pizza.pizzaproject.repos.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Long customerId, Customer customer){
        for (Customer c: getAllCustomers()){
            if (c.getId().equals(customerId)){
                customerRepository.save(customer);
            }
        }
        return customer;
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).get();
    }

    public Set<Pizza> getOrdersByCustomer(Long id) {
        return pizzaRepository.findByCustomerId(id);
    }
}
