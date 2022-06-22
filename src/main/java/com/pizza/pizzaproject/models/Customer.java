package com.pizza.pizzaproject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String phone;

//    @OneToMany(mappedBy = "customer")
//    private List<Pizza> pizzas;

    public Customer(){

    }


    public Customer(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Pizza> getPizzas() {
//        return pizzas;
//    }
//
//    public void setPizzas(List<Pizza> pizzas) {
//        this.pizzas = pizzas;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
//                ", pizzas=" + pizzas +
                '}';
    }
}
