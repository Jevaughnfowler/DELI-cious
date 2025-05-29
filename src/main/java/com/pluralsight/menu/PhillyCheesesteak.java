package com.pluralsight.menu;

import com.pluralsight.orders.Topping;

public class PhillyCheesesteak extends SignatureSandwich {
    public PhillyCheesesteak() {
        super("white", true);
        addTopping(new Topping("Steak", "meat", false));
        addTopping(new Topping("American", "cheese", false));
        addTopping(new Topping("Peppers", "regular", false));
        addTopping(new Topping("Mayo", "regular", false));
    }
}
