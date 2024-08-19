package com.example.projectux;

public class TesPasien {
    private String namaTes;
    private String lokasi;
    private String tanggal;
    private String waktu;
    private String status;
    private Pasien pasien;

    public TesPasien(String namaTes, String lokasi, String tanggal, String waktu, String status) {
        this.namaTes = namaTes;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.status = status;
    }

    public String getNamaTes() {
        return namaTes;
    }

    public void setNamaTes(String namaTes) {
        this.namaTes = namaTes;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

}

