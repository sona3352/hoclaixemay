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
    String tendang; // Thêm biến này để truyền từ Dangcau.java

    public AdapterDangcau(Activity activity, ArrayList<String> listCauhoi, String tendang) {
        this.activity = activity;
        this.listCauhoi = listCauhoi;
        this.tendang = tendang; // Lưu phần thi hiện tại
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
        String tenCau = listCauhoi.get(position);
        holder.txtCauhoi.setText(tenCau);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, Loadcauhoi.class);
            intent.putExtra("tendang", tendang);
            intent.putExtra("tenCau", tenCau);
            activity.startActivity(intent);
        });

        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(activity)
                    .setTitle("Xác nhận xoá")
                    .setMessage("Bạn có muốn xoá câu này không?")
                    .setPositiveButton("OK", (dialog, which) -> xoaCauHoi(position))
                    .setNegativeButton("Hủy", null)
                    .show();
            return true;
        });
    }


    @Override
    public int getItemCount() {
        return listCauhoi.size();
    }

    private void xoaCauHoi(int position) {
        if (position == RecyclerView.NO_POSITION) return;

        String cauHoiXoa = listCauhoi.get(position);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang).child(cauHoiXoa);
        databaseReference.removeValue().addOnSuccessListener(aVoid -> {
            listCauhoi.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(activity, "Đã xoá câu hỏi", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(e -> {
            Toast.makeText(activity, "Lỗi khi xoá trên Firebase", Toast.LENGTH_SHORT).show();
        });
    }

}
