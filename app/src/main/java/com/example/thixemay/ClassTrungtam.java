package com.example.thixemay;
public class ClassTrungtam {
    private String id, ten, diachi, sdt, hinhanh;

    public ClassTrungtam() {}

    public ClassTrungtam(String id, String ten, String diachi, String sdt, String hinhanh) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.hinhanh = hinhanh;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getDiachi() { return diachi; }
    public void setDiachi(String diachi) { this.diachi = diachi; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getHinhanh() { return hinhanh; }
    public void setHinhanh(String hinhanh) { this.hinhanh = hinhanh; }
}
