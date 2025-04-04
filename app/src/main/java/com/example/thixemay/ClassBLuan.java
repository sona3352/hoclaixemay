package com.example.thixemay;

import java.util.HashMap;
import java.util.Map;

public class ClassBLuan {
    private String binhLuanId;
    private String userId;
    private String tenUser;
    private String avatar;
    private String noiDung;
    private String thoiGian;
    private Map<String, ClassBLuan> replies; // Danh sách phản hồi

    public ClassBLuan() {
    }

    public ClassBLuan(String binhLuanId, String userId, String tenUser, String avatar, String noiDung, String thoiGian) {
        this.binhLuanId = binhLuanId;
        this.userId = userId;
        this.tenUser = tenUser;
        this.avatar = avatar;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
        this.replies = new HashMap<>(); // Khởi tạo danh sách rỗng
    }

    public String getBinhLuanId() {
        return binhLuanId;
    }

    public String getUserId() {
        return userId;
    }

    public String getTenUser() {
        return tenUser;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public Map<String, ClassBLuan> getReplies() {
        return replies;
    }
}
