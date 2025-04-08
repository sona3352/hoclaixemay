package com.example.thixemay;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterQT extends RecyclerView.Adapter<AdapterQT.MainClassViewHoder>{

    ArrayList<ClassQT> list;
    Activity aa;

    public static class MainClassViewHoder extends RecyclerView.ViewHolder{
        ImageView iv11;
        TextView ten11;
        public MainClassViewHoder(@NonNull View itemView){
            super(itemView);
            iv11 = itemView.findViewById(R.id.iv11);
            ten11 = itemView.findViewById(R.id.ten11);
        }
    }

    public AdapterQT(Activity aa, ArrayList<ClassQT> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public MainClassViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dangthi, parent, false);
        return new MainClassViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainClassViewHoder holder, int position) {
        ClassQT main = list.get(position);
        holder.ten11.setText(main.getTenhienthi());
        Glide.with(aa)
                .load(main.getAnhnen())
                .placeholder(com.denzcoskun.imageslider.R.drawable.loading)
                .error(com.denzcoskun.imageslider.R.drawable.loading)
                .into(holder.iv11);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(aa, Dangcau.class);
            intent.putExtra("tende", main.getTendang());
            aa.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
