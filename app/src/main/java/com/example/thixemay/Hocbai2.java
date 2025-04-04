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
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.thixemay.fragment.Cautao;
import com.example.thixemay.fragment.Khainiem;
import com.example.thixemay.fragment.Kythuat;
import com.example.thixemay.fragment.Vanhoa;
import com.example.thixemay.fragment.Xahinh;
import com.example.thixemay.fragment.Bienbao;
import com.example.thixemay.slider.SliderAdapterBB;
import com.example.thixemay.slider.SliderAdapterCT;
import com.example.thixemay.slider.SliderAdapterKN;
import com.example.thixemay.slider.SliderAdapterKT;
import com.example.thixemay.slider.SliderAdapterSH;
import com.example.thixemay.slider.SliderAdapterVH;

public class Hocbai2 extends AppCompatActivity {
    private TextView cauhoiz;
    private ViewPager2 vv2;
    private int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hocbai2);

        cauhoiz = findViewById(R.id.cauhoiz);
        vv2 = findViewById(R.id.vv2);

        vitri = getIntent().getIntExtra("vitrinew", 0);
        setSliderAdapter(vitri);

        vv2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                cauhoiz.setText("Câu " + (position + 1));
                sendAnswersToFragment(position);
            }
        });
    }

    private void setSliderAdapter(int vitri) {
        switch (vitri) {
            case 0:
                vv2.setAdapter(new SliderAdapterKN(this)); // Khái niệm
                break;
            case 1:
                vv2.setAdapter(new SliderAdapterVH(this)); // Văn hóa
                break;
            case 2:
                vv2.setAdapter(new SliderAdapterKT(this)); // Kỹ thuật
                break;
            case 3:
                vv2.setAdapter(new SliderAdapterCT(this)); // Cấu tạo
                break;
            case 4:
                vv2.setAdapter(new SliderAdapterBB(this)); // Biển báo
                break;
            case 5:
                vv2.setAdapter(new SliderAdapterSH(this)); // Xa hình
                break;
            default:
                vv2.setAdapter(new SliderAdapterKN(this)); // Mặc định là Khái niệm
                break;
        }
    }

    private void sendAnswersToFragment(int position) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("f" + vv2.getCurrentItem());
        if (currentFragment instanceof Khainiem) {
            ((Khainiem) currentFragment).guidulieu2(position);
        } else if (currentFragment instanceof Vanhoa) {
            ((Vanhoa) currentFragment).guidulieu2(position);
        } else if (currentFragment instanceof Kythuat) {
            ((Kythuat) currentFragment).guidulieu2(position);
        } else if (currentFragment instanceof Cautao) {
            ((Cautao) currentFragment).guidulieu2(position);
        } else if (currentFragment instanceof Bienbao) {
            ((Bienbao) currentFragment).guidulieu2(position);
        } else if (currentFragment instanceof Xahinh) {
            ((Xahinh) currentFragment).guidulieu2(position);
        }
    }
}
