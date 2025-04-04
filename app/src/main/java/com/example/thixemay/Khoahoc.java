package com.example.thixemay;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Khoahoc extends AppCompatActivity {
    RecyclerView rvzz;
    ArrayList<ClassKhoahoc> list1;
    AdapterKhoahoc khoahoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_khoahoc);
        rvzz = findViewById(R.id.rvzz);

        rvzz = findViewById(R.id.rvzz);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 1);
        rvzz.setLayoutManager(gridLayoutManager3);
        list1 = new ArrayList<>();
        khoahoc = new AdapterKhoahoc(this, list1);
        rvzz.setAdapter(khoahoc );
        // Nhận trungTamId từ Intent
        String trungTamId = getIntent().getStringExtra("trungTamId");
        // Lấy dữ liệu từ Firebase theo trung tâm
        DatabaseReference data = FirebaseDatabase.getInstance().getReference("trungtam").child(trungTamId).child("khoahoc");
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ClassKhoahoc khoahoc = dataSnapshot.getValue(ClassKhoahoc.class);
                    if (khoahoc != null) {
                        list1.add(khoahoc);
                    }
                }
                khoahoc.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Error: " + error.getMessage());
            }
        });
    }
}