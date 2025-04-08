package com.example.thixemay;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
public class Ketthuc extends AppCompatActivity {
    ImageView iv5, iv6;
    TextView ketqua, loinhac, tyle, chualam, textView2;
    ProgressBar proba;
    Button ketthuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ketthuc);

        ketthuc = findViewById(R.id.ketthuc);
        GradientDrawable border = new GradientDrawable();
        border.setShape(GradientDrawable.OVAL);
        border.setStroke(10, Color.BLACK);
        iv5 = findViewById(R.id.iv5);

        Glide.with(this)
                .load(R.drawable.dora4)
                .apply(RequestOptions.circleCropTransform())
                .into(iv5);
        iv5.setBackground(border);

        iv6 = findViewById(R.id.iv6);

        textView2 = findViewById(R.id.textView2);
        ketqua = findViewById(R.id.ketqua);
        loinhac = findViewById(R.id.loinhac);
        tyle = findViewById(R.id.tyle);
        proba = findViewById(R.id.proba);

        // Nhận thông tin từ Intent
        int socaudung = getIntent().getIntExtra("CAU_DUNG", 0);
        int tongcauhoi = getIntent().getIntExtra("TONG_CAU_HOI", 0);
        String text = getIntent().getStringExtra("MO_TA");
        boolean diemlietSai = getIntent().getBooleanExtra("DIEM_LIET_SAI", false);
        ketqua.setText("Số câu đúng: " + socaudung + "/" + tongcauhoi);

        float percentage = (socaudung * 100f) / tongcauhoi;
        proba.setProgress((int) percentage);
        tyle.setText("Tỷ lệ: " + (int) percentage + "%");

        if (diemlietSai) {
            loinhac.setText("KHÔNG ĐẠT - Bạn đã trượt bài thi vì sai câu điểm liệt.");
            loinhac.setTextColor(Color.RED);
            Glide.with(this).load(R.drawable.sad).into(iv6);
        } else {
            if (percentage >= 84) {
                loinhac.setText("ĐẠT - Chúc mừng bạn đã vượt qua bài thi trắc nghiệm");
                loinhac.setTextColor(Color.GREEN);
                Glide.with(this).load(R.drawable.vui).into(iv6);
            } else {
                loinhac.setText("KHÔNG ĐẠT - Hãy cố gắng hơn lần sau");
                loinhac.setTextColor(Color.RED);
                Glide.with(this).load(R.drawable.sad).into(iv6);
            }
        }

        ketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ketthuc.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
