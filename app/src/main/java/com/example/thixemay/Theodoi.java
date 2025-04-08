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


        list = new ArrayList<>();
        adapter = new AdapterTheodoi(this, list);
        recyclerView.setAdapter(adapter);


        database = FirebaseDatabase.getInstance().getReference("DangKyKhoaHoc");


        String userId = currentUser.getUid();


        DatabaseReference userKhoaHocRef = database.child(userId);

        userKhoaHocRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String idKhoaHoc = snapshot.getKey();

                    ClassKhoahoc khoahoc = snapshot.getValue(ClassKhoahoc.class);
                    if (khoahoc != null) {
                        khoahoc.setId(idKhoaHoc);
                        list.add(khoahoc);
                    }
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Theodoi.this, "Lỗi khi lấy dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
