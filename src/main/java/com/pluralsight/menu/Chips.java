package com.pluralsight.menu;

public class Chips extends BaseProduct {
    private String chipType;

    public Chips(String chipType) {
        super(capitalize(chipType) + " Chips");
        this.chipType = chipType;
    }

    @Override
    public double calculatePrice() {
        price = 1.50; // Fixed price
        return price;
    }

    public String getChipType() {
        return chipType;
    }

    private static String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}