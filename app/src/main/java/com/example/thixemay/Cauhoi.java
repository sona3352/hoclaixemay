package com.example.thixemay;

import java.io.Serializable;

public class Cauhoi implements Serializable {
    private String hinhanh;  // URL hình ảnh
    private String cauhoi;
    private String luaChonA;
    private String luaChonB;
    private String luaChonC;
    private String luaChonD;
    private String dapAnDung;
    private boolean isAnswered = false;
    private String selectedAnswer;
    private String giaithich;
    public Cauhoi() {
    }

    public Cauhoi(String hinhanh, String cauhoi, String luaChonA, String luaChonB, String luaChonC, String luaChonD, String dapAnDung,String giaithich) {
        this.hinhanh = hinhanh;
        this.cauhoi = cauhoi;
        this.luaChonA = luaChonA;
        this.luaChonB = luaChonB;
        this.luaChonC = luaChonC;
        this.luaChonD = luaChonD;
        this.dapAnDung = dapAnDung;
        this.giaithich = giaithich;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getLuaChonA() {
        return luaChonA;
    }

    public void setLuaChonA(String luaChonA) {
        this.luaChonA = luaChonA;
    }

    public String getLuaChonB() {
        return luaChonB;
    }

    public void setLuaChonB(String luaChonB) {
        this.luaChonB = luaChonB;
    }

    public String getLuaChonC() {
        return luaChonC;
    }

    public void setLuaChonC(String luaChonC) {
        this.luaChonC = luaChonC;
    }

    public String getLuaChonD() {
        return luaChonD;
    }

    public void setLuaChonD(String luaChonD) {
        this.luaChonD = luaChonD;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String getGiaithich() {
        return giaithich;
    }

    public void setGiaithich(String giaithich) {
        this.giaithich = giaithich;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
