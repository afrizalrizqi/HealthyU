package com.example.projectux;

public class Pasien {
    private String nama;
    private String NIK;
    private String no_telp;
    private String gender;
    private boolean isSelected;

    public Pasien(String nama, String NIK, String no_telp, String gender, boolean isSelected) {
        this.nama = nama;
        this.NIK = NIK;
        this.no_telp = no_telp;
        this.gender = gender;
        this.isSelected = isSelected;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
