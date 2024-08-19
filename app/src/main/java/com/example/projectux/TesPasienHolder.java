package com.example.projectux;

public class TesPasienHolder {
    private static TesPasienHolder instance;
    private TesPasien tesPasien;

    private String labName;


    private TesPasienHolder() {
        tesPasien = new TesPasien(null, null, null, null, null);
        labName = null;
    }
    public static TesPasienHolder getInstance() {
        if (instance == null) {
            instance = new TesPasienHolder();
        }
        return instance;
    }

    public TesPasien getTesPasien() {
        return tesPasien;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

}