package com.pluralsight.orders;

import com.pluralsight.menu.Sandwich;

import java.util.function.Function;

public class SandwichBuilder {

    public static Sandwich build(Function<String, String> prompt) {
        // Prompt for sandwich size
        String size;
        while (true) {
            size = prompt.apply("Enter sandwich size (4, 8, 12): ").trim();
            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter 4, 8, or 12.");
            }
        }

        // Prompt for bread
        String bread = prompt.apply("Choose bread (white, wheat, rye, wrap): ").trim();

        // Prompt for toasted
        boolean toasted = prompt.apply("Do you want it toasted? (yes/no): ")
                .trim().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        String addTopping = prompt.apply("Would you like to add a topping? (yes/no): ").trim();
        if (addTopping.equalsIgnoreCase("yes")) {
            String toppingName = prompt.apply("Enter topping name: ").trim();


            // Validate topping type
            String type;
            while (true) {
                type = prompt.apply("Topping type (meat): ").trim().toLowerCase();
                if (type.equals("steak") || type.equals("ham") || type.equals("salami") || type.equals("becan")
                        || type.equals("roast beef")  || type.equals("chicken")) {
                    break;
                } else {
                    System.out.println("Invalid type. e.g. Choose chicken, ham, Steak, or regular.");
                }
            }

            boolean isExtra = prompt.apply("Is this an extra portion? (yes/no): ")
                    .trim().equalsIgnoreCase("yes");

            Topping topping = new Topping(toppingName, type, isExtra);
            sandwich.addTopping(topping);


        }
        return sandwich;
    }
}