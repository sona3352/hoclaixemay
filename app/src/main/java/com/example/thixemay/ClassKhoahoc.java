package com.example.thixemay;

import java.io.Serializable;

public class ClassKhoahoc implements Serializable {
    private String id;
    private String tenkhoahoc,gioithieu, trangthai;
    private int giaban;

    public ClassKhoahoc(){};

    public ClassKhoahoc(String id, String tenkhoahoc, String gioithieu, String trangthai, int giaban) {
        this.id = id;
        this.tenkhoahoc = tenkhoahoc;
        this.gioithieu = gioithieu;
        this.trangthai = trangthai;
        this.giaban = giaban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
}
