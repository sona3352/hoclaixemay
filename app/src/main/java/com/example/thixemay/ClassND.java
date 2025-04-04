package com.example.thixemay;

public class ClassND {
    private String avatar;
    private String email;
    private String hoten;
    private String diachi;
    private String role;
    public ClassND() {
    }

    public ClassND(String avatar, String email, String hoten, String diachi, String role) {
        this.avatar = avatar;
        this.email = email;
        this.hoten = hoten;
        this.diachi = diachi;
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
