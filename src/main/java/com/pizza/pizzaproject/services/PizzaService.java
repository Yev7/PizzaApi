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

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void savePizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }
    public List<Pizza> getAllPizzas(){
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepository.findAll().forEach(pizzas::add);
        return pizzas;
    }
    public Optional<Pizza> getById(Long id){
        return pizzaRepository.findById(id);
    }

    public Pizza updatePizza(Long pizzaId, Pizza pizza){
        for (Pizza p: getAllPizzas()){
            if (p.getId().equals(pizzaId)){
                pizzaRepository.save(pizza);
            }
        }
        return pizza;
    }
    public void deletePizza(Long id){
        pizzaRepository.deleteById(id);
    }
    public List<Pizza> getAllOrdersByCrust(String crust){
        List<Pizza> orders = new ArrayList<>();
        for(Pizza pizza:getAllPizzas()){
            if(pizza.getCrust().equals(crust)){
                orders.add(pizza);
            }
        }
        return orders;
    }
    public Pizza getPizza(Long id) {
        Pizza pizza = pizzaRepository.findById(id).get();
        return pizza;
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
