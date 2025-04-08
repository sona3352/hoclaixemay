package com.example.thixemay;

public class ClassQT {
    private String tenhienthi;
    String tendang;
    int anhnen;

    public ClassQT(String tenhienthi, String tendang, int anhnen) {
        this.tenhienthi = tenhienthi;
        this.tendang = tendang;
        this.anhnen = anhnen;
    }

    public String getTenhienthi() {
        return tenhienthi;
    }

    public void setTenhienthi(String tenhienthi) {
        this.tenhienthi = tenhienthi;
    }

    public String getTendang() {
        return tendang;
    }

    public void setTendang(String tendang) {
        this.tendang = tendang;
    }

    public int getAnhnen() {
        return anhnen;
    }

    public void setAnhnen(int anhnen) {
        this.anhnen = anhnen;
    }
}
