package com.example.thixemay;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dangnhap extends AppCompatActivity {
    EditText taikhoan, matkhau;
    TextView dangky, quenmatkhau;
    Button btndangnhap;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangnhap);

        taikhoan = findViewById(R.id.taikhoan);
        matkhau = findViewById(R.id.matkhau);
        btndangnhap = findViewById(R.id.dangnhap);
        dangky = findViewById(R.id.dangky);
        quenmatkhau = findViewById(R.id.quenmatkhau);

        auth = FirebaseAuth.getInstance();

        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
        String userRole = preferences.getString("userRole", "user");

        if (isLoggedIn) {
            Intent intent = ("admin".equals(userRole))
                    ? new Intent(Dangnhap.this, Quantri.class)
                    : new Intent(Dangnhap.this, MainActivity.class);

            startActivity(intent);
            finish();
        }

        quenmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = taikhoan.getText().toString().trim();

                if (email.isEmpty()) {
                    showAlertDialog("Thông báo", "Vui lòng nhập email của bạn");
                } else {
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(Dangnhap.this, task -> {
                                if (task.isSuccessful()) {
                                    showAlertDialog("Thông báo", "Đã gửi email để khôi phục mật khẩu");
                                } else {
                                    showAlertDialog("Lỗi", "Không thể gửi email khôi phục, vui lòng thử lại");
                                }
                            });
                }
            }
        });

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String laytaikhoan = taikhoan.getText().toString().trim();
                String laymatkhau = matkhau.getText().toString().trim();

                if (laytaikhoan.isEmpty() || laymatkhau.isEmpty()) {
                    showAlertDialog("Thông báo", "Vui lòng nhập tài khoản và mật khẩu");
                    return;
                }

                auth.signInWithEmailAndPassword(laytaikhoan, laymatkhau)
                        .addOnCompleteListener(Dangnhap.this, task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = auth.getCurrentUser();
                                if (user == null) {
                                    showAlertDialog("Lỗi", "Không tìm thấy thông tin tài khoản.");
                                    return;
                                }

                                String userId = user.getUid();
                                DatabaseReference userRef = FirebaseDatabase.getInstance()
                                        .getReference("nguoidung").child(userId);
                                userRef.get().addOnCompleteListener(dataTask -> {
                                    if (dataTask.isSuccessful() && dataTask.getResult().exists()) {
                                        String role = dataTask.getResult().child("role").getValue(String.class);
                                        if (role == null) role = "user"; // Mặc định nếu không có role

                                        // Lưu vào SharedPreferences
                                        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putBoolean("isLoggedIn", true);
                                        editor.putString("userRole", role);
                                        editor.apply();

                                        // Chuyển sang activity phù hợp
                                        Intent intent = ("admin".equals(role))
                                                ? new Intent(Dangnhap.this, Quantri.class)
                                                : new Intent(Dangnhap.this, MainActivity.class);

                                        startActivity(intent);
                                        finish();

                                    } else {
                                        showAlertDialog("Lỗi", "Không lấy được thông tin người dùng.");
                                    }
                                });

                            } else {
                                showAlertDialog("Lỗi", "Tài khoản hoặc mật khẩu không chính xác");
                            }
                        });
            }
        });



        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dangnhap.this, Dangky.class);
                startActivity(intent);
            }
        });
    }


    private void showAlertDialog(String title, String message) {
        showAlertDialog(title, message, null);
    }

    private void showAlertDialog(String title, String message, DialogInterface.OnClickListener positiveClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Dangnhap.this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", positiveClickListener)
                .setCancelable(false)
                .show();
    }
}
