package com.example.thixemay;

public class ClassLT {
    int anh;
    String tieude,mota;

    public ClassLT() {
    }
    public ClassLT(int anh, String tieude, String mota) {
        this.anh = anh;
        this.tieude = tieude;
        this.mota = mota;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
