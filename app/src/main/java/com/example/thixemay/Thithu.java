package com.example.thixemay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Thithu extends AppCompatActivity {
    RecyclerView rv4;
    ImageView iv3;
    TextView tieude, mota3;
    ArrayList<ClassLT> list1;
    AdapterDT dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thithu);

        tieude = findViewById(R.id.tieude);
        iv3 = findViewById(R.id.iv3);
        mota3 = findViewById(R.id.mota3);
        rv4 = findViewById(R.id.rv4);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");
        String mota = intent.getStringExtra("mota");

        // Gán dữ liệu lên giao diện
        mota3.setText(mota);
        iv3.setImageResource(imageResId);
        tieude.setText(title);

        // Khởi tạo danh sách và Adapter
        list1 = new ArrayList<>();
        dt = new AdapterDT(this, list1);
        rv4.setLayoutManager(new LinearLayoutManager(this));
        rv4.setAdapter(dt);

        // Tải danh sách đề thi từ Firebase
        loadDeThiFromFirebase();
    }

    private void loadDeThiFromFirebase() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("dethi");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear(); // Xóa dữ liệu cũ trước khi thêm mới
                for (DataSnapshot deThiSnapshot : snapshot.getChildren()) {
                    String tenDe = deThiSnapshot.getKey();
                    list1.add(new ClassLT(0, tenDe.toUpperCase(), ""));
                }
                dt.notifyDataSetChanged(); // Cập nhật RecyclerView
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Lỗi tải đề thi: " + error.getMessage());
            }
        });
    }
}
