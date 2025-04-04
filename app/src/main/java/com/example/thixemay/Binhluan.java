package com.example.thixemay;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Binhluan extends AppCompatActivity {

    private ImageView avatar;
    private EditText noiDung;
    private Button nutBL;
    private RecyclerView recyclerView;
    private ArrayList<ClassBLuan> binhLuanList;
    private AdapterBL adapter;
    private DatabaseReference databaseRef;
    private String postId, userId, tenUser, avatarUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_binhluan);

        // Ánh xạ View
        avatar = findViewById(R.id.avatar);
        noiDung = findViewById(R.id.noiDung);
        nutBL = findViewById(R.id.nutBL);
        recyclerView = findViewById(R.id.recyclerView);

        // Lấy postId từ Intent
        postId = getIntent().getStringExtra("postId");
        if (postId == null) {
            Toast.makeText(this, "Lỗi: Không tìm thấy ID bài đăng!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Kiểm tra người dùng đã đăng nhập chưa
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Toast.makeText(this, "Bạn cần đăng nhập để bình luận!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Khởi tạo Firebase Database
        databaseRef = FirebaseDatabase.getInstance().getReference("BinhLuan").child(postId);

        // Cấu hình RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binhLuanList = new ArrayList<>();
        adapter = new AdapterBL(this, binhLuanList);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), gridLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        // Tải thông tin người dùng
        loadUserData();

        // Tải danh sách bình luận
        loadBinhLuan();

        // Xử lý sự kiện nút bình luận
        nutBL.setOnClickListener(v -> themBinhLuan());
    }

    private void loadUserData() {
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("nguoidung").child(userId);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    tenUser = snapshot.child("hoten").getValue(String.class);
                    avatarUrl = snapshot.child("avatar").getValue(String.class);

                    // Kiểm tra nếu avatar không rỗng thì hiển thị lên ImageView
                    if (avatarUrl != null && !avatarUrl.isEmpty()) {
                        Glide.with(Binhluan.this).load(avatarUrl).into(avatar);
                    }
                } else {
                    Toast.makeText(Binhluan.this, "Không tìm thấy thông tin người dùng!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Binhluan.this, "Lỗi tải thông tin người dùng!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadBinhLuan() {
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                binhLuanList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ClassBLuan binhLuan = dataSnapshot.getValue(ClassBLuan.class);
                    binhLuanList.add(binhLuan);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Binhluan.this, "Lỗi tải bình luận!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void themBinhLuan() {
        String noiDungBL = noiDung.getText().toString().trim();
        if (TextUtils.isEmpty(noiDungBL)) {
            Toast.makeText(this, "Vui lòng nhập nội dung bình luận!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra xem dữ liệu người dùng đã tải chưa
        if (tenUser == null || avatarUrl == null) {
            Toast.makeText(this, "Đang tải thông tin người dùng, vui lòng thử lại!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tạo ID bình luận
        String binhLuanId = databaseRef.push().getKey();
        String thoiGian = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date());
        ClassBLuan binhLuan = new ClassBLuan(binhLuanId, userId, tenUser, avatarUrl, noiDungBL, thoiGian);

        // Lưu vào Firebase
        databaseRef.child(binhLuanId).setValue(binhLuan).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(Binhluan.this, "Bình luận thành công!", Toast.LENGTH_SHORT).show();
                noiDung.setText("");
            } else {
                Toast.makeText(Binhluan.this, "Lỗi khi gửi bình luận!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
