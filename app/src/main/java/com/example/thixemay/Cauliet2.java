package com.example.thixemay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.thixemay.fragment.Diemliet;
import com.example.thixemay.fragment.Khainiem;
import com.example.thixemay.slider.SliderAdapter2;



public class Cauliet2 extends AppCompatActivity {
    private TextView cauhoiz;
    ViewPager2 vv2;
    SliderAdapter2 sliderPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cauliet2);
        cauhoiz = findViewById(R.id.cauhoiz);
        vv2 = findViewById(R.id.vv2);
        sliderPagerAdapter = new SliderAdapter2(this);
        vv2.setAdapter(sliderPagerAdapter);

        vv2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                cauhoiz.setText("Câu " + (position + 1));
                sendAnswersToFragment(position);  // Gửi vị trí cho Fragment xử lý
            }
        });

    }
    private void sendAnswersToFragment(int position) {
        // Tìm fragment hiện tại đang hiển thị trong ViewPager2
        Fragment
                Fragment = getSupportFragmentManager().findFragmentByTag("f" + vv2.getCurrentItem());

        if (Fragment instanceof Diemliet) {
            // Gọi phương thức sendAnswersToActivity từ Fragment
            ((Diemliet) Fragment).guidulieu2(position);
        }
    }


}
