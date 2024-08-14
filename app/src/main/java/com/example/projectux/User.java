package com.example.projectux;

public class User {
    private String username;
    private int profile_pic;
    private String nama_lengkap;
    private String nik;
    private String email;
    private String password;
    private String nomor_telepon;
    private String alamat;
    private String detail_alamat;
    private String gender;
    public static User user;

    public User(String username, String nama_lengkap, String nik, String email, String password) {
        this.username = username;
        this.nama_lengkap = nama_lengkap;
        this.nik = nik;
        this.email = email;
        this.password = password;
        user = this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDetail_alamat() {
        return detail_alamat;
    }

    public void setDetail_alamat(String detail_alamat) {
        this.detail_alamat = detail_alamat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNik() {
        return nik;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public int getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(int profile_pic) {
        this.profile_pic = profile_pic;
    }
}
