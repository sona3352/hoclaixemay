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
public class AdapterXP extends RecyclerView.Adapter<AdapterXP.ClassLTViewHoder>{

    ArrayList<Classphim> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        TextView txt1;
        ImageView iv1;
        Button xemngay;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            txt1 = itemView.findViewById(R.id.txt1);
            xemngay= itemView.findViewById(R.id.xemngay);
        }
    }

    public AdapterXP(Activity aa, ArrayList<Classphim> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        Classphim main = list.get(position);
        holder.txt1.setText(main.getTenphim2());
        holder.iv1.setImageResource(main.getAnh2());
        holder.xemngay.setOnClickListener(v -> {
            Intent intent = new Intent(aa, VideoMP.class);
            intent.putExtra("video_url", main.getUrlvideo2());
            aa.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
