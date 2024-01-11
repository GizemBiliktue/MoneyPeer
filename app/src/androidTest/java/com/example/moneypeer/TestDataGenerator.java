package com.example.moneypeer;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    public static List<ListItem> createTestData() {
        List<ListItem> testData = new ArrayList<>();

        // Hier fügst du Testdaten hinzu
        testData.add(new ListItem("Wäsche waschen", "pending"));
        testData.add(new ListItem("Hausaufgaben machen", "accepted"));
        testData.add(new ListItem("Käsekuchen backen", "denied"));

        return testData;
    }
}
