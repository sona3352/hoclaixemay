package com.example.thixemay.slider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thixemay.fragment.Diemliet;
import com.example.thixemay.fragment.Khainiem;
import com.example.thixemay.fragment.Kythuat;


public class SliderAdapterKT extends FragmentStateAdapter {
    private static final int NUMBER_OF_PAGES = 18;


    public SliderAdapterKT(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Kythuat fragment = new Kythuat();
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
