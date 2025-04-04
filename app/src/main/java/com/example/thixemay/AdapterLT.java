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
public class AdapterLT extends RecyclerView.Adapter<AdapterLT.ClassLTViewHoder>{

    ArrayList<ClassLT> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView ten1,mota1;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            ten1 = itemView.findViewById(R.id.ten1);
            mota1 = itemView.findViewById(R.id.mota1);
        }
    }

    public AdapterLT(Activity aa, ArrayList<ClassLT> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_1, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassLT main = list.get(position);
        holder.iv.setImageResource(main.getAnh());
        holder.ten1.setText(main.getTieude());
        holder.mota1.setText(main.getMota());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPosition = holder.getAdapterPosition();
                if (selectedPosition != RecyclerView.NO_POSITION) {
                    Intent intent;

                    // Xác định Activity cần mở dựa vào vị trí
                    switch (selectedPosition) {
                        case 0:
                            intent = new Intent(aa, Thithu.class);
                            break;
                        case 1:
                            intent = new Intent(aa, Video.class);
                            break;
                        default:
                            intent = new Intent(aa, Video.class);
                            break;
                    }

                    // Truyền thêm dữ liệu
                    intent.putExtra("selected_item", selectedPosition);
                    intent.putExtra("image", main.getAnh());
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
