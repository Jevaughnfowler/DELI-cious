package com.pluralsight.FileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    public static void saveReceipt(String receiptContent) {
        // Ensure the receipts directory exists
        File receiptsDir = new File("receipts");
        if (!receiptsDir.exists()) {
            receiptsDir.mkdirs(); // create receipts/ if missing
        }

        // Format timestamp as yyyyMMdd-HHmmss
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        // File path for the receipt
        String fileName = "receipts/" + timestamp + ".txt";

        // Try writing to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(receiptContent);
            System.out.println("✅ Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Error saving receipt.");
            e.printStackTrace();
        }
    }
}
