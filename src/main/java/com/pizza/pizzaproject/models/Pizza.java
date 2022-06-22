package com.pizza.pizzaproject.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String crust;
    private String toppings;
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    public Pizza(){

    }

    public Pizza(Long id, String crust, String toppings, Status status, Customer customer) {
        this.id = id;
        this.crust = crust;
        this.toppings = toppings;
        this.status = status;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }


    public Enum<Status> getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", crust='" + crust + '\'' +
                ", toppings='" + toppings + '\'' +
                ", status=" + status +
                ", customer=" + customer +
                '}';
    }
}
