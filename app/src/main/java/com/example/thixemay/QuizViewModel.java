package com.example.thixemay;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizViewModel extends ViewModel {
    private int socaudung = 0;
    private int socauhoi = 0;
    private final Map<Integer, String> dapAnDaChon = new HashMap<>();
    private final Map<String, List<Cauhoi2>> questionsByFragment2 = new HashMap<>();

    // Lưu câu hỏi theo từng Fragment
    private final Map<String, List<Cauhoi>> questionsByFragment = new HashMap<>();

    public int getSocaudung() {
        return socaudung;
    }

    public void setSocaudung(int socaudung) {
        this.socaudung = socaudung;
    }

    public int getSocauhoi() {
        return socauhoi;
    }

    public void setSocauhoi(int socauhoi) {
        this.socauhoi = socauhoi;
    }

    public void incrementSocaudung() {
        socaudung++;
    }

    public void decrementSocaudung() {
        if (socaudung > 0) {
            socaudung--;
        }
    }

    public void incrementQuestionIndex() {
        socauhoi++;
    }

    public void setDapAnDaChon(int index, String dapAn) {
        dapAnDaChon.put(index, dapAn);
    }

    public String getDapAnDaChon(int index) {
        return dapAnDaChon.get(index);
    }

    public Map<Integer, String> getAllDapAnDaChon() {
        return new HashMap<>(dapAnDaChon);
    }

    // Thêm phương thức để lưu danh sách câu hỏi theo từng Fragment
    public void addQuestionsForFragment(String fragmentTag, List<Cauhoi> questions) {
        Collections.shuffle(questions);
        questionsByFragment.put(fragmentTag, new ArrayList<>(questions));
    }
    public void addcauhoi(String fragmentTag, List<Cauhoi> questions) {
        questionsByFragment.put(fragmentTag, new ArrayList<>(questions));
    }
    public List<Cauhoi> getQuestionsForFragment(String fragmentTag) {
        return questionsByFragment.getOrDefault(fragmentTag, new ArrayList<>());
    }

    public void addcauhoi2(String fragmentTag, List<Cauhoi2> questions) {
        questionsByFragment2.put(fragmentTag, new ArrayList<>(questions));
    }

    public List<Cauhoi2> getQuestionsForFragment2(String fragmentTag) {
        return questionsByFragment2.getOrDefault(fragmentTag, new ArrayList<>());
    }


}
