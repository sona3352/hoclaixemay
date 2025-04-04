package com.example.thixemay;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dangky extends AppCompatActivity {
    EditText taikhoan2, matkhau2,diachi, hoten, nhaplaimk;
    TextView textViewLogin;
    Button btndangky2;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangky);
        textViewLogin = findViewById(R.id.textViewLogin);
        hoten = findViewById(R.id.hoten);
        taikhoan2 = findViewById(R.id.taikhoan2);
        matkhau2 = findViewById(R.id.matkhau2);
        btndangky2 = findViewById(R.id.dangky2);
        nhaplaimk = findViewById(R.id.nhaplaimk);
        diachi = findViewById(R.id.diachi);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("nguoidung");


        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dangky.this, Dangnhap.class);
                startActivity(intent);
            }
        });

        btndangky2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String layhoten = hoten.getText().toString();
                String taikhoan = taikhoan2.getText().toString();
                String laydiachi = diachi.getText().toString();
                String matkhau = matkhau2.getText().toString();
                String laylaimk = nhaplaimk.getText().toString();
                String avatarMacdinh = "https://cdn.kona-blue.com/upload/kona-blue_com/post/images/2024/09/21/476/avatar-shin-cute-1.jpg";
                if (taikhoan.isEmpty() || matkhau.isEmpty() || layhoten.isEmpty() || laydiachi.isEmpty() || laylaimk.isEmpty()) {
                    showAlertDialog("Thông báo", "Vui lòng nhập đủ thông tin");
                } else if (!matkhau.equals(laylaimk)) {
                    showAlertDialog("Lỗi", "Mật khẩu nhập lại không khớp");
                } else {
                    auth.createUserWithEmailAndPassword(taikhoan, matkhau)
                            .addOnCompleteListener(Dangky.this, task -> {
                                if (task.isSuccessful()) {
                                    String userId = auth.getCurrentUser().getUid();
                                    ClassND userData = new ClassND(
                                            avatarMacdinh,
                                            taikhoan,
                                            layhoten,
                                            laydiachi,
                                            "user"
                                    );

                                    myRef.child(userId).setValue(userData)
                                            .addOnCompleteListener(dbTask -> {
                                                if (dbTask.isSuccessful()) {
                                                    showAlertDialog("Thông báo", "Đăng ký thành công", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Intent intent = new Intent(Dangky.this, Dangnhap.class);
                                                            startActivity(intent);
                                                            finish();
                                                        }
                                                    });
                                                } else {
                                                    showAlertDialog("Lỗi", "Lỗi lưu thông tin người dùng");
                                                }
                                            });
                                } else {
                                    showAlertDialog("Lỗi", "Đăng ký thất bại: " + task.getException().getMessage());
                                }
                            });
                }
            }
        });

    }

    private void showAlertDialog(String title, String message) {
        showAlertDialog(title, message, null);
    }

    private void showAlertDialog(String title, String message, DialogInterface.OnClickListener positiveClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Dangky.this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", positiveClickListener)
                .setCancelable(false)
                .show();
    }
}
