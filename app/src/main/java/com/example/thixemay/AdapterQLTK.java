package com.example.thixemay;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterQLTK extends RecyclerView.Adapter<AdapterQLTK.ViewHolder> {
    private List<ClassND> nguoiDungList;
    private Context context;

    public AdapterQLTK(Context context, List<ClassND> nguoiDungList) {
        this.context = context;
        this.nguoiDungList = nguoiDungList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qltk, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassND nguoiDung = nguoiDungList.get(position);
        holder.tvHoten.setText(nguoiDung.getHoten());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Chitietnguoidung.class);
            intent.putExtra("userId", nguoiDung.getUserId());
            intent.putExtra("email", nguoiDung.getEmail());
            intent.putExtra("hoten", nguoiDung.getHoten());
            intent.putExtra("diachi", nguoiDung.getDiachi());
            intent.putExtra("role", nguoiDung.getRole());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHoten;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHoten = itemView.findViewById(R.id.tvHoten);
        }
    }
    }


