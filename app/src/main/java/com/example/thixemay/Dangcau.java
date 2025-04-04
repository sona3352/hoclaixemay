package com.example.thixemay;


import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class Dangcau extends AppCompatActivity {
    RecyclerView rv22;
    AdapterDangcau adapter;
    ArrayList<String> listCauhoi;
    String tendang;

    FloatingActionButton btnThemcau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangcau);

        tendang = getIntent().getStringExtra("tende");
        rv22= findViewById(R.id.rv22);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rv22.setLayoutManager(gridLayoutManager);
        rv22.setNestedScrollingEnabled(false);
        listCauhoi = new ArrayList<>();
        adapter = new AdapterDangcau(this, listCauhoi, tendang);
        rv22.setAdapter(adapter);
        btnThemcau = findViewById(R.id.fabThemcau);

        loadCauHoi();
        btnThemcau.setOnClickListener(view -> showInputDialog());

    }
    private void loadCauHoi() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCauhoi.clear(); // Chỉ lưu key câu hỏi
                for (DataSnapshot data : snapshot.getChildren()) {
                    String key = data.getKey(); // Lấy key (cauX)
                    if (key.startsWith("cau")) { // Lọc chỉ lấy câu hỏi
                        listCauhoi.add(key); // Lưu key để sử dụng
                    }
                }

                Collections.sort(listCauhoi, (o1, o2) -> {
                    int num1 = Integer.parseInt(o1.replace("cau", ""));
                    int num2 = Integer.parseInt(o2.replace("cau", ""));
                    return Integer.compare(num1, num2);
                });

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Lỗi tải dữ liệu", error.toException());
            }
        });
    }



    private void kiemTraVaThemCauHoi(int soCau) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang).child("cau" + soCau);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Toast.makeText(Dangcau.this, "Câu " + soCau + " đã tồn tại!", Toast.LENGTH_SHORT).show();
                } else {
                    themCauHoi(soCau);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Lỗi kiểm tra câu hỏi", error.toException());
            }
        });
    }
    private void themCauHoi(int soCau) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang);
            databaseReference.child("cau" + soCau).setValue("Câu " + soCau);  // Thêm câu đơn giản
            Toast.makeText(Dangcau.this, "Thêm câu " + soCau + " thành công!", Toast.LENGTH_SHORT).show();
    }


    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nhập câu muốn thêm");

        // EditText để nhập số câu
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setHint("Nhập số câu");
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String inputText = input.getText().toString();
            if (!inputText.isEmpty()) {
                int soCau = Integer.parseInt(inputText);
                kiemTraVaThemCauHoi(soCau);
            }
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        builder.show();
    }


}