package com.pizza.pizzaproject.controllers;

import com.pizza.pizzaproject.PizzaprojectApplication;
import com.pizza.pizzaproject.models.Customer;
import com.pizza.pizzaproject.models.Pizza;
import com.pizza.pizzaproject.repos.CustomerRepository;
import com.pizza.pizzaproject.repos.PizzaRepository;
import com.pizza.pizzaproject.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(PizzaprojectApplication.class);

    @Autowired
    private CustomerService customerService;
//    @Autowired
//    private PizzaRepository pizzaRepository;

    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        logger.info("Creating customer" + customer);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        logger.info("Getting all the customers");
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        logger.info("Changing customer of id " + id + " to " + customer.toString());
        customerService.updateCustomer(id,customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        logger.info("successfully deleted customer with id " + id);
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        logger.info("finding customer with id " + id);
        return new ResponseEntity<>(customerService.getCustomer(id),HttpStatus.OK);
    }

    @GetMapping("/customers/{id}/pizzas")
    public ResponseEntity<?> getAllOrdersFromCustomer(@PathVariable Long id) {
        logger.info("finding all orders for customer " + id);
        return new ResponseEntity<>(customerService.getOrdersByCustomer(id) , HttpStatus.OK);
    }
}
