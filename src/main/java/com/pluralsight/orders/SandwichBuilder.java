package com.pluralsight.orders;

import com.pluralsight.menu.Sandwich;

import java.util.function.Function;

public class SandwichBuilder {

    public static Sandwich build(Function<String, String> prompt) {
        String size = prompt.apply("Enter sandwich size (4, 8, 12): ");
        String bread = prompt.apply("Choose bread (white, wheat, rye, wrap): ");
        boolean toasted = prompt.apply("Do you want it toasted? (yes/no): ")
                .equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        boolean addingToppings = true;
        while (addingToppings) {
            String toppingName = prompt.apply("Add a topping (type 'done' to finish): ");
            if (toppingName.equalsIgnoreCase("done")) {
                addingToppings = false;
                break;
            }

            String type = prompt.apply("Topping type (meat, cheese, regular): ");
            boolean isExtra = prompt.apply("Is this an extra portion? (yes/no): ")
                    .equalsIgnoreCase("yes");

            Topping topping = new Topping(toppingName, type, isExtra);
            sandwich.addTopping(topping);
        }

        return sandwich;
    }
}