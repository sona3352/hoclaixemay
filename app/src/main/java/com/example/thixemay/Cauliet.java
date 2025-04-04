package com.example.thixemay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Cauliet extends AppCompatActivity {
    WebView web1;
    ImageView iv3;
    TextView tieude, tongcauhoi2, lamdung, sodiem2;
    Button batdau;
    int selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cauliet);

        tieude = findViewById(R.id.tieude);
        web1 = findViewById(R.id.web1);
        iv3 = findViewById(R.id.iv3);
        batdau = findViewById(R.id.batdau);

        Intent intent = getIntent();
        selectedItem = intent.getIntExtra("selected_item", -1);
        int imageResId = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");
        String htmlmota = "<html><body>" + intent.getStringExtra("mota") + "</body></html>";
        web1.loadData(htmlmota, "text/html", "UTF-8");
        iv3.setImageResource(imageResId);
        tieude.setText(title);


        batdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cauliet.this, Cauliet2.class);
                startActivity(intent);
            }
        });
    }
}
