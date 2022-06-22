package com.pizza.pizzaproject.repos;

import com.pizza.pizzaproject.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
