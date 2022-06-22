package com.pizza.pizzaproject.models;


public enum Status {
    STARTED("Started"), COOKING("Cooking"), READY("Ready");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
