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

public class Video extends AppCompatActivity {
    RecyclerView rv4;
    ImageView iv3;
    TextView tieude, mota3;
    ArrayList<Classphim> list9;
    int selectedItem;
    AdapterXP xp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);

        tieude = findViewById(R.id.tieude);
        iv3 = findViewById(R.id.iv3);
        mota3 = findViewById(R.id.mota3);
        rv4 = findViewById(R.id.rv4);


        Intent intent = getIntent();
        selectedItem = intent.getIntExtra("selected_item", -1);
        int imageResId = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");

        iv3.setImageResource(imageResId);
        tieude.setText(title);

        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 2);
        rv4.setLayoutManager(gridLayoutManager3);
        list9 = new ArrayList<>();
        list9.add(new Classphim(R.drawable.me1,"Lái xe thực tế 1","android.resource://" + getPackageName() + "/" + R.raw.meo1));
        list9.add(new Classphim(R.drawable.me2,"Lái xe thực tế 2","android.resource://" + getPackageName() + "/" + R.raw.meo2));
        list9.add(new Classphim(R.drawable.me3,"Lái xe thực tế 3","android.resource://" + getPackageName() + "/" + R.raw.meo3));
        list9.add(new Classphim(R.drawable.me4,"Lái xe thực tế 4","android.resource://" + getPackageName() + "/" + R.raw.meo4));
        list9.add(new Classphim(R.drawable.me5,"Lái xe thực tế 5","android.resource://" + getPackageName() + "/" + R.raw.meo5));
        xp = new AdapterXP(this, list9);
        rv4.setAdapter(xp);


    }


}
