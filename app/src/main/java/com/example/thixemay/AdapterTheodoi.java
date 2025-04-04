package com.example.thixemay;

import android.app.Activity;
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

import java.util.ArrayList;

public class AdapterTheodoi extends RecyclerView.Adapter<AdapterTheodoi.ViewHolder> {
    private Activity context;
    private ArrayList<ClassKhoahoc> list;

    public AdapterTheodoi(Activity context, ArrayList<ClassKhoahoc> list) {
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenKhoaHoc2, tvGioiThieu2, tvGiaBan2, tvTrangthai,tvXoaKhoaHoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenKhoaHoc2 = itemView.findViewById(R.id.tvTenKhoaHoc2);
            tvGioiThieu2 = itemView.findViewById(R.id.tvGioiThieu2);
            tvGiaBan2 = itemView.findViewById(R.id.tvGiaBan2);
            tvTrangthai = itemView.findViewById(R.id.tvTrangthai);
            tvXoaKhoaHoc = itemView.findViewById(R.id.tvXoaKhoaHoc);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theodoi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassKhoahoc khoaHoc = list.get(position);
        holder.tvTenKhoaHoc2.setText(khoaHoc.getTenkhoahoc());
        holder.tvGioiThieu2.setText(khoaHoc.getGioithieu());
        holder.tvGiaBan2.setText(String.valueOf(khoaHoc.getGiaban()) + " VND");
        holder.tvTrangthai.setText(khoaHoc.getTrangthai());
        holder.tvXoaKhoaHoc.setOnClickListener(v -> {
            // Lấy ID người dùng hiện tại
            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

            // Lấy ID khóa học từ đối tượng ClassKhoahoc
            String idKhoaHoc = list.get(position).getId();

            // Kiểm tra idKhoaHoc có hợp lệ không
            if (idKhoaHoc != null) {
                // Xoá khóa học khỏi Firebase theo ID khóa học
                DatabaseReference database = FirebaseDatabase.getInstance().getReference("DangKyKhoaHoc");

                database.child(userId).child(idKhoaHoc).removeValue()
                        .addOnSuccessListener(aVoid -> {
                            // Xoá thành công
                            Toast.makeText(context, "Xoá khóa học thành công", Toast.LENGTH_SHORT).show();
                            list.remove(position);  // Xóa khóa học khỏi danh sách
                            notifyItemRemoved(position);  // Cập nhật UI
                        })
                        .addOnFailureListener(e -> {
                            // Thất bại khi xoá
                            Toast.makeText(context, "Không thể xoá khóa học", Toast.LENGTH_SHORT).show();
                        });
            } else {
                // Nếu idKhoaHoc là null, thông báo lỗi
                Toast.makeText(context, "ID khóa học không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
