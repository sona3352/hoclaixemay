package com.example.thixemay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Loaibienbao extends AppCompatActivity {
    RecyclerView rv7;
    ImageView iv3;
    TextView tieude, mota3;
    ArrayList<ClassLT> list1;
    int selectedItem;
    AdapterLoaiBB loaibb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loaibienbao);

        tieude = findViewById(R.id.tieude);
        iv3 = findViewById(R.id.iv3);
        mota3 = findViewById(R.id.mota3);
        rv7 = findViewById(R.id.rv7);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        selectedItem = intent.getIntExtra("selected_item", -1);
        int imageResId = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");
        String mota = intent.getStringExtra("mota");

        // Gán dữ liệu lên giao diện
        mota3.setText(mota);
        iv3.setImageResource(imageResId);
        tieude.setText(title);


        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 2);
        rv7.setLayoutManager(gridLayoutManager3);
        list1 = new ArrayList<>();
        list1.add(new ClassLT(R.drawable.aa1, "Biển hiệu lệnh",""));
        list1.add(new ClassLT(R.drawable.bb1, "Biển cấm",""));
        list1.add(new ClassLT(R.drawable.cc1, "Biển chỉ dẫn",""));
        list1.add(new ClassLT(R.drawable.dd1, "Biển nguy hiểm",""));
        list1.add(new ClassLT(R.drawable.ee1, "Biển phụ",""));

        loaibb = new AdapterLoaiBB(this, list1);
        rv7.setAdapter(loaibb);
    }


}
