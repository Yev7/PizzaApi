package com.pizza.pizzaproject.controllers;

import com.pizza.pizzaproject.PizzaprojectApplication;
import com.pizza.pizzaproject.models.Customer;
import com.pizza.pizzaproject.models.Pizza;
import com.pizza.pizzaproject.repos.CustomerRepository;
import com.pizza.pizzaproject.repos.PizzaRepository;
import com.pizza.pizzaproject.services.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")

public class PizzaController {
    private static final Logger logger = LoggerFactory.getLogger(PizzaprojectApplication.class);
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private PizzaRepository pizzaRepository;


//    @PostMapping("/pizzas")
//    public void addPizza(@RequestBody Pizza pizza){
//        pizzaService.savePizza(pizza);
//    }

    @RequestMapping(value="/pizzas", method = RequestMethod.POST)
    public ResponseEntity<?> createPizza(@Valid @RequestBody Pizza pizza) {
        pizza = pizzaRepository.save(pizza);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(pizza.getId()).toUri();
        responseHeaders.setLocation(newOrderUri);
        logger.info("Created pizza successfully. ");
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getAllOrders(){
        Iterable<Pizza> allOrders = pizzaRepository.findAll();
        logger.info("Received all pizzas successfully.");
        return new ResponseEntity<>(pizzaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping (value = "/pizzas/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        logger.info("Retrieved pizza with id :" + id);
        Optional<Pizza> p = pizzaRepository.findById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);

    }
    @RequestMapping(value="/pizzas/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        logger.info("Pizza with id :" + id + " has successfully been updated.");
        Pizza p = pizzaRepository.save(pizza);
        return new ResponseEntity<>(  HttpStatus.OK);
    }
    @RequestMapping(value="/pizzas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePizza(@PathVariable Long id) {
        logger.info("Deleted pizza with id : " + id );
        pizzaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Pizza>> getAllOrdersByCrust(@RequestParam String crust){
        logger.info("retrieved all orders with "+crust+" crust");
        return new ResponseEntity<>(pizzaService.getAllOrdersByCrust(crust),HttpStatus.OK);
    }
    @GetMapping("/pizzas/{id}/customer")
    public ResponseEntity<?> getCustomerByOrderId(@PathVariable Long id) {
        logger.info("Getting customer from order " + id);
        Pizza pizza = pizzaService.getPizza(id);
        return new ResponseEntity<>(pizzaService.getCustomerById(pizza.getCustomer().getId()) ,HttpStatus.OK);
    }



}
