package com.pluralsight.orders;

import com.pluralsight.menu.Sandwich;
import com.pluralsight.menu.ToppingMenu;
import com.pluralsight.orders.Topping;

import java.util.function.Function;

public class SandwichBuilder {

    public static Sandwich build(Function<String, String> prompt) {
        String input = prompt.apply("Would you like a signature sandwich or build your own? (signature/custom): ").trim().toLowerCase();

        if (input.equals("signature")) {
            return chooseSignature(prompt);
        } else {
            return buildCustom(prompt);
        }
    }

    private static Sandwich buildCustom(Function<String, String> prompt) {
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

        // Add toppings by category using ToppingMenu constants
        addToppingsFromCategory(prompt, sandwich, "meat", ToppingMenu.MEATS);
        addToppingsFromCategory(prompt, sandwich, "cheese", ToppingMenu.CHEESES);
        addToppingsFromCategory(prompt, sandwich, "regular", ToppingMenu.REGULAR_TOPPINGS);
        addToppingsFromCategory(prompt, sandwich, "sauce", ToppingMenu.SAUCES);

        return sandwich;
    }

    private static void addToppingsFromCategory(Function<String, String> prompt, Sandwich sandwich, String type, java.util.ArrayList<String> listToUse) {
        System.out.println("\nChoose one or more " + type + "(s) by entering numbers separated by commas (e.g. 1,3,5), or leave blank for none:");
        for (int i = 0; i < listToUse.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, capitalize(listToUse.get(i)));
        }

        String multipleChoice = prompt.apply("Enter your choices: ").trim();
        if (multipleChoice.isEmpty()) {
            System.out.println("No " + type + " chosen.");
            return;
        }

        if (!multipleChoice.matches("^(\\d+)(,\\d+)*$")) {
            System.out.println("Invalid input format. Skipping " + type + " selection.");
            return;
        }

        String[] choices = multipleChoice.split(",");
        for (String choiceStr : choices) {
            int choiceNum = Integer.parseInt(choiceStr.trim());
            if (choiceNum < 1 || choiceNum > listToUse.size()) {
                System.out.println("Choice " + choiceNum + " is out of range. Skipping.");
                continue;
            }
            String chosenTopping = listToUse.get(choiceNum - 1);
            boolean isExtra = prompt.apply("Would you like extra portion of " + capitalize(chosenTopping) + "? (yes/no): ")
                    .trim().equalsIgnoreCase("yes");
            sandwich.addTopping(new Topping(capitalize(chosenTopping), type, isExtra));
            System.out.println(capitalize(chosenTopping) + " added" + (isExtra ? " as extra." : "."));
        }
    }

    private static Sandwich chooseSignature(Function<String, String> prompt) {
        String choice;
        while (true) {
            choice = prompt.apply("Choose a signature sandwich: (1) BLT, (2) Philly Cheese Steak: ").trim();
            if (choice.equals("1") || choice.equals("2")) break;
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        Sandwich sandwich;
        if (choice.equals("1")) {
            sandwich = new Sandwich("8", "white", true);
            sandwich.addTopping(new Topping("Bacon", "meat", false));
            sandwich.addTopping(new Topping("Cheddar", "cheese", false));
            sandwich.addTopping(new Topping("Lettuce", "regular", false));
            sandwich.addTopping(new Topping("Tomato", "regular", false));
            sandwich.addTopping(new Topping("Ranch", "sauce", false));
        } else {
            sandwich = new Sandwich("8", "white", true);
            sandwich.addTopping(new Topping("Steak", "meat", false));
            sandwich.addTopping(new Topping("American", "cheese", false));
            sandwich.addTopping(new Topping("Peppers", "regular", false));
            sandwich.addTopping(new Topping("Mayo", "sauce", false));
        }

        // Offer customization on signature sandwiches too
        if (prompt.apply("Would you like to add more toppings? (yes/no): ").trim().equalsIgnoreCase("yes")) {
            addToppingsFromCategory(prompt, sandwich, "meat", ToppingMenu.MEATS);
            addToppingsFromCategory(prompt, sandwich, "cheese", ToppingMenu.CHEESES);
            addToppingsFromCategory(prompt, sandwich, "regular", ToppingMenu.REGULAR_TOPPINGS);
            addToppingsFromCategory(prompt, sandwich, "sauce", ToppingMenu.SAUCES);
        }

        return sandwich;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}