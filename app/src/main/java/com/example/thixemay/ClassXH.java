package com.example.thixemay;

public class ClassXH {
    private String postId;
    private String userId;
    private String avatarUrl; // URL Avatar
    private String tenUser;  // Tên người dùng
    private String thoiGian; // Thời gian đăng
    private String noidung2; // Nội dung bài đăng
    private String anhUrl; // URL ảnh bài đăng
    private int luotThich;   // Số lượt thích
    private int luotBinhLuan; // Số bình luận

    public ClassXH() {
    }

    public ClassXH(String postId, String userId, String avatarUrl, String tenUser, String thoiGian, String noidung2, String anhUrl, int luotThich, int luotBinhLuan) {
        this.postId = postId;
        this.userId = userId;
        this.avatarUrl = avatarUrl;
        this.tenUser = tenUser;
        this.thoiGian = thoiGian;
        this.noidung2 = noidung2;
        this.anhUrl = anhUrl;
        this.luotThich = luotThich;
        this.luotBinhLuan = luotBinhLuan;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNoidung2() {
        return noidung2;
    }

    public void setNoidung2(String noidung2) {
        this.noidung2 = noidung2;
    }

    public String getAnhUrl() {
        return anhUrl;
    }

    public void setAnhUrl(String anhUrl) {
        this.anhUrl = anhUrl;
    }

    public int getLuotThich() {
        return luotThich;
    }

    public void setLuotThich(int luotThich) {
        this.luotThich = luotThich;
    }

    public int getLuotBinhLuan() {
        return luotBinhLuan;
    }

    public void setLuotBinhLuan(int luotBinhLuan) {
        this.luotBinhLuan = luotBinhLuan;
    }
}
