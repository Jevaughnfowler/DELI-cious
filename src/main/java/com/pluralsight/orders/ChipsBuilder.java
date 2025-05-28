package com.pluralsight.orders;

import com.pluralsight.menu.Chips;

import java.util.function.Function;

public class ChipsBuilder {

    public static Chips build(Function<String, String> prompt) {
        String chipType = prompt.apply("Enter chip type (e.g. lays, sunshine, doritos): ");
        return new Chips(chipType);
    }
}