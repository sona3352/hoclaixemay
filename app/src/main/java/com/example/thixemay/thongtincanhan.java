package com.example.thixemay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.bumptech.glide.Glide;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class thongtincanhan extends AppCompatActivity {

    private TextInputEditText editTextHoTen, editTextEmail, editTextDiaChi;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private Button btnLuu, doianh2;
    ImageView avatacanhan;
    private Cloudinary cloudinary;
    private Uri selectedImageUri;
    private String uploadedImageUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thongtincanhan);



        // Cấu hình Cloudinary
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dzrptegi7");
        config.put("api_key", "792814784672567");
        config.put("api_secret", "GI_tZC6lN6xpR1MeNpy53SLSsK4");
        cloudinary = new Cloudinary(config);


        editTextHoTen = findViewById(R.id.editTextHoTen);
        btnLuu = findViewById(R.id.btnLuu);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextDiaChi = findViewById(R.id.editTextDiaChi);
        avatacanhan = findViewById(R.id.avatacanhan);
        doianh2 = findViewById(R.id.doianh2);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("nguoidung");

        if (auth.getCurrentUser() == null) {
            Toast.makeText(this, "Vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Dangnhap.class)); // Chuyển về màn hình đăng nhập
            finish(); // Đóng activity hiện tại
            return;
        }

        String userId = auth.getCurrentUser().getUid();
        myRef.child(userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null && task.getResult().exists()) {
                String avatarUrl = task.getResult().child("avatar").getValue(String.class);
                String email = task.getResult().child("email").getValue(String.class);
                String hoten = task.getResult().child("hoten").getValue(String.class);
                String diachi = task.getResult().child("diachi").getValue(String.class);

                if (avatarUrl != null && !avatarUrl.isEmpty()) {
                    Glide.with(thongtincanhan.this)
                            .load(avatarUrl)
                            .placeholder(com.denzcoskun.imageslider.R.drawable.default_selected_dot)
                            .error(com.denzcoskun.imageslider.R.drawable.error)
                            .into(avatacanhan);
                }

                editTextEmail.setText(email);
                editTextHoTen.setText(hoten);
                editTextDiaChi.setText(diachi);
            } else {
                Toast.makeText(thongtincanhan.this, "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
            }
        });




        btnLuu.setOnClickListener(v -> {
            String hoTen = editTextHoTen.getText().toString();
            String diaChi = editTextDiaChi.getText().toString();

            if (hoTen.isEmpty()) {
                Toast.makeText(thongtincanhan.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo đối tượng người dùng
            ClassND user = new ClassND(
                    uploadedImageUrl,
                    auth.getCurrentUser().getEmail(),
                    hoTen,diaChi,""

            );

            // Lưu vào Firebase với userId
            myRef.child(userId).setValue(user).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(thongtincanhan.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(thongtincanhan.this, "Lỗi cập nhật thông tin", Toast.LENGTH_SHORT).show();
                }
            });
        });

        doianh2.setOnClickListener(v -> moThuVien());

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
}
