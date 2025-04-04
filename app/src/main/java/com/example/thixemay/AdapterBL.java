package com.example.thixemay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterBL extends RecyclerView.Adapter<AdapterBL.BinhLuanViewHolder> {

    private Context context;
    private ArrayList<ClassBLuan> binhLuanList;

    public AdapterBL(Context context, ArrayList<ClassBLuan> binhLuanList) {
        this.context = context;
        this.binhLuanList = binhLuanList;
    }

    @NonNull
    @Override
    public BinhLuanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.binhluan, parent, false);
        return new BinhLuanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BinhLuanViewHolder holder, int position) {
        ClassBLuan binhLuan = binhLuanList.get(position);
        holder.tenUser.setText(binhLuan.getTenUser());
        holder.noiDung.setText(binhLuan.getNoiDung());
        holder.thoiGian.setText(binhLuan.getThoiGian());
        Glide.with(context).load(binhLuan.getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return binhLuanList.size();
    }

    public static class BinhLuanViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView tenUser, noiDung, thoiGian;

        public BinhLuanViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            tenUser = itemView.findViewById(R.id.tenUser);
            noiDung = itemView.findViewById(R.id.noiDung);
            thoiGian = itemView.findViewById(R.id.thoiGian);
        }
    }
}
