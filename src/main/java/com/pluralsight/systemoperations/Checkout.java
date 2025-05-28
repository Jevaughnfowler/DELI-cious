package com.pluralsight.systemoperations;

import com.pluralsight.FileManager.FileManager;
import com.pluralsight.orders.Order;
import com.pluralsight.ui.Console;

public class Checkout {
    public static void process(Order order) {
        Console.header("        Final Receipt");
        String receipt = order.getReceiptText();
        Console.print(receipt);
        FileManager.saveReceipt(receipt);
        Console.success("Order saved to receipts folder.");
    }
}
