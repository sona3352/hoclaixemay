package com.example.thixemay;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chitietnguoidung extends AppCompatActivity {
    EditText edtEmail, edtHoten, edtRole, edtDiachi;
    Button btnSave,btnXoa;
    DatabaseReference databaseReference;
    String userId;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chitietnguoidung);


        edtEmail = findViewById(R.id.edtEmail);
        edtHoten = findViewById(R.id.edtHoten);
        edtRole = findViewById(R.id.edtRole);
        btnSave = findViewById(R.id.btnSave);
        edtDiachi = findViewById(R.id.edtDiachi);
        btnXoa = findViewById(R.id.btnXoa);

        userId = getIntent().getStringExtra("userId");
        String email = getIntent().getStringExtra("email");
        String hoten = getIntent().getStringExtra("hoten");
        String diachi = getIntent().getStringExtra("diachi");
        String role = getIntent().getStringExtra("role");

        edtEmail.setText(email);
        edtHoten.setText(hoten);
        edtDiachi.setText(diachi);
        edtRole.setText(role);

        databaseReference = FirebaseDatabase.getInstance().getReference("nguoidung");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Đang cập nhật...");

        btnSave.setOnClickListener(view -> updateUserData());
        btnXoa.setOnClickListener(view -> xoanguoidung());
    }
    private void xoanguoidung() {
        // Kiểm tra xem userId có hợp lệ hay không
        if (userId != null) {
            // Tạo hộp thoại xác nhận
            new AlertDialog.Builder(this)
                    .setTitle("Xóa người dùng")
                    .setMessage("Bạn có chắc chắn muốn xóa người dùng này?")
                    .setPositiveButton("OK", (dialog, which) -> {
                        // Hiển thị ProgressDialog khi bắt đầu xóa
                        progressDialog.setMessage("Đang xóa người dùng...");
                        progressDialog.show();

                        // Xóa người dùng khỏi Firebase Database theo userId
                        databaseReference.child(userId).removeValue()
                                .addOnSuccessListener(aVoid -> {
                                    progressDialog.dismiss();
                                    Toast.makeText(Chitietnguoidung.this, "Người dùng đã bị xóa!", Toast.LENGTH_SHORT).show();
                                    finish(); // Quay lại màn hình trước đó sau khi xóa thành công
                                })
                                .addOnFailureListener(e -> {
                                    progressDialog.dismiss();
                                    Toast.makeText(Chitietnguoidung.this, "Xóa người dùng thất bại!", Toast.LENGTH_SHORT).show();
                                });
                    })
                    .setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss())  // Nếu nhấn "Hủy", sẽ đóng hộp thoại mà không làm gì cả
                    .create()
                    .show();
        } else {
            Toast.makeText(this, "Lỗi: Không tìm thấy ID người dùng!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUserData() {
        String newEmail = edtEmail.getText().toString().trim();
        String newHoten = edtHoten.getText().toString().trim();
        String newDiachi = edtDiachi.getText().toString().trim();
        String newRole = edtRole.getText().toString().trim();

        if (newEmail.isEmpty() || newHoten.isEmpty() || newRole.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()) {
            Toast.makeText(this, "Email không hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userId != null) {
            progressDialog.show();

            databaseReference.child(userId).child("email").setValue(newEmail);
            databaseReference.child(userId).child("hoten").setValue(newHoten);
            databaseReference.child(userId).child("diachi").setValue(newDiachi);
            databaseReference.child(userId).child("role").setValue(newRole)
                    .addOnSuccessListener(aVoid -> {
                        progressDialog.dismiss();
                        Toast.makeText(Chitietnguoidung.this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        progressDialog.dismiss();
                        Toast.makeText(Chitietnguoidung.this, "Cập nhật thất bại!", Toast.LENGTH_SHORT).show();
                    });
        } else {
            Toast.makeText(this, "Lỗi: Không tìm thấy ID người dùng!", Toast.LENGTH_SHORT).show();
        }
    }
}