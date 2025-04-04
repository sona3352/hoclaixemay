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
public class AdapterTrungtam extends RecyclerView.Adapter<AdapterTrungtam.ClassLTViewHoder>{

    ArrayList<ClassTrungtam> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        ImageView imgTrungTam;
        TextView tvDiaChi, tvTenTrungTam,tvSDTextView;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            imgTrungTam = itemView.findViewById(R.id.imgTrungTam);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
            tvTenTrungTam = itemView.findViewById(R.id.tvTenTrungTam);
            tvSDTextView = itemView.findViewById(R.id.tvSDT);
        }
    }

    public AdapterTrungtam(Activity aa, ArrayList<ClassTrungtam> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trungtam, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassTrungtam main = list.get(position);
        holder.tvDiaChi.setText("\uD83C\uDFE0 "+ main.getDiachi());
        holder.tvSDTextView.setText("\uD83D\uDCDE "+main.getSdt());
        holder.tvTenTrungTam.setText(main.getTen());
        Glide.with(aa)
                .load(main.getHinhanh() != null ? main.getHinhanh() : R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgTrungTam);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(aa, Khoahoc.class);
            String trungTamId = main.getId();
            intent.putExtra("trungTamId", trungTamId);
            aa.startActivity(intent);
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
