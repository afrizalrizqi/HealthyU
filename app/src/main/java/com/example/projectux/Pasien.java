package com.example.projectux;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pasien implements Serializable {
    private String nama;
    private String gender;
    private String NIK;
    private String no_telp;
    private boolean isSelected;
//    private List<TesPasien> tesPasienList = new ArrayList<>();

    public Pasien(String nama, String gender, String NIK, String no_telp , boolean isSelected) {
        this.nama = nama;
        this.gender = gender;
        this.NIK = NIK;
        this.no_telp = no_telp;
        this.isSelected = isSelected;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void initializeSelected(List<Pasien> pasienList, int position) {
        for (int i = 0; i < pasienList.size(); i++) {
            if (i == position) {
                pasienList.get(i).setSelected(true);
            } else {
                pasienList.get(i).setSelected(false);
            }
        }
    }

}
