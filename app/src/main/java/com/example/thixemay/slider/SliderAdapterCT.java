package com.example.thixemay.slider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thixemay.fragment.Cautao;
import com.example.thixemay.fragment.Diemliet;
import com.example.thixemay.fragment.Khainiem;


public class SliderAdapterCT extends FragmentStateAdapter {
    private static final int NUMBER_OF_PAGES = 7;


    public SliderAdapterCT(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Cautao fragment = new Cautao();
        Bundle args = new Bundle();
        args.putInt("POSITION", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUMBER_OF_PAGES;
    }
}
