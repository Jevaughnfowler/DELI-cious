package com.pluralsight.menu;


public class Drink extends BaseProduct {
    private String size;
    private String flavor;

    public Drink(String size,String flavor){
        super(capitalize(size) + " " + capitalize(flavor) + " Drink");
        this.size = size.toLowerCase();
        this.flavor = flavor.toLowerCase();
    }

    @Override
    public double calculatePrice() {
        price = switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
        return price;
    }

    private static String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

}
