package com.example.thixemay;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class AdapterDT extends RecyclerView.Adapter<AdapterDT.ClassLTViewHoder>{

    ArrayList<ClassLT> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        TextView sode;
        Button btnbatdau;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            sode = itemView.findViewById(R.id.sode);
            btnbatdau = itemView.findViewById(R.id.btnBatDau);
        }
    }

    public AdapterDT(Activity aa, ArrayList<ClassLT> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dethi, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassLT main = list.get(position);
        holder.sode.setText(main.getTieude());
        holder.btnbatdau.setOnClickListener(v -> {
            Intent intent = new Intent(aa, Thithu2.class);
            intent.putExtra("dethi_key", main.getTieude());
            aa.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
