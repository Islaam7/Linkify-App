package com.example.portfolioapp;

public class DataHub {
    private String title;
    private int icon;

    public DataHub(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }
}
