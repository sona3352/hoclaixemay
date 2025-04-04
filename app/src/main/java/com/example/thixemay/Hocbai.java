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

public class Hocbai extends AppCompatActivity {
    RecyclerView rv4;
    ImageView iv3;
    TextView tieude, mota3;
    ArrayList<ClassLT> list1;
    AdapterHB hb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hocbai);

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
        hb= new AdapterHB(this, list1);
        list1.add(new ClassLT(R.drawable.khainiem, "Khái niệm và quy tắc", "Giới thiệu về các khái niệm cơ bản và các quy tắc giao thông quan trọng."));
        list1.add(new ClassLT(R.drawable.vanhoa, "Văn hoá và đạo đức lái xe", "Những nguyên tắc ứng xử và đạo đức khi tham gia giao thông để đảm bảo an toàn."));
        list1.add(new ClassLT(R.drawable.laixe, "Kỹ thuật lái xe", "Hướng dẫn các kỹ thuật lái xe cơ bản và nâng cao để vận hành xe an toàn."));
        list1.add(new ClassLT(R.drawable.suachua, "Cấu tạo và sửa chữa", "Thông tin về cấu tạo ô tô và các kỹ thuật sửa chữa cơ bản."));
        list1.add(new ClassLT(R.drawable.duongbo, "Biển báo đường bộ", "Tổng hợp các loại biển báo giao thông và ý nghĩa của chúng."));
        list1.add(new ClassLT(R.drawable.sahinh, "Sa hình", "Hướng dẫn thực hành lái xe với các bài thi sa hình phổ biến."));
        rv4.setLayoutManager(new LinearLayoutManager(this));
        rv4.setAdapter(hb);

    }

}
