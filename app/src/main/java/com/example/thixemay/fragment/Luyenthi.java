package com.example.thixemay.fragment;

import android.app.Activity;
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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.thixemay.Cauhoi;
import com.example.thixemay.QuizViewModel;
import com.example.thixemay.R;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Luyenthi extends Fragment {
    private QuizViewModel quizViewModel;
    private RadioGroup radioGroup1;
    private RadioButton btn1, btn2, btn3, btn4;
    private TextView cauhoi90;
    ImageView iv4;
    private List<Cauhoi> giaithich;

    private int position;
    private String dethi_key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_luyenthi, container, false);
        if (getArguments() != null) {
            position = getArguments().getInt("POSITION", 0);
            dethi_key = getArguments().getString("DETHI_KEY", "de1");
        }
        taocaugiaithichTuFirebase();

        radioGroup1 = view.findViewById(R.id.radioGroup1);
        cauhoi90 = view.findViewById(R.id.cauhoi90);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        iv4 = view.findViewById(R.id.iv4);
        quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup1.setOnCheckedChangeListener((group, checkedId) -> kiemtradapan(checkedId, position));
    }
    private void taocaugiaithichTuFirebase() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("dethi").child(dethi_key);;

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!quizViewModel.getQuestionsForFragment("fragment1").isEmpty()) {
                    handleLoadedQuestions(quizViewModel.getQuestionsForFragment("fragment1"));
                    return;
                }

                List<Cauhoi> questionList = new ArrayList<>();

                for (DataSnapshot cauSnapshot : snapshot.getChildren()) {
                    String hinhanhUrl = cauSnapshot.child("hinhanh").getValue(String.class);
                    String cauhoi = cauSnapshot.child("cauhoi").getValue(String.class);
                    String luachonA = cauSnapshot.child("luachonA").getValue(String.class);
                    String luachonB = cauSnapshot.child("luachonB").getValue(String.class);
                    String luachonC = cauSnapshot.child("luachonC").getValue(String.class);
                    String luachonD = cauSnapshot.child("luachonD").getValue(String.class);
                    String dapAnDung = cauSnapshot.child("dapAnDung").getValue(String.class);
                    boolean diemliet = cauSnapshot.child("diemliet").getValue(Boolean.class);
                    questionList.add(new Cauhoi(hinhanhUrl, cauhoi, luachonA, luachonB, luachonC, luachonD, dapAnDung,"",diemliet));
                }

                quizViewModel.addQuestionsForFragment("fragment1", questionList);
                handleLoadedQuestions(quizViewModel.getQuestionsForFragment("fragment1"));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Lỗi khi tải dữ liệu: " + error.getMessage());
            }
        });
    }


    private void handleLoadedQuestions(List<Cauhoi> questionList) {
        if (questionList != null && !questionList.isEmpty()) {
            giaithich = questionList;
            guidulieu(position);
        }
    }

    public void guidulieu(int position) {
        if (giaithich != null && quizViewModel != null) {
            if (position >= 0 && position < giaithich.size()) {
                Cauhoi cauhientai1 = giaithich.get(position);
                String cauhoii = cauhientai1.getCauhoi();
                String cauaa = cauhientai1.getLuaChonA();
                String caubb = cauhientai1.getLuaChonB();
                String caucc = cauhientai1.getLuaChonC();
                String caudd = cauhientai1.getLuaChonD();
                String hinhanh = cauhientai1.getHinhanh();


                if (hinhanh != null && !hinhanh.isEmpty()) {
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
                if (caucc != null && !caucc.isEmpty()) {
                    btn3.setText("C: " + caucc);
                    btn3.setVisibility(View.VISIBLE);
                } else {
                    btn3.setVisibility(View.GONE);
                }
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

        Cauhoi cauHoiHienTai = giaithich.get(index);
        String dapAnDung = cauHoiHienTai.getDapAnDung();
        String dapAnNguoiDung = "";

        // Xác định đáp án người dùng chọn
        if (checkedId == btn1.getId()) {
            dapAnNguoiDung = "A";
        } else if (checkedId == btn2.getId()) {
            dapAnNguoiDung = "B";
        } else if (checkedId == btn3.getId()) {
            dapAnNguoiDung = "C";
        } else if (checkedId == btn4.getId()) {
            dapAnNguoiDung = "D";
        }

        String dapAnTruoc = quizViewModel.getDapAnDaChon(index);

        if (dapAnTruoc != null && dapAnTruoc.equals(dapAnDung) && !dapAnNguoiDung.equals(dapAnDung)) {
            quizViewModel.decrementSocaudung();
        }

        if (!dapAnNguoiDung.equals("") && dapAnNguoiDung.equals(dapAnDung) && (dapAnTruoc == null || !dapAnTruoc.equals(dapAnDung))) {
            quizViewModel.incrementSocaudung();
        }
        if (cauHoiHienTai.isDiemliet() && !dapAnNguoiDung.equals(dapAnDung)) {
            quizViewModel.themCauDiemLietSai(cauHoiHienTai);
        }

        // Lưu đáp án đã chọn
        quizViewModel.setDapAnDaChon(index, dapAnNguoiDung);
    }

}
