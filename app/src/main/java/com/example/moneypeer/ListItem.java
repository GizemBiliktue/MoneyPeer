package com.example.moneypeer;

public class ListItem {
    private String text;
    private boolean isGreen;
    private boolean isRed;

    public ListItem(String text) {
        this.text = text;
        this.isGreen = false; // Standardmäßig ist die Zeile nicht grün
        this.isRed = false;
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
}