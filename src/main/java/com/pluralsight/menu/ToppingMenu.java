package com.pluralsight.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class ToppingMenu {
    public static final ArrayList<String> MEATS = new ArrayList<>(Arrays.asList(
            "steak", "ham", "salami", "roast beef", "chicken", "bacon"));

    public static final ArrayList<String> CHEESES = new ArrayList<>(Arrays.asList(
            "american", "provolone", "cheddar", "swiss"));

    public static final ArrayList<String> REGULAR_TOPPINGS = new ArrayList<>(Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapeños",
            "cucumbers", "pickles", "guacamole", "mushrooms"));

    public static final ArrayList<String> SAUCES = new ArrayList<>(Arrays.asList(
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"));

    public static boolean isValidTopping(String name) {
        String lower = name.toLowerCase();
        return MEATS.contains(lower) || CHEESES.contains(lower)
                || REGULAR_TOPPINGS.contains(lower) || SAUCES.contains(lower);
    }

    public static String getToppingType(String name) {
        String lower = name.toLowerCase();
        if (MEATS.contains(lower)) return "meat";
        if (CHEESES.contains(lower)) return "cheese";
        if (REGULAR_TOPPINGS.contains(lower)) return "regular";
        if (SAUCES.contains(lower)) return "sauce";
        return "unknown";
    }
}