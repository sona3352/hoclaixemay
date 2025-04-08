package com.example.thixemay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.thixemay.fragment.Luyenthi;
import com.example.thixemay.slider.SliderAdapter1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Thithu2 extends AppCompatActivity {
    private QuizViewModel quizViewModel;
    private TextView cauhoiz, thoigian;
    ViewPager2 viewPager2;
    SliderAdapter1 sliderPagerAdapter;
    Button hoanthanh;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thithu2);

        thoigian = findViewById(R.id.thoigian);
        cauhoiz = findViewById(R.id.cauhoiz);
        hoanthanh = findViewById(R.id.hoanthanh);
        viewPager2 = findViewById(R.id.ViewPaper2);
        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        batDauDemNguoc(1140000);
        viewPager2.setAdapter(sliderPagerAdapter);

        String dethiKey = getIntent().getStringExtra("dethi_key");

        // Khởi tạo SliderAdapter1 với dethi_key
        sliderPagerAdapter = new SliderAdapter1(this, dethiKey);
        viewPager2.setAdapter(sliderPagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                cauhoiz.setText("Câu " + (position + 1));
                sendAnswersToFragment(position);  // Gửi vị trí cho Fragment xử lý
            }
        });
        hoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ketThucLuyenThi();
            }
        });
    }
    private void ketThucLuyenThi() {
        // Kiểm tra số câu đúng
        int socaudung = quizViewModel.getSocaudung();
        int tongcauhoi = sliderPagerAdapter.getItemCount();
        float diemTren100 = (socaudung * 100f) / tongcauhoi;
        float tongdiem = (diemTren100 * 10) / 100f;
        tongdiem = Math.round(tongdiem * 100) / 100f;

        // Lấy user ID từ Firebase Authentication
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("nguoidung").child(userId).child("ketquathi");

            // Tạo HashMap chứa dữ liệu cần lưu
            Map<String, Object> ketQua = new HashMap<>();
            ketQua.put("tongcauhoi", tongcauhoi);
            ketQua.put("socaudung", socaudung);
            ketQua.put("tongdiem", tongdiem);

            // Lưu dữ liệu lên Firebase
            userRef.setValue(ketQua).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    List<Cauhoi> diemlietSai = quizViewModel.getDiemlietCauHoiSai();
                    Intent intent = new Intent(Thithu2.this, Ketthuc.class);
                    intent.putExtra("CAU_DUNG", socaudung);
                    intent.putExtra("TONG_CAU_HOI", tongcauhoi);
                    intent.putExtra("MO_TA", "Mô Tả Hình Ảnh");
                    intent.putExtra("DIEM_LIET_SAI", !diemlietSai.isEmpty());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Thithu2.this, "Lưu dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(Thithu2.this, "Người dùng chưa đăng nhập", Toast.LENGTH_SHORT).show();
        }
    }

        private void sendAnswersToFragment(int position) {
            // Tìm fragment hiện tại đang hiển thị trong ViewPager2
            Fragment
                    Fragment1 = getSupportFragmentManager().findFragmentByTag("f" + viewPager2.getCurrentItem());

            if (Fragment1 instanceof Luyenthi) {
                // Gọi phương thức sendAnswersToActivity từ Fragment
                ((Luyenthi) Fragment1).guidulieu(position);
            }
        }
    private void batDauDemNguoc(int thoiGianMillis) {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(thoiGianMillis, 1000) {
            public void onTick(long thoiGianConLai) {
                int phut = (int) (thoiGianConLai / 60000);
                int giay = (int) ((thoiGianConLai % 60000) / 1000);
                thoigian.setText(String.format("%02d:%02d", phut, giay));
            }

            public void onFinish() {
                ketThucLuyenThi();
            }
        };
        countDownTimer.start();
    }

}
