package com.pluralsight.ui;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    // Prompt for String
    public static String promptForString(String prompt) {
        System.out.print("\u001B[33m" + prompt + "\u001B[0m");  // yellow
        return scanner.nextLine();
    }

    // Prompt for int with validation
    public static int promptForInt(String prompt) {
        while (true) {
            System.out.print("\u001B[33m" + prompt + "\u001B[0m");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                error("Invalid number. Try again.");
            }
        }
    }

    // Prompt for double with validation
    public static double promptForDouble(String prompt) {
        while (true) {
            System.out.print("\u001B[33m" + prompt + "\u001B[0m");
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                error("Invalid number. Try again.");
            }
        }
    }

    // Reusable styling
    public static void header(String text) {
        System.out.println("\n\u001B[36m==============================");
        System.out.println(" " + text.toUpperCase());
        System.out.println("==============================\u001B[0m");
    }

    public static void divider() {
        System.out.println("------------------------------");
    }

    public static void success(String message) {
        System.out.println("\u001B[32m✔ " + message + "\u001B[0m"); // green
    }

    public static void error(String message) {
        System.out.println("\u001B[31m✖ " + message + "\u001B[0m"); // red
    }

    public static void info(String message) {
        System.out.println("\u001B[34m" + message + "\u001B[0m"); // blue
    }

    public static void print(String message) {
        System.out.println(message);
    }
}