package com.pluralsight.orders;

import com.pluralsight.menu.Drink;

import java.util.function.Function;

public class DrinkBuilder {

    public static Drink build(Function<String, String> prompt) {
        String size;
        while (true) {
            size = prompt.apply("Enter drink size (small, medium, large): ").toLowerCase();
            if (size.equals("small") || size.equals("medium") || size.equals("large")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter small, medium, or large.");
            }
        }

        String flavor = prompt.apply("Enter drink flavor (e.g. coke, sprite, water): ");

        return new Drink(size, flavor);
    }
}