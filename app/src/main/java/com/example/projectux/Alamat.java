package com.example.projectux;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alamat implements Serializable {
    private String nama_alamat;
    private String alamat_lengkap;
    private boolean isSelected;

    public Alamat(String nama_alamat, String alamat_lengkap) {
        this.nama_alamat = nama_alamat;
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getNama_alamat() {
        return nama_alamat;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void initializeSelected(List<Alamat> alamatList, int lastSelectedPosition) {
        for (int i = 0; i < alamatList.size(); i++) {
            if (i == lastSelectedPosition) {
                alamatList.get(i).setSelected(true);
            } else {
                alamatList.get(i).setSelected(false);
            }
        }
    }


}
