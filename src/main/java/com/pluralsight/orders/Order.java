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

        receipt.append("=========================================\n");
        receipt.append("         DELI-cious Sandwich Shop         \n");
        receipt.append("              Order Receipt               \n");
        receipt.append("=========================================\n\n");

        for (BaseProduct item : items) {
            item.calculatePrice(); // make sure price is updated

            // Print main item line
            receipt.append(String.format("%-30s $%5.2f\n", item.getName(), item.getPrice()));

            // If it's a sandwich, print toppings and toast status
            if (item instanceof com.pluralsight.menu.Sandwich sandwich) {
                for (Topping topping : sandwich.getToppings()) {
                    String label = "  - " + topping.getName();
                    if (topping.isExtra()) {
                        label += " (extra)";
                    }
                    receipt.append(String.format("%-30s $%5.2f\n", label, topping.getPrice(sandwich.getSize())));
                }

                if (sandwich.isToasted()) {
                    receipt.append(String.format("%-30s\n", "  * Toasted"));
                }
            }

            receipt.append("\n");
        }

        receipt.append("-----------------------------------------\n");
        receipt.append(String.format("%-30s $%5.2f\n", "TOTAL:", getTotal()));
        receipt.append("Date: ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")))
                .append("\n");

        return receipt.toString();
    }

    public List<BaseProduct> getItems() {
        return items;
    }
}