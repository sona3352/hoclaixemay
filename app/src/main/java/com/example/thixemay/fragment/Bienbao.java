package com.example.thixemay.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.thixemay.Cauhoi;
import com.example.thixemay.Cauhoi2;
import com.example.thixemay.QuizViewModel;
import com.example.thixemay.R;

import java.util.ArrayList;
import java.util.List;

public class Bienbao extends Fragment {
    private QuizViewModel quizViewModel;
    private RadioGroup radioGroup1;
    private RadioButton btn1, btn2, btn3, btn4;
    private TextView cauhoi90,tvGiaithich;
    private List<Cauhoi2> giaithich;
    private int position;
    ImageView iv4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bienbao, container, false);
        if (getArguments() != null) {
            position = getArguments().getInt("POSITION", 0);
        }

        radioGroup1 = view.findViewById(R.id.radioGroup1);
        cauhoi90 = view.findViewById(R.id.cauhoi90);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        iv4 = view.findViewById(R.id.iv4);
        tvGiaithich = view.findViewById(R.id.tvGiaithich);
        quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);
        dscauhoi();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup1.setOnCheckedChangeListener((group, checkedId) -> kiemtradapan(checkedId, position));
    }
    private void dscauhoi() {
        List<Cauhoi2> questionList = new ArrayList<>();
        questionList.add(new Cauhoi2(
                R.drawable.bienbao1,
                "Biển nào cấm các loại xe cơ giới đi vào, trừ xe gắn máy, mô tô hai bánh và các loại xe ưu tiên theo luật định?",
                "Biển 1.",
                "Biển 2.",
                "Biển 1 và 3.",
                "Cả ba biển.",
                "A",
                "Biển 1 là biển báo cấm các phương tiện cơ giới (trừ xe mô tô hai bánh, xe gắn máy và xe ưu tiên theo luật định). " +
                        "Biển này có hình tròn, nền trắng, viền đỏ và biểu tượng màu đen. " +
                        "Các loại xe như ô tô, xe tải và xe khách không được phép đi vào khu vực có biển này."
        ));

        questionList.add(new Cauhoi2(
                R.drawable.bienbao2,
                "Biển nào cấm ô tô tải?",
                "Cả ba biển.",
                "Biển 2 và 3.",
                "Biển 1 và 3.",
                "Biển 1 và 2.",
                "D",
                "Biển cấm ô tô tải là biển 1 và 2."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao3,
                "Biển nào cấm máy kéo?",
                "Biển 1.",
                "Biển 2 và 3.",
                "Biển 1 và 3.",
                "Cả ba biển.",
                "B",
                "Biển cấm máy kéo là biển 2 và 3."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao4,
                "Biển nào báo hiệu cấm xe mô tô ba bánh đi vào?",
                "Biển 1 và 2.",
                "Biển 1 và 3.",
                "Biển 2 và 3.",
                "",
                "A",
                "Biển 1: P.104 “Cấm mô tô” thì cấm cả mô tô 3 bánh. Biển 2: P.103a “Cấm ô tô” cấm ô tô và và cả phương tiện 3 bánh đi vào."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao5,
                "Biển nào dưới đây xe gắn máy được phép đi vào?",
                "Biển 2.",
                "Biển 1.",
                "Cả hai biển.",
                "",
                "C",
                "Biển 104 “Cấm mô tô” và biển 103a “Cấm ô tô” không cấm xe gắn máy (không phải mô tô). Nên cả 2 biển đều cho phép xe gắn máy đi vào."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao6,
                "Biển nào báo hiệu cấm xe mô tô hai bánh đi vào?",
                "Biển 1.",
                "Biển 2.",
                "Biển 3.",
                "",
                "A",
                "Biển 1 báo hiệu cấm xe mô tô hai bánh đi vào."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao7,
                "Khi gặp biển nào thì xe mô tô hai bánh được đi vào?",
                "Biển 1 và 2.",
                "Không biển nào.",
                "Cả ba biển.",
                "Biển 2 và 3.",
                "D",
                "Biển 2 và 3 không cấm xe mô tô hai bánh, do đó xe mô tô hai bánh được phép đi vào khi gặp hai biển này."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao8,
                "Biển nào cho phép ô tô con được vượt?",
                "Biển 1 và 2.",
                "Biển 2.",
                "Biển 1 và 3.",
                "Biển 2 và 3.",
                "C",
                "Biển 1: DP.133 'Hết cấm vượt'; Biển 2: P.125 'Cấm vượt'; Biển 3: P.126 'Cấm ô tô tải vượt'. Chỉ có biển 2 cấm ô tô con vượt nên là đáp án đúng Biển 1 và biển 3."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao9,
                "Biển nào không cho phép ô tô con vượt?",
                "Biển 1.",
                "Biển 2.",
                "Biển 3.",
                "",
                "B",
                "Biển 1: DP.133 'Hết cấm vượt'; Biển 2: P.125 'Cấm vượt'; Biển 3: P.126 'Cấm ô tô tải vượt'. Biển 2 cấm ô tô con vượt nên là đáp án đúng."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao10,
                "Biển nào cấm ô tô tải vượt?",
                "Biển 1.",
                "Biển 1 và 2.",
                "Biển 1 và 3.",
                "Biển 2 và 3.",
                "D",
                "Biển 1: DP.133 'Hết cấm vượt'; Biển 2: P.125 'Cấm vượt'; Biển 3: P.126 'Cấm ô tô tải vượt'."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao11,
                "Biển nào cấm xe tải vượt?",
                "Biển 1.",
                "Biển 1.",
                "Cả hai biển.",
                "",
                "C",
                "Cả hai biển 1 và 2 đều cấm xe tải vượt."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao12,
                "Biển nào xe ô tô con được phép vượt?",
                "Biển 1.",
                "Biển 2.",
                "",
                "",
                "B",
                "Biển 2 cho phép xe ô tô con vượt."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao13,
                "Biển nào cấm quay đầu xe?",
                "Biển 1.",
                "Biển 2.",
                "Không biển nào.",
                "Cả hai biển.",
                "B",
                "Biển 1: P.123a 'Cấm rẽ trái' không cấm quay đầu xe; Biển 2: P.124a 'Cấm quay xe' không cấm rẽ trái. Nên Biển 2 là đáp án đúng."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao14,
                "Biển nào cấm xe rẽ trái?",
                "Biển 1.",
                "Biển 2.",
                "Cả hai biển.",
                "",
                "A",
                "Biển 1: P.123a 'Cấm rẽ trái' không cấm quay đầu xe; Biển 2: P.124a 'Cấm quay xe' không cấm rẽ trái. Nên Biển 1 là đáp án đúng."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.bienbao15,
                "Khi gặp biển nào xe được rẽ trái?",
                "Biển 1.",
                "Biển 2.",
                "Không biển nào.",
                "",
                "B",
                "Biển 1: P.123a 'Cấm rẽ trái' không cấm quay đầu xe; Biển 2: P.124a 'Cấm quay xe' không cấm rẽ trái. Nên Biển 2 là đáp án đúng."
        ));

        quizViewModel.addcauhoi2("fragment2", questionList);
        giaithich = questionList;
        guidulieu2(position);
    }
    public void guidulieu2(int position) {
        if (giaithich != null && quizViewModel != null) {
            if (position >= 0 && position < giaithich.size()) {
                Cauhoi2 cauhientai1 = giaithich.get(position);
                String cauhoii = cauhientai1.getCauhoi();
                String cauaa = cauhientai1.getLuaChonA();
                String caubb = cauhientai1.getLuaChonB();
                String caucc = cauhientai1.getLuaChonC();
                String caudd = cauhientai1.getLuaChonD();
                int hinhanh = cauhientai1.getHinhanh();


                if (hinhanh != 0) {
                    iv4.setVisibility(View.VISIBLE);
                    Glide.with(requireContext())
                            .load(hinhanh)
                            .placeholder(com.denzcoskun.imageslider.R.drawable.default_selected_dot)
                            .error(com.denzcoskun.imageslider.R.drawable.error)
                            .into(iv4);
                } else {
                    iv4.setVisibility(View.GONE);
                }
                Glide.with(requireContext())
                        .load(cauhientai1.getHinhanh())
                        .placeholder(com.denzcoskun.imageslider.R.drawable.default_selected_dot)
                        .error(com.denzcoskun.imageslider.R.drawable.error)
                        .into(iv4);
                cauhoi90.setText(cauhoii);
                btn1.setText("A: "+ cauaa);
                btn2.setText("B: "+ caubb);
                btn3.setText("C: "+ caucc);
                if (caudd != null && !caudd.isEmpty()) {
                    btn4.setText("D: " + caudd);
                    btn4.setVisibility(View.VISIBLE);
                } else {
                    btn4.setVisibility(View.GONE);
                }
            }
        }
    }
    private void kiemtradapan(int checkedId, int index) {
        if (giaithich == null || index < 0 || index >= giaithich.size()) {
            return; // Tránh crash nếu vuốt nhanh
        }

        Cauhoi2 cauHoiHienTai = giaithich.get(index);
        String dapAnDung = cauHoiHienTai.getDapAnDung();
        String giaithich = cauHoiHienTai.getGiaithich();
        String dapAnNguoiDung = "";

        // Xác định đáp án người dùng chọn
        RadioButton btnChon = null;
        if (checkedId == btn1.getId()) {
            dapAnNguoiDung = "A";
            btnChon = btn1;
        } else if (checkedId == btn2.getId()) {
            dapAnNguoiDung = "B";
            btnChon = btn2;
        } else if (checkedId == btn3.getId()) {
            dapAnNguoiDung = "C";
            btnChon = btn3;
        } else if (checkedId == btn4.getId()) {
            dapAnNguoiDung = "D";
            btnChon = btn4;
        }

        int defaultColor = ContextCompat.getColor(requireContext(), R.color.white);
        btn1.setBackgroundColor(defaultColor);
        btn2.setBackgroundColor(defaultColor);
        btn3.setBackgroundColor(defaultColor);
        btn4.setBackgroundColor(defaultColor);

        if (btnChon != null) {
            if (dapAnNguoiDung.equals(dapAnDung)) {
                int correctColor = ContextCompat.getColor(requireContext(), R.color.xanh_nhat);
                btnChon.setBackgroundColor(correctColor);
                tvGiaithich.setText(giaithich);
                tvGiaithich.setVisibility(View.VISIBLE);
            } else {
                int wrongColor = ContextCompat.getColor(requireContext(), R.color.do_nhat);
                btnChon.setBackgroundColor(wrongColor);
                tvGiaithich.setVisibility(View.GONE);
            }
        }
    }
}
