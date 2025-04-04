package com.example.thixemay;

import java.util.List;

public class ClassTheodoi {
    private String orderId;
    private String trangthai;
    private List<ClassKhoahoc> items;
    public ClassTheodoi() {
    }

    public ClassTheodoi(String orderId, String trangthai, List<ClassKhoahoc> items) {
        this.orderId = orderId;
        this.trangthai = trangthai;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public List<ClassKhoahoc> getItems() {
        return items;
    }

    public void setItems(List<ClassKhoahoc> items) {
        this.items = items;
    }
}
