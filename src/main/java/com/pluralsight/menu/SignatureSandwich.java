package com.pluralsight.menu;

public abstract class SignatureSandwich extends Sandwich {
    public SignatureSandwich(String bread, boolean toasted) {
        super("8", bread, toasted); // Signature sandwiches are always 8"
    }
}