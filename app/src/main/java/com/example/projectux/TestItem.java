package com.example.projectux;

public class TestItem {
    private String title;
    private int iconResId;

    public TestItem(String title, int iconResId) {
        this.title = title;
        this.iconResId = iconResId;
    }

    public String getTitle() {
        return title;
    }

    public int getIconResId() {
        return iconResId;
    }

}
