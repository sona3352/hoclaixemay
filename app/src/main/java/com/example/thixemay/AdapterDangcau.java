package com.example.thixemay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class AdapterDangcau extends RecyclerView.Adapter<AdapterDangcau.ViewHolder> {
    Activity activity;
    ArrayList<String> listCauhoi;
    String tendang;

    public AdapterDangcau(Activity activity, ArrayList<String> listCauhoi, String tendang) {
        this.activity = activity;
        this.listCauhoi = listCauhoi;
        this.tendang = tendang;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCauhoi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCauhoi = itemView.findViewById(R.id.txtCauhoi);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cauhoi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tenCau = listCauhoi.get(position); // "cau1", "cau2"
        String soCau = tenCau.replaceAll("[^0-9]", ""); // Chuyển thành số
        holder.txtCauhoi.setText("Câu " + soCau); // Hiển thị "Câu 1", "Câu 2"

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, Loadcauhoi.class);
            intent.putExtra("tendang", tendang);
            intent.putExtra("tenCau", tenCau); // Truyền key "cau1", "cau2"
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listCauhoi.size();
    }

    private void xoaCauHoi(int position) {
        if (position == RecyclerView.NO_POSITION) return;

        String cauHoiXoa = listCauhoi.get(position); // key câu hỏi
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang).child(cauHoiXoa);
        databaseReference.removeValue().addOnSuccessListener(aVoid -> {
            listCauhoi.remove(position);
            notifyItemRemoved(position); // Cập nhật lại RecyclerView
            Toast.makeText(activity, "Đã xoá câu hỏi", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(e -> {
            Toast.makeText(activity, "Lỗi khi xoá trên Firebase", Toast.LENGTH_SHORT).show();
        });
    }
}
