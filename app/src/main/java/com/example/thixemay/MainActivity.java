package com.example.thixemay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {
    ImageSlider is;
    RecyclerView rv2,rv5,rv7;
    TextView xahoi,canhan,dangxuat, khoahoc;
    ArrayList<ClassLT> list2,list3;
    ArrayList<ClassTrungtam> list1;
    AdapterLT LT;
    ImageView imgMenu;
    AdapterMenu2 Menu2;
    AdapterTrungtam trungtam;
    DatabaseReference databaseReference;
    LinearLayout layout99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        layout99 = findViewById(R.id.layout99);
        imgMenu = findViewById(R.id.imgMenu);
        xahoi = findViewById(R.id.xahoi);
        khoahoc = findViewById(R.id.khoahocdk);
        khoahoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Theodoi.class);
                startActivity(intent);
            }
        });
        xahoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Xahoi.class);
                startActivity(intent);
            }
        });

        is = findViewById(R.id.is);
        ArrayList<SlideModel> sm = new ArrayList<>();
        sm.add(new SlideModel(R.drawable.a1, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a2, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a3, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a4, ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.a5, ScaleTypes.CENTER_CROP));
        is.setImageList(sm, ScaleTypes.CENTER_CROP);


        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout99.getVisibility() == View.GONE) {
                    layout99.setVisibility(View.VISIBLE);
                } else {
                    layout99.setVisibility(View.GONE);
                }
            }
        });

        canhan = findViewById(R.id.canhan);
        canhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, thongtincanhan.class);
                startActivity(intent);
            }
        });


        dangxuat = findViewById(R.id.dangxuat);
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // Đăng xuất khỏi Firebase
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(MainActivity.this, Dangnhap.class);
                startActivity(intent);
                finish();
            }
        });

        rv7 = findViewById(R.id.rv7);
        rv7.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        rv7.addItemDecoration(new SpaceItemDecoration(spacingInPixels));

        list1 = new ArrayList<>();
        trungtam = new AdapterTrungtam(this, list1);
        rv7.setAdapter(trungtam);
        DatabaseReference data = FirebaseDatabase.getInstance().getReference("trungtam");
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    String trungtamId = data.getKey(); // Lấy ID của trung tâm
                    ClassTrungtam mainClass = data.getValue(ClassTrungtam.class);

                    if (mainClass != null) {
                        mainClass.setId(trungtamId); // Gán ID vào trung tâm
                        list1.add(mainClass);
                    }
                }
                trungtam.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Error: " + error.getMessage());
            }
        });


        rv5 = findViewById(R.id.rv5);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 2);
        rv5.setLayoutManager(gridLayoutManager3);
        rv5.setNestedScrollingEnabled(false);
        list3 = new ArrayList<>();
        list3.add(new ClassLT(R.drawable.b2, "KIẾN THỨC CƠ BẢN", "6 chủ đề, nhiều câu hỏi - Khám phá kiến thức lý thuyết với các câu hỏi đầy đủ và dễ hiểu."));
        list3.add(new ClassLT(R.drawable.b1, "BIỂN BÁO GIAO THÔNG", "Các biển báo giao thông đường bộ - Cung cấp thông tin chi tiết về biển báo và ý nghĩa của chúng."));
        list3.add(new ClassLT(R.drawable.b3, "CÁC MẸO THI TỐT", "Mẹo để thi tốt đề thi - Những chiến lược và mẹo giúp bạn tự tin hơn khi làm bài thi lái xe."));

        list3.add(new ClassLT(
                R.drawable.b6,
                "CÁC CÂU ĐIỂM LIỆT",
                "<h2>TỔNG HỢP 20 CÂU HỎI LIỆT THI BẰNG LÁI A1 CHÍNH THỨC TỪ 01/08/2020</h2>" +
                        "<p>Cấu trúc bộ câu hỏi câu điểm liệt hạng A1 sẽ bao gồm 20 câu hỏi, mỗi câu hỏi chỉ có duy nhất 1 đáp án đúng, phản ánh đúng bản chất của thi trắc nghiệm. " +
                        "Khác hẳn với bộ đề thi luật cũ là có 2 đáp án.</p>" +
                        "<ul>" +
                        "<li><b>Số lượng câu hỏi:</b> 20 Câu.</li>" +
                        "<li><b>Yêu cầu:</b> Làm đúng 20/20 Câu.</li>" +
                        "</ul>"
        ));

        Menu2 = new AdapterMenu2(this, list3);
        rv5.setAdapter(Menu2);

        rv2 = findViewById(R.id.rv2);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 1);
        rv2.setLayoutManager(gridLayoutManager2);
        rv2.setNestedScrollingEnabled(false);
        list2 = new ArrayList<>();
        list2.add(new ClassLT(R.drawable.b5,"THI THỬ SÁT HẠCH","Tổng hợp các bộ đề thi sát hạch A1"));
        list2.add(new ClassLT(R.drawable.b4,"VIDEO MÔ PHỎNG","Video mô phỏng lái xe thực tế"));
        LT = new AdapterLT(this, list2);
        rv2.setAdapter(LT);
    }
    @Override
    protected void onResume() {
        super.onResume();
        layout99.setVisibility(View.GONE);
    }
}