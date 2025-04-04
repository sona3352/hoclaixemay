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
import java.util.ArrayList;
public class AdapterBienBao extends RecyclerView.Adapter<AdapterBienBao.ClassLTViewHoder>{

    ArrayList<ClassLT> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        ImageView bienbao;
        TextView tieudebienbao, mota4;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            bienbao = itemView.findViewById(R.id.bienbao);
            tieudebienbao = itemView.findViewById(R.id.tieudebienbao);
            mota4 = itemView.findViewById(R.id.mota4);
        }
    }

    public AdapterBienBao(Activity aa, ArrayList<ClassLT> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cacbienbao, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassLT main = list.get(position);
        holder.bienbao.setImageResource(main.getAnh());
        holder.tieudebienbao.setText(main.getTieude());
        holder.mota4.setText(main.getMota());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
