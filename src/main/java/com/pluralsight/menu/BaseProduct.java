package com.pluralsight.menu;

public abstract class BaseProduct {
    protected String name;
    protected double price;

    public BaseProduct(String name) {
        this.name = name;
        this.price = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Each subclass must define how price is calculated
    public abstract double calculatePrice();

    @Override
    public String toString() {
        return String.format("%s - $%.2f", name, price);
    }
}