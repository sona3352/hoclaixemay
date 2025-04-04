package com.example.thixemay;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Theodoi extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterTheodoi adapter;
    private ArrayList<ClassKhoahoc> list;
    private DatabaseReference database;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theodoi);

        // Lấy thông tin người dùng hiện tại
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            Toast.makeText(this, "Bạn cần đăng nhập", Toast.LENGTH_SHORT).show();
            return;
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Khởi tạo mảng khóa học
        list = new ArrayList<>();
        adapter = new AdapterTheodoi(this, list);
        recyclerView.setAdapter(adapter);

// Lấy dữ liệu từ Firebase theo id người dùng
        database = FirebaseDatabase.getInstance().getReference("DangKyKhoaHoc");

// Lấy UID của người dùng hiện tại
        String userId = currentUser.getUid();  // Lấy UID của người dùng hiện tại

// Truy vấn khóa học đã đăng ký của người dùng (dùng UID của người dùng)
        DatabaseReference userKhoaHocRef = database.child(userId); // Dùng userId làm key cho node người dùng

        userKhoaHocRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear(); // Xóa dữ liệu cũ trước khi thêm dữ liệu mới
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String idKhoaHoc = snapshot.getKey(); // Lấy ID khóa học từ Firebase

                    ClassKhoahoc khoahoc = snapshot.getValue(ClassKhoahoc.class); // Chuyển dữ liệu thành đối tượng ClassKhoahoc
                    if (khoahoc != null) {
                        khoahoc.setId(idKhoaHoc); // Gán ID khóa học vào đối tượng
                        list.add(khoahoc); // Thêm khóa học vào danh sách
                    }
                }
                adapter.notifyDataSetChanged(); // Cập nhật adapter để hiển thị dữ liệu
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Theodoi.this, "Lỗi khi lấy dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
