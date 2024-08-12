package com.example.projectux;

public class Pasien {
    String nama;
    String jenisKelamin;
    String nik;

    public Pasien(String nama, String jenisKelamin, String nik) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
}
