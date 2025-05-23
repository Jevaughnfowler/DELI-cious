package com.pluralsight.orders;

import com.pluralsight.menu.BaseProduct;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<BaseProduct> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(BaseProduct item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(BaseProduct::calculatePrice)
                .sum();
    }

    public String getReceiptText() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("=====================================\n");
        receipt.append("           DELI-cious Receipt         \n");
        receipt.append("=====================================\n\n");

        for (BaseProduct item : items) {
            item.calculatePrice(); // ensure price is updated
            receipt.append(item.toString()).append("\n");

            // If it's a sandwich, show toppings
            if (item instanceof com.pluralsight.menu.Sandwich sandwich) {
                for (Topping topping : sandwich.getToppings()) {
                    receipt.append("  - ").append(topping.getName());
                    if (topping.isExtra()) {
                        receipt.append(" (extra)");
                    }
                    receipt.append("\n");
                }
                if (sandwich.isToasted()) {
                    receipt.append("  * Toasted\n");
                }
            }
            receipt.append("\n");
        }

        receipt.append("-------------------------------------\n");
        receipt.append(String.format("Total: $%.2f\n", getTotal()));
        receipt.append("Date: ")
                .append(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .append("\n");

        return receipt.toString();
    }

    public List<BaseProduct> getItems() {
        return items;
    }
}