package com.example.thixemay;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterKhoahoc extends RecyclerView.Adapter<AdapterKhoahoc.ClassLTViewHoder>{

    ArrayList<ClassKhoahoc> list;
    Activity aa;

    public static class ClassLTViewHoder extends RecyclerView.ViewHolder{
        TextView tvTenKhoaHoc, tvGioithieu,tvGiaBan;
        Button btnDangKy;
        public ClassLTViewHoder(@NonNull View itemView){
            super(itemView);
            tvTenKhoaHoc = itemView.findViewById(R.id.tvTenKhoaHoc);
            tvGioithieu = itemView.findViewById(R.id.tvGioithieu);
            tvGiaBan = itemView.findViewById(R.id.tvGiaBan);
            btnDangKy = itemView.findViewById(R.id.btnDangKy);
        }
    }

    public AdapterKhoahoc(Activity aa, ArrayList<ClassKhoahoc> list) {
        this.aa = aa;
        this.list = list;

    }

    @NonNull
    @Override
    public ClassLTViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.khoahoc, parent, false);
        return new ClassLTViewHoder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassLTViewHoder holder, int position) {
        ClassKhoahoc main = list.get(position);
        holder.tvTenKhoaHoc.setText(main.getTenkhoahoc());
        holder.tvGioithieu.setText(main.getGioithieu());
        holder.tvGiaBan.setText(String.valueOf(main.getGiaban() + " VND"));
        holder.btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy ID người dùng đang đăng nhập
                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser != null) {
                    String userId = firebaseUser.getUid();


                    DatabaseReference nguoiDungRef = FirebaseDatabase.getInstance().getReference("nguoidung").child(userId);
                    nguoiDungRef.get().addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Lấy thông tin người dùng
                            String tenNguoiDung = task.getResult().child("hoten").getValue(String.class);
                            String email = task.getResult().child("email").getValue(String.class);
                            String diaChi = task.getResult().child("diachi").getValue(String.class);
                            String avatar = task.getResult().child("avatar").getValue(String.class);


                            String tenKhoaHoc = main.getTenkhoahoc();
                            String gioiThieu = main.getGioithieu();
                            int giaBan = main.getGiaban();

                            // Tạo dữ liệu để lưu vào Firebase
                            HashMap<String, Object> data = new HashMap<>();
                            data.put("tenkhoahoc", tenKhoaHoc);
                            data.put("gioithieu", gioiThieu);
                            data.put("giaban", giaBan);
                            data.put("idNguoiDung", userId);
                            data.put("tennguoidung", tenNguoiDung);
                            data.put("email", email);
                            data.put("diaChi", diaChi);
                            data.put("avatar", avatar);
                            data.put("trangthai", "Chờ duyệt");

                            DatabaseReference userKhoaHocRef = FirebaseDatabase.getInstance().getReference("DangKyKhoaHoc").child(userId);

                            String idDangKy = userKhoaHocRef.push().getKey();

                            if (idDangKy != null) {
                                userKhoaHocRef.child(idDangKy).setValue(data)
                                        .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(aa, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                                        })
                                        .addOnFailureListener(e -> {
                                            Toast.makeText(aa, "Đăng ký thất bại!", Toast.LENGTH_SHORT).show();
                                        });
                            }
                        } else {
                            Toast.makeText(aa, "Không thể lấy thông tin người dùng!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(aa, "Bạn chưa đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
