package com.example.thixemay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Xahoi extends AppCompatActivity {
    TextView trangchu;
    RecyclerView rv3;
    ArrayList<ClassXH> list1;
    AdapterXH XH;
    private Cloudinary cloudinary;
    private Uri selectedImageUri;
    private EditText noidung;
    private Button chonanh, dangbai;
    private String uploadedImageUrl = "";
    private String avatabaidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xahoi);

        noidung = findViewById(R.id.editTextPostContent);
        chonanh = findViewById(R.id.buttonAddVideo);
        dangbai = findViewById(R.id.buttonPost);

        // Cấu hình Cloudinary
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dzrptegi7");
        config.put("api_key", "792814784672567");
        config.put("api_secret", "GI_tZC6lN6xpR1MeNpy53SLSsK4");
        cloudinary = new Cloudinary(config);

        rv3 = findViewById(R.id.rv3);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rv3.setLayoutManager(gridLayoutManager);
        list1 = new ArrayList<>();
        XH = new AdapterXH(this, list1);
        rv3.setAdapter(XH);
        loadBaiDang();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv3.getContext(), gridLayoutManager.getOrientation());
        rv3.addItemDecoration(dividerItemDecoration);

        trangchu = findViewById(R.id.home);
        trangchu.setOnClickListener(v -> {
            Intent intent = new Intent(Xahoi.this, MainActivity.class);
            startActivity(intent);
        });

        chonanh.setOnClickListener(v -> moThuVien());
        dangbai.setOnClickListener(v -> luuBaiDang());
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
                uploadedImageUrl = (String) uploadResult.get("secure_url"); // Lưu link ảnh

                runOnUiThread(() -> Toast.makeText(this, "Ảnh đã tải lên!", Toast.LENGTH_SHORT).show());
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "Lỗi tải ảnh lên Cloudinary", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    private void luuBaiDang() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Toast.makeText(this, "Bạn chưa đăng nhập!", Toast.LENGTH_SHORT).show();
            return;
        }

        String userId = user.getUid(); // Lấy ID của người dùng hiện tại
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("nguoidung").child(userId);


        userRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult().exists()) {
                String tenUser = task.getResult().child("hoten").getValue(String.class);
                avatabaidang = task.getResult().child("avatar").getValue(String.class);
                String thoiGian = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
                String noidungBaiDang = noidung.getText().toString().trim();
                int luotThich = 0, luotBinhLuan = 0;

                DatabaseReference baiDangRef = userRef.child("BaiDang");
                String key = baiDangRef.push().getKey();
                if (key == null) return;

                // Tạo bài đăng
                ClassXH baiDang = new ClassXH(key, userId, avatabaidang, tenUser, thoiGian, noidungBaiDang, uploadedImageUrl, luotThich, luotBinhLuan);
                baiDangRef.child(key).setValue(baiDang)
                        .addOnSuccessListener(unused -> Toast.makeText(this, "Đăng bài thành công!", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(this, "Lỗi đăng bài!", Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(this, "Không lấy được tên người dùng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadBaiDang() {
        DatabaseReference nguoiDungRef = FirebaseDatabase.getInstance().getReference("nguoidung");

        nguoiDungRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear();
                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    DataSnapshot baiDangSnapshot = userSnapshot.child("BaiDang");
                    for (DataSnapshot baiDang : baiDangSnapshot.getChildren()) {
                        ClassXH baiDangData = baiDang.getValue(ClassXH.class);
                        if (baiDangData != null) {
                            list1.add(baiDangData);
                        }
                    }
                }
                XH.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Xahoi.this, "Lỗi tải bài đăng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
