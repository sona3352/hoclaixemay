package com.example.thixemay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lythuyet extends AppCompatActivity {
    int selectedItem;
    TextView noidung,tieude,cauhoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lythuyet);


        noidung =findViewById(R.id.noidung);
        tieude =findViewById(R.id.tieude);
        cauhoi =findViewById(R.id.cauhoi);
        Intent intent = getIntent();
        selectedItem = intent.getIntExtra("selected_item", -1);
        String title = intent.getStringExtra("title");
        String chitiet = intent.getStringExtra("mota");
        noidung.setText(chitiet);
        tieude.setText(title);
        cauhoi.setText("Câu " +  (selectedItem + 1));

    }
}