package com.example.projectux;

public class Reminder {
    private String reminder;
    private String deskripsi;
    private int logo;

//    public Reminder(String reminder, String deskripsi, int logo) {
//        this.reminder = reminder;
//        this.deskripsi = deskripsi;
//        this.logo = logo;
//    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
