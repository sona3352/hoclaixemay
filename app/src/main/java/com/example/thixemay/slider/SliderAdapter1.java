package com.example.thixemay.slider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thixemay.fragment.Luyenthi;

public class SliderAdapter1 extends FragmentStateAdapter {
    private static final int NUMBER_OF_PAGES = 25;
    private String dethiKey; // Thêm biến dethi_key

    public SliderAdapter1(@NonNull FragmentActivity fragmentActivity, String dethiKey) {
        super(fragmentActivity);
        this.dethiKey = dethiKey; // Lưu dethi_key khi tạo adapter
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Luyenthi fragment = new Luyenthi();
        Bundle args = new Bundle();
        args.putInt("POSITION", position);
        args.putString("DETHI_KEY", dethiKey); // Truyền dethi_key vào Bundle
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUMBER_OF_PAGES;
    }
}
