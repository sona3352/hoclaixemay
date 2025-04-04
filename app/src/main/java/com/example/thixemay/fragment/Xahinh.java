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

public class Xahinh extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_xahinh, container, false);
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
                R.drawable.sahinh1,
                "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "Xe tải, xe khách, xe con, mô tô.",
                "Xe tải, mô tô, xe khách, xe con.",
                "Xe khách, xe tải, xe con, mô tô.",
                "Mô tô, xe khách, xe tải, xe con.",
                "D",
                "Thứ tự ưu tiên: Xe ưu tiên - Đường ưu tiên - Đường cùng cấp theo thứ tự bên phải trống - rẽ phải - đi thẳng - rẽ trái. 1. Xe tải: Đường ưu tiên và đi thẳng; 2. Mô tô: Đường ưu tiên và rẽ trái; 3. Xe khách: Đường không ưu tiên, đi thẳng; 4. Xe con: Đường không ưu tiên, rẽ trái."
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh2,
                "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "Xe công an, xe con, xe tải, xe khách.",
                "Xe công an, xe khách, xe con, xe tải.",
                "Xe công an, xe tải, xe khách, xe con.",
                "Xe con, xe công an, xe tải, xe khách.",
                "A",
                "Thứ tự ưu tiên: xe ưu tiên, đường ưu tiên, xe tải đi thẳng, xe khách rẽ trái"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh3,
                "Theo hướng mũi tên, thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "Xe tải, xe công an, xe khách, xe con.",
                "Xe công an, xe khách, xe con, xe tải.",
                "Xe công an, xe con, xe tải, xe khách.",
                "Xe công an, xe tải, xe khách, xe con.",
                "D",
                "Thứ tự ưu tiên: xe ưu tiên, đường ưu tiên, xe khách bên phải trống"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh4,
                "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "Xe tải, xe con, mô tô.",
                "Xe con, xe tải, mô tô.",
                "Mô tô, xe con, xe tải.",
                "Xe con, mô tô, xe tải.",
                "C",
                "Thứ tự ưu tiên: xe mô tô bên phải trống, xe con đi thẳng, xe tải rẽ trái"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh5,
                "Xe nào phải nhường đường trong trường hợp này?",
                "Xe con.",
                "Xe tải.",
                "",
                "",
                "A",
                "Xe con nhường vì xe tải từ bên trái đã nằm trong vòng xuyến"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh6,
                "Trường hợp này xe nào được quyền đi trước?",
                "Mô tô.",
                "Xe con.",
                "",
                "",
                "B",
                " Xe con được đi trước vì mô tô có biển STOP"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh7,
                "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "Xe con (A), xe cứu thương, xe con (B).",
                "Xe cứu thương, xe con (B), xe con (A).",
                "Xe con (B), xe con (A), xe cứu thương.",
                "",
                "A",
                "Xe con (A) vào ngã tư trước, xe cứu thương ưu tiên, xe con (B)"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh8,
                "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "Xe cứu thương, xe cứu hỏa, xe con.",
                "Xe cứu hỏa, xe cứu thương, xe con.",
                "Xe cứu thương, xe con, xe cứu hỏa.",
                "",
                "B",
                "Xe cứu hỏa ưu tiên, xe cứu thương, xe con"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh9,
                "Xe nào được quyền đi trước trong trường hợp này?",
                "Mô tô.",
                "Xe cứu thương",
                "",
                "",
                "B",
                "Xe ưu tiên đi trước"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh10,
                "Xe nào phải nhường đường đi cuối cùng qua nơi giao nhau này?",
                "Xe khách.",
                "Xe tải.",
                "Xe con.",
                "",
                "A",
                "Xe khách nhường vì đường không ưu tiên và rẽ trái"
        ));
        questionList.add(new Cauhoi2(
                R.drawable.sahinh11,
                "Xe nào phải nhường đường là đúng quy tắc giao thông?",
                "Xe con.",
                "Xe tải.",
                "",
                "",
                "A",
                "Xe con nhường vì bên phải có xe tải"
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
