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
import com.example.thixemay.Cauhoi;
import com.example.thixemay.QuizViewModel;
import com.example.thixemay.R;

import java.util.ArrayList;
import java.util.List;

public class Diemliet extends Fragment {
    private QuizViewModel quizViewModel;
    private RadioGroup radioGroup1;
    private RadioButton btn1, btn2, btn3, btn4;
    private TextView cauhoi90,tvGiaithich;
    private List<Cauhoi> giaithich;
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diemliet, container, false);
        if (getArguments() != null) {
            position = getArguments().getInt("POSITION", 0);
        }

        radioGroup1 = view.findViewById(R.id.radioGroup1);
        cauhoi90 = view.findViewById(R.id.cauhoi90);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
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
        List<Cauhoi> questionList = new ArrayList<>();
        questionList.add(new Cauhoi(
                "",
                "Cuộc đua xe chỉ được thực hiện khi nào ?",
                "Diễn ra trên đường phố không có người qua lại.",
                "Được người dân ủng hộ.",
                "Được cơ quan có thẩm quyền cấp phép.",
                "",
                "C",
                "Hành vi đua xe chưa được cơ quan có thẩm quyền cấp phép là sai quy định của pháp luật."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma tuý có bị nghiêm cấm hay không ?",
                "Bị nghiêm cấm.",
                "Không bị nghiêm cấm.",
                "Không bị nghiêm cấm, nếu có chất ma tuý ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.",
                "",
                "A",
                "Ma túy là chất kích thích bị nghiêm cấm đối với người điều khiển phương tiện giao thông đường bộ."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào ?",
                "Chỉ bị nhắc nhở.",
                "Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                "Không bị xử lý hình sự.",
                "",
                "B",
                "Người điều khiển phương tiện giao thông đường bộ không được dùng rượu, bia khi lái xe."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Theo Luật phòng chống tác hại của rượu, bia, đối tượng nào dưới đây bị cấm sử dụng rượu bia khi tham gia giao thông ?",
                "Người điều khiển: Xe ô tô, xe mô tô, xe đạp, xe gắn máy",
                "Người ngồi phía sau người điều khiển xe cơ giới.",
                "Người đi bộ.",
                "Cả ý 1 và ý 2",
                "A",
                "Những người trực tiếp điều khiển ôtô, môtô, xe đạp và xe gắn máy bị cấm sử dụng rượu, bia."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không ?",
                "Bị nghiêm cấm tuỳ từng trường hợp.",
                "Không bị nghiêm cấm.",
                "Bị nghiêm cấm.",
                "",
                "C",
                "Nếu vi phạm những lỗi trên, người điều khiển phương tiện phải chịu trách nhiệm theo quy định của pháp luật."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không ?",
                "Được phép.",
                "Không được phép.",
                "Tùy từng trường hợp.",
                "",
                "B",
                "Hành vi quay đầu tại những nơi không được phép tăng nguy cơ xảy ra tai nạn giao thông."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không ?",
                "Được phép.",
                "Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình",
                "Tuỳ trường hợp.",
                "Không được phép.",
                "D",
                "Xe môtô hai bánh, ba bánh, xe gắn máy không được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác ở bất kỳ trường hợp nào."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép hay không ?",
                "Được phép.",
                "Tuỳ trường hợp.",
                "Không được phép.",
                "",
                "C",
                "Người điều khiển phương tiện vi phạm những hành vi trên có thể bị xử lý theo quy định của pháp luật."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào không được phép ?",
                "Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy.",
                "Buông một tay; sử dụng xe để chở người hoặc hàng hoá; để chân chạm xuống đất khi khởi hành",
                "Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.",
                "Chở người ngồi sau dưới 16 tuổi",
                "A",
                "Những hành vi trên không được phép thực hiện vì gây nguy hiểm cho người điều khiển phương tiện và những người xung quanh."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không ?",
                "Được mang, vác tuỳ trường hợp cụ thể.",
                "Không được mang, vác.",
                "Được mang, vác nhưng phải đảm bảo an toàn.",
                "",
                "B",
                "Mang, vác vật cồng kềnh khi ngồi trên xe môtô hai bánh, ba bánh, xe gắn máy tiềm ẩn nhiều nguy cơ xảy ra tai nạn giao thông."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương tiện khác không ?",
                "Được phép.",
                "Được bám trong trường hợp phương tiện của mình bị hỏng.",
                "Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng.",
                "Không được phép.",
                "C",
                "Hành vi bám, kéo hoặc đẩy các phương tiện khác khi ngồi trên xe môtô hai bánh, ba bánh, xe gắn máy là vi phạm pháp luật."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được sử dụng ô khi trời mưa hay không ?",
                "Được sử dụng.",
                "Chỉ người ngồi sau được sử dụng.",
                "Không được sử dụng.",
                "Được sử dụng nếu không có áo mưa.",
                "C",
                "Sử dụng ô (dù) khi ngồi trên xe môtô hai bánh, ba bánh, xe gắn máy dễ khiến phương tiện mất lái."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi đang lên dốc người ngồi trên xe mô tô có được kéo theo người đang điều khiển xe đạp hay không ?",
                "Chỉ được phép nếu cả hai đội mũ bảo hiểm.",
                "Không được phép.",
                "Chỉ được thực hiện trên đường thật vắng.",
                "Chỉ được phép khi người đi xe đạp đã quá mệt.",
                "B",
                "Nghiêm cấm xe môtô kéo theo người đang điều khiển xe đạp leo dốc."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi sử dụng xe mô tô để kéo, đẩy xe mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không ?",
                "Chỉ được kéo nếu đã nhìn thấy trạm xăng.",
                "Chỉ được thực hiện trên đường vắng phương tiện cùng tham gia giao thông.",
                "Không được phép.",
                "",
                "C",
                "Hành vi dùng xe môtô để kéo, đẩy xe môtô khác bị cấm."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi vận chuyển đồ vật cồng kềnh bằng xe mô tô, xe gắn máy khi tham gia giao thông có được phép hay không ?",
                "Không được vận chuyển.",
                "Chỉ được vận chuyển khi đã chằng buộc cẩn thận.",
                "Chỉ được vận chuyển vật cồng kềnh trên xe máy nếu khoảng cách về nhà ngắn hơn 2 km.",
                "",
                "A",
                "Quy định tại Việt Nam và nhiều quốc gia không cho phép vận chuyển đồ vật cồng kềnh bằng xe môtô, xe gắn máy."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người ngồi trên xe mô tô 2 bánh, xe gắn máy phải đội mũ bảo hiểm có cài quai đúng quy cách khi nào ?",
                "Khi tham gia giao thông đường bộ.",
                "Chỉ khi đi trên đường chuyên dùng; đường cao tốc.",
                "",
                "",
                "A",
                "Phạt tiền 200.000-300.000 đồng đối với người điều khiển, người ngồi trên xe không đội mũ bảo hiểm hoặc đội mũ bảo hiểm không cài quai đúng quy cách khi tham gia giao thông trên đường bộ."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển xe mô tô hai bánh, xe gắn máy có được đi xe dàn hàng ngang; đi xe vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính) hay không ?",
                "Được phép nhưng phải đảm bảo an toàn.",
                "Không được phép.",
                "Được phép tùy từng hoàn cảnh, điều kiện cụ thể.",
                "",
                "B",
                "Hành vi dùng điện thoại di động và các thiết bị âm thanh khi điều khiển xe môtô bị phạt từ 600.000 đồng đến 1 triệu đồng."
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe phải xử lý như thế nào khi quan sát phía trước thấy người đi bộ đang sang đường tại nơi có vạch đường dành cho người đi bộ để đảm bảo an toàn ?",
                "Giảm tốc độ, đi từ từ để vượt qua trước người đi bộ.",
                "Giảm tốc độ, có thể dừng lại nếu cần thiết trước vạch dừng xe để nhường đường cho người đi bộ qua đường.",
                "Tăng tốc độ để vượt qua trước người đi bộ.",
                "",
                "B",
                "Phải giảm tốc độ, phải dừng lại trước vạch dừng chờ người đi bộ đi qua rồi mới tiếp tục di chuyển"
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để đảm bảo an toàn ?",
                "Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                "Nhả hết tay ga, tắt động cơ, sử dụng phanh trước và phanh sau để giảm tốc độ",
                "Sử dụng phanh trước để giảm tốc độ kết hợp với tắt chìa khóa điện của xe.",
                "",
                "A",
                "Người lái xe phải giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ là đáp án phù hợp nhất"
                ,false
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi đang lái xe mô tô và ô tô, nếu có nhu cầu sử dụng điện thoại để nhắn tin hoặc gọi điện, người lái xe phải thực hiện như thế nào trong các tình huống nêu dưới đây ?",
                "Giảm tốc độ để đảm bảo an toàn với xe phía trước và sử dụng điện thoại để liên lạc.",
                "Giảm tốc độ để dừng xe ở nơi cho phép dừng xe sau đó sử dụng điện thoại để liên lạc.",
                "Tăng tốc độ để cách xa xe phía sau và sử dụng điện thoại để liên lạc.",
                "",
                "B",
                "Tuyệt đối không được sử dụng điện thoại khi điều khiển phương tiện tham gia giao thông đường bộ"
                ,false
        ));
        quizViewModel.addcauhoi("fragment2", questionList);
        giaithich = questionList;
        guidulieu2(position);
    }


    public void guidulieu2(int position) {
        if (giaithich != null && quizViewModel != null) {
            if (position >= 0 && position < giaithich.size()) {
                Cauhoi cauhientai1 = giaithich.get(position);
                String cauhoii = cauhientai1.getCauhoi();
                String cauaa = cauhientai1.getLuaChonA();
                String caubb = cauhientai1.getLuaChonB();
                String caucc = cauhientai1.getLuaChonC();
                String caudd = cauhientai1.getLuaChonD();
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

        Cauhoi cauHoiHienTai = giaithich.get(index);
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
