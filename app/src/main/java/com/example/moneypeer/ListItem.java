package com.example.moneypeer;

public class ListItem {
    private String text;
    private boolean isGreen;
    private boolean isRed;

    public ListItem(String text, String statusItem1) {
        this.text = text;
        this.isGreen = false; // Standardmäßig ist die Zeile nicht grün
        this.isRed = false;
        setStatus(statusItem1); // Setze den übergebenen Status
    }

    public String getText() {
        return text;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    // Aktualisiere den Status basierend auf dem übergebenen String
    public void setStatus(String status) {
        if ("denied".equals(status)) {
            this.isRed = true;
            this.isGreen = false;
        } else if ("accepted".equals(status)) {
            this.isGreen = true;
            this.isRed = false;
        } else {
            this.isRed = false;
            this.isGreen = false;
        }
    }

    // Gibt den Status als String zurück
    public String getStatus() {
        if (isRed) {
            return "denied";
        } else if (isGreen) {
            return "accepted";
        } else {
            return "pending"; // Status, falls weder rot noch grün
        }
    }
}
