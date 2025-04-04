package com.example.thixemay;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class AdapterHB extends RecyclerView.Adapter<AdapterHB.ClassLTViewHoder>{

    ArrayList<ClassLT> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        TextView bainoi,mota2;
        ImageView iv1;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            bainoi   = itemView.findViewById(R.id.bainoi);
            mota2 = itemView.findViewById(R.id.mota2);
            iv1 = itemView.findViewById(R.id.iv1);
        }
    }

    public AdapterHB(Activity aa, ArrayList<ClassLT> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hocbai, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassLT main = list.get(position);
        holder.bainoi.setText(main.getTieude());
        holder.mota2.setText(main.getMota());
        holder.iv1.setImageResource(main.getAnh());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPosition = holder.getAdapterPosition();
                if (selectedPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(aa, Hocbai2.class);
                    intent.putExtra("vitrinew", selectedPosition);
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
