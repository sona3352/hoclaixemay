package com.example.thixemay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Quantri extends AppCompatActivity {
    RecyclerView rv11,rv12;
    ImageSlider is;
    private List<ClassQT> list;
    private List<ClassND> list2;
    AdapterQT qt;
    AdapterQLTK qltk;
    Button btndangxuat;
    DatabaseReference databaseReference;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quantri);

        is = findViewById(R.id.is);
        ArrayList<SlideModel> sm = new ArrayList<>();
        sm.add(new SlideModel(R.drawable.a1, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a2, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a3, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a4, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a5, ScaleTypes.CENTER_CROP));
        is.setImageList(sm, ScaleTypes.CENTER_CROP);

        rv12 = findViewById(R.id.rv12);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 2);
        rv12.setLayoutManager(gridLayoutManager2);
        list2 = new ArrayList<>();
        qltk = new AdapterQLTK(this, (ArrayList<ClassND>) list2);
        rv12.setAdapter(qltk);

        databaseReference = FirebaseDatabase.getInstance().getReference("nguoidung");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ClassND nguoiDung = dataSnapshot.getValue(ClassND.class);
                    if (nguoiDung != null) {
                        list2.add(nguoiDung);
                    }
                }
                qltk.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Lỗi tải dữ liệu", error.toException());
            }
        });

        rv11 = findViewById(R.id.rv11);
        rv11.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        rv11.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
        list = new ArrayList<>(); // Khởi tạo danh sách
        qt = new AdapterQT(this, (ArrayList<ClassQT>) list);
        rv11.setAdapter(qt);


        databaseReference = FirebaseDatabase.getInstance().getReference("dethi");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    list.clear();

                    // Danh sách ảnh có sẵn trong drawable
                    int[] imageResources = {R.drawable.de1, R.drawable.de2, R.drawable.de3, R.drawable.de4,R.drawable.de5};

                    int index = 0; // Biến đếm để lấy ảnh theo thứ tự
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String tendang = dataSnapshot.getKey();
                        String tenhienthi = "Đề " + tendang.replaceAll("[^0-9]", "");
                        // Gán ảnh theo thứ tự, nếu hết ảnh thì dùng ảnh mặc định
                        int imageResId = (index < imageResources.length) ? imageResources[index] : com.denzcoskun.imageslider.R.drawable.loading;

                        list.add(new ClassQT(tenhienthi, tendang, imageResId));
                        index++; // Tăng biến đếm để lấy ảnh tiếp theo
                    }

                    qt.notifyDataSetChanged();
                } else {
                    Toast.makeText(Quantri.this, "Không có dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Quantri.this, "Lỗi Firebase: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




        btndangxuat = findViewById(R.id.btndangxuat);
        btndangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Quantri.this, Dangnhap.class);
                startActivity(intent);
                finish();
            }
        });
    }

}