package com.pluralsight.menu;

import com.pluralsight.orders.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends BaseProduct {
    private String size;           // "4", "8", "12"
    private String bread;          // "white", "wheat", etc.
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(String size, String bread, boolean toasted) {
        super(size + "\" " + bread + " Sandwich");
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public double calculatePrice() {
        // Base sandwich price by size
        switch (size) {
            case "4": price = 5.50; break;
            case "8": price = 7.00; break;
            case "12": price = 8.50; break;
            default: price = 0.00; break;
        }

        // Add topping prices
        for (Topping topping : toppings) {
            price += topping.getPrice(size);
        }

        return price;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public String getBread() {
        return bread;
    }

    public String getSize() {
        return size;
    }
}
