package com.pluralsight.orders;

public class Topping {
    private String name;
    private String type;       // "meat", "cheese", "regular", "sauce", "side"
    private boolean isExtra;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type.toLowerCase();
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getPrice(String size) {
        double price = 0.0;

        switch (type) {
            case "meat":
                price = switch (size) {
                    case "4" -> 1.00;
                    case "8" -> 2.00;
                    case "12" -> 3.00;
                    default -> 0.00;
                };
                if (isExtra) {
                    price += switch (size) {
                        case "4" -> 0.50;
                        case "8" -> 1.00;
                        case "12" -> 1.50;
                        default -> 0.00;
                    };
                }
                break;

            case "cheese":
                price = switch (size) {
                    case "4" -> 0.75;
                    case "8" -> 1.50;
                    case "12" -> 2.25;
                    default -> 0.00;
                };
                if (isExtra) {
                    price += switch (size) {
                        case "4" -> 0.30;
                        case "8" -> 0.60;
                        case "12" -> 0.90;
                        default -> 0.00;
                    };
                }
                break;

            case "regular": // Regular toppings and sauces are free
            case "sauce":
                price = 0.00;
                break;

            case "side":
                // Fixed price for sides, no size difference, no extras
                price = 1.50;
                break;
        }

        return price;
    }
}