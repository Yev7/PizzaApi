package com.pizza.pizzaproject.repos;

import com.pizza.pizzaproject.models.Pizza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
//    List<Pizza> findPizzasByCrust(String crust);
//@Query(value = "SELECT * " +
//        "FROM pizzas p, customers c " +
//        "WHERE p.customer_customer_id =?1", nativeQuery = true)
    Set<Pizza> findByCustomerId(Long id);
}
