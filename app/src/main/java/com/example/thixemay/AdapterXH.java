package com.example.thixemay;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdapterXH extends RecyclerView.Adapter<AdapterXH.ClassXHViewHoder> {

    private ArrayList<ClassXH> list;
    private Activity activity;

    public static class ClassXHViewHoder extends RecyclerView.ViewHolder {
        ImageView avatar, iv2;
        TextView tenUser, thoiGian, noidung2, luotThich, luotBinhLuan, nutLike,nutBinhLuan,  nutChiaSe;
        ImageButton buttonLike, buttonComment, buttonShare;

        public ClassXHViewHoder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            tenUser = itemView.findViewById(R.id.tenuser);
            thoiGian = itemView.findViewById(R.id.thoigian);
            noidung2 = itemView.findViewById(R.id.noidung2);
            luotThich = itemView.findViewById(R.id.luotthich);
            luotBinhLuan = itemView.findViewById(R.id.luothinhluan);
            iv2 = itemView.findViewById(R.id.iv2);
            buttonLike= itemView.findViewById(R.id.buttonLike);
            buttonComment= itemView.findViewById(R.id.buttonComment);
            buttonShare= itemView.findViewById(R.id.buttonShare);
            nutLike= itemView.findViewById(R.id.nutlike);
            nutBinhLuan= itemView.findViewById(R.id.nutbinhluan);
            nutChiaSe= itemView.findViewById(R.id.nutchiase);
        }
    }

    // Constructor
    public AdapterXH(Activity activity, ArrayList<ClassXH> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ClassXHViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hienthibaidang, parent, false);
        return new ClassXHViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassXHViewHoder holder, int position) {
        ClassXH post = list.get(position);
        holder.tenUser.setText(post.getTenUser());
        holder.thoiGian.setText(post.getThoiGian());
        holder.noidung2.setText(post.getNoidung2());
        holder.luotThich.setText(post.getLuotThich() + " lượt thích");
        holder.luotBinhLuan.setText(post.getLuotBinhLuan() + " lượt bình luận");
        Glide.with(holder.itemView.getContext()).load(post.getAvatarUrl()).into(holder.avatar);

        if (post.getAnhUrl() != null && !post.getAnhUrl().isEmpty()) {
            holder.iv2.setVisibility(View.VISIBLE);
            Glide.with(holder.itemView.getContext()).load(post.getAnhUrl()).into(holder.iv2);
        } else {
            holder.iv2.setVisibility(View.GONE);
        }


        holder.nutLike.setOnClickListener(v -> {
            int soLikeMoi = post.getLuotThich() + 1;
            post.setLuotThich(soLikeMoi);
            holder.luotThich.setText(soLikeMoi + " lượt thích");

            // Lấy ID của người đăng bài & ID bài đăng
            String userId = post.getUserId();
            String postId = post.getPostId();

            if (userId == null || postId == null) return;

            // Cập nhật lượt thích trên Firebase
            DatabaseReference baiDangRef = FirebaseDatabase.getInstance()
                    .getReference("nguoidung")
                    .child(userId)
                    .child("BaiDang")
                    .child(postId)
                    .child("luotThich");

            baiDangRef.setValue(soLikeMoi);
        });

        holder.nutBinhLuan.setOnClickListener(v -> {
            String userId = post.getUserId();
            String postId = post.getPostId();

            if (userId == null || postId == null) return;

            // Tham chiếu đến danh sách bình luận của bài đăng
            DatabaseReference binhLuanRef = FirebaseDatabase.getInstance()
                    .getReference("BinhLuan")
                    .child(postId);

            binhLuanRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    long soLuongBL = snapshot.getChildrenCount(); // Đếm số lượng bình luận

                    // Cập nhật số lượng bình luận lên bài đăng
                    DatabaseReference capNhatBLRef = FirebaseDatabase.getInstance()
                            .getReference("nguoidung")
                            .child(userId)
                            .child("BaiDang")
                            .child(postId)
                            .child("luotBinhLuan");

                    capNhatBLRef.setValue(soLuongBL);
                    holder.luotBinhLuan.setText(soLuongBL + " lượt bình luận");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(activity, "Lỗi cập nhật số lượng bình luận!", Toast.LENGTH_SHORT).show();
                }
            });

            // Chuyển sang màn hình bình luận
            Intent intent = new Intent(activity, Binhluan.class);
            intent.putExtra("postId", post.getPostId());
            activity.startActivity(intent);
        });


    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
