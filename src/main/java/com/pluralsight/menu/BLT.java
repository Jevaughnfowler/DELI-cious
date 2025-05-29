package com.pluralsight.menu;

import com.pluralsight.orders.Topping;

public class BLT extends SignatureSandwich {
    public BLT() {
        super("white", true);
        addTopping(new Topping("Bacon", "meat", false));
        addTopping(new Topping("Cheddar", "cheese", false));
        addTopping(new Topping("Lettuce", "regular", false));
        addTopping(new Topping("Tomato", "regular", false));
        addTopping(new Topping("Ranch", "regular", false));
    }
}