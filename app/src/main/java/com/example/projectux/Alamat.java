package com.example.projectux;

import java.util.ArrayList;

public class Alamat {
    private String nama_alamat;
    private String alamat_lengkap;
    public static ArrayList<Alamat> alamats;

    public Alamat(String nama_alamat, String alamat_lengkap) {
        this.nama_alamat = nama_alamat;
        this.alamat_lengkap = alamat_lengkap;
        alamats.add(this);
    }

    public String getNama_alamat() {
        return nama_alamat;
    }

    public void setNama_alamat(String nama_alamat) {
        this.nama_alamat = nama_alamat;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }
}
