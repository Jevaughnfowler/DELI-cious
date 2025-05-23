package com.pluralsight.ui;

import com.pluralsight.menu.Sandwich;
import com.pluralsight.orders.Order;
import com.pluralsight.FileManager.FileManager;
import com.pluralsight.orders.SandwichBuilder;

public class UserInterface {
    private boolean running = true;

    public void run() {
        while (running) {
            showHomeMenu();
        }
    }

    private void showHomeMenu() {
        Console.header("Welcome to DELI-cious!");
        Console.print("1) New Order");
        Console.print("0) Exit");

        String input = Console.promptForString("Choose an option: ");

        switch (input) {
            case "1" -> startNewOrder();
            case "0" -> {
                Console.success("Goodbye!");
                running = false;
            }
            default -> Console.error("Invalid option. Please try again.");
        }
    }

    private void startNewOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            Console.header("Order Menu");
            Console.print("1) Add Sandwich");
            Console.print("2) Add Drink (coming soon)");
            Console.print("3) Add Chips (coming soon)");
            Console.print("4) Checkout");
            Console.print("0) Cancel Order");

            String input = Console.promptForString("Choose an option: ");

            switch (input) {
                case "1" -> {
                    Sandwich sandwich = SandwichBuilder.build(Console::promptForString);
                    order.addItem(sandwich);
                    Console.success("Sandwich added!");
                }
                case "4" -> {
                    checkout(order);
                    ordering = false;
                }
                case "0" -> {
                    Console.info("Order cancelled.");
                    ordering = false;
                }
                default -> Console.error("Invalid option. Please try again.");
            }
        }
    }

    private void checkout(Order order) {
        Console.header("Final Receipt");
        String receipt = order.getReceiptText();
        Console.print(receipt);
        FileManager.saveReceipt(receipt);
        Console.success("Order saved to receipts folder.");
    }
}