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

import com.example.thixemay.ClassLT;
import com.example.thixemay.R;

import java.util.ArrayList;

public class AdapterLT2 extends RecyclerView.Adapter<AdapterLT2.ClassLTViewHoder>{

    ArrayList<ClassLT> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        TextView bainoi, mota2;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            bainoi = itemView.findViewById(R.id.bainoi);
            mota2 = itemView.findViewById(R.id.mota2);
        }
    }

    public AdapterLT2(Activity aa, ArrayList<ClassLT> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lythuyet2, parent, false);
        return new ClassLTViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassLT main = list.get(position);
        holder.bainoi.setText(main.getTieude());
        holder.mota2.setText(main.getMota());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPosition = holder.getAdapterPosition();
                if (selectedPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(aa, Lythuyet.class);
                    intent.putExtra("selected_item", selectedPosition);
                    intent.putExtra("title", main.getTieude());
                    intent.putExtra("mota", main.getMota());
                    aa.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
