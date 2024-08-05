package com.example.projectux;

public class LabCard {
    private String name;
    private String address;
    private String hours;
    private String phone;
    private int imageResId;

    public LabCard(String name, String address, String hours, String phone, int imageResId) {
        this.name = name;
        this.address = address;
        this.hours = hours;
        this.phone = phone;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getHours() { return hours; }
    public String getPhone() { return phone; }
    public int getImageResId() { return imageResId; }
}

