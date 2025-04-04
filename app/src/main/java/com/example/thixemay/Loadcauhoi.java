package com.example.thixemay;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loadcauhoi extends AppCompatActivity {
    EditText txtCauhoi, txtHinhanh, txtA, txtB, txtC, txtD, txtDapAnDung;
    String tendang, tenCau;
    Button btnLuu, btnMoanh;
    List<DataSnapshot> danhSachCauHoi = new ArrayList<>();

    private Cloudinary cloudinary;
    private Uri selectedImageUri;
    int indexCauHoi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loadcauhoi);

        // Ánh xạ các TextView
        txtCauhoi = findViewById(R.id.txtCauhoi);
        txtHinhanh = findViewById(R.id.txtHinhanh);
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);
        txtD = findViewById(R.id.txtD);
        txtDapAnDung = findViewById(R.id.txtDapAnDung);
        btnLuu = findViewById(R.id.btnLuu);
        btnMoanh = findViewById(R.id.btnMoanh);

        // Cấu hình Cloudinary
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dzrptegi7");
        config.put("api_key", "792814784672567");
        config.put("api_secret", "GI_tZC6lN6xpR1MeNpy53SLSsK4");
        cloudinary = new Cloudinary(config);

        // Nhận dữ liệu từ Intent
        tendang = getIntent().getStringExtra("tendang");
        tenCau = getIntent().getStringExtra("tenCau");



        if (tendang == null || tenCau == null) {
            Toast.makeText(this, "Lỗi: Không nhận được dữ liệu", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Load dữ liệu từ Firebase
        loadCauHoi();
        btnLuu.setOnClickListener(v -> luuCauHoi());
        btnMoanh.setOnClickListener(v -> moThuVien());
    }
    private void moThuVien() {
        ImagePicker.with(this)
                .galleryOnly()
                .crop()
                .compress(512)
                .start(100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                uploadImageToCloudinary(selectedImageUri);
            }
        }
    }

    private void uploadImageToCloudinary(Uri imageUri) {
        new Thread(() -> {
            try {
                InputStream inputStream = getContentResolver().openInputStream(imageUri);
                if (inputStream == null) {
                    runOnUiThread(() -> Toast.makeText(this, "Lỗi khi mở ảnh", Toast.LENGTH_SHORT).show());
                    return;
                }

                Map<String, Object> options = ObjectUtils.asMap("resource_type", "image");
                Map uploadResult = cloudinary.uploader().upload(inputStream, options);
                String imageUrl = (String) uploadResult.get("secure_url");
                runOnUiThread(() -> txtHinhanh.setText(imageUrl));
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "Lỗi tải ảnh lên Cloudinary", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }
    private void loadCauHoi() {
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang).child(tenCau);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    Toast.makeText(Loadcauhoi.this, "Lỗi: Câu hỏi không tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }
                    loadCauHoiDon(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Loadcauhoi.this, "Lỗi tải dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadCauHoiDon(DataSnapshot snapshot) {
        hienThiCauHoi(snapshot);
    }

    private void hienThiCauHoi(DataSnapshot snapshot) {
        String cauhoi = snapshot.child("cauhoi").getValue(String.class);
        String hinhAnh = snapshot.child("hinhanh").getValue(String.class);
        String luaA = snapshot.child("luachonA").getValue(String.class);
        String luaB = snapshot.child("luachonB").getValue(String.class);
        String luaC = snapshot.child("luachonC").getValue(String.class);
        String luaD = snapshot.child("luachonD").getValue(String.class);
        String dapAnDung = snapshot.child("dapAnDung").getValue(String.class);

        updateTextView(txtCauhoi, cauhoi);
        updateTextView(txtHinhanh, hinhAnh);
        updateTextView(txtA, luaA != null ? "A. " + luaA : "");
        updateTextView(txtB, luaB != null ? "B. " + luaB : "");
        updateTextView(txtC, luaC != null ? "C. " + luaC : "");
        updateTextView(txtD, luaD != null ? "D. " + luaD : "");
        updateTextView(txtDapAnDung, dapAnDung != null ? "Đáp án đúng: " + dapAnDung : "");
        setLinkClick(txtHinhanh, hinhAnh);
    }
    private void luuCauHoi() {
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("dethi").child(tendang);
            // Lưu dữ liệu cho dang1,2,5
            DatabaseReference cauRef = ref.child(tenCau);
            cauRef.child("cauhoi").setValue(txtCauhoi.getText().toString());
            cauRef.child("hinhanh").setValue(txtHinhanh.getText().toString());
            cauRef.child("luachonA").setValue(txtA.getText().toString());
            cauRef.child("luachonB").setValue(txtB.getText().toString());
            cauRef.child("luachonC").setValue(txtC.getText().toString());
            cauRef.child("luachonD").setValue(txtD.getText().toString());
            cauRef.child("dapAnDung").setValue(txtDapAnDung.getText().toString());
        Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();

    }

    private void updateTextView(TextView textView, String text) {
        textView.setText(text != null ? text : "");
    }

    private void setLinkClick(TextView textView, String url) {
        if (url != null && !url.isEmpty()) {
            textView.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            });
        }
    }

}
