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

public class Kythuat extends Fragment {
    private QuizViewModel quizViewModel;
    private RadioGroup radioGroup1;
    private RadioButton btn1, btn2, btn3, btn4;
    private TextView cauhoi90,tvGiaithich;
    private List<Cauhoi> giaithich;
    private int position;
    ImageView iv4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kythuat, container, false);
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
        List<Cauhoi> questionList = new ArrayList<>();
        questionList.add(new Cauhoi(
                "",
                "Để giảm tốc độ khi ô tô đi xuống đường dốc dài, người lái xe phải thực hiện các thao tác nào để đảm bảo an toàn?",
                "Nhả bàn đạp ga, đạp ly hợp (côn) hết hành trình, đạp mạnh phanh chân để giảm tốc độ.",
                "Về số thấp phù hợp, nhả bàn đạp ga, kết hợp đạp phanh chân với mức độ phù hợp để giảm tốc độ.",
                "Nhả bàn đạp ga, tăng lên số cao, đạp phanh chân với mức độ phù hợp để giảm tốc độ.",
                "",
                "B",
                "Để giảm tốc độ khi ô tô đi xuống đường dốc dài, cần về số thấp phù hợp, nhả bàn đạp ga và kết hợp đạp phanh chân với mức độ phù hợp để giảm tốc độ, đảm bảo an toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe giảm số, người lái xe cần phải chú ý những điểm gì để đảm bảo an toàn?",
                "Nhìn xuống buồng lái để biết chính xác vị trí các tay số, cần phải giảm thứ tự từ cao đến thấp, phối hợp các động tác phải nhịp nhàng, chính xác.",
                "Không được nhìn xuống buồng lái, cần phải giảm thứ tự từ cao đến thấp, phối hợp các động tác phải nhịp nhàng, chính xác, vù ga phải phù hợp với tốc độ.",
                "",
                "",
                "B",
                " Khi điều khiển xe giảm số, người lái xe không được nhìn xuống buồng lái để đảm bảo an toàn. Cần phải giảm thứ tự từ cao đến thấp, phối hợp các động tác nhịp nhàng và chính xác, vù ga phải phù hợp với tốc độ."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe tăng số, người lái xe cần chú ý những điểm gì để đảm bảo an toàn?",
                "Không được nhìn xuống buồng lái, cần phải tăng thứ tự từ thấp đến cao, phối hợp các động tác phải nhịp nhàng, chính xác.",
                "Nhìn xuống buồng lái để biết chính xác vị trí các tay số, cần phải tăng thứ tự từ thấp đến cao, phối hợp các động tác phải nhịp nhàng, vù ga phải phù hợp với tốc độ.",
                "",
                "",
                "A",
                "Khi điều khiển xe tăng số, người lái xe không được nhìn xuống buồng lái để đảm bảo an toàn. Cần phải tăng thứ tự từ thấp đến cao, phối hợp các động tác nhịp nhàng và chính xác."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe ô tô tự đổ, người lái xe cần chú ý những điểm gì để đảm bảo an toàn?",
                "Khi chạy trên đường xấu, nhiều ổ gà nên chạy chậm để thùng xe không bị lắc mạnh, không gây hiện tượng lệch 'ben'; khi chạy vào đường vòng, cần giảm tốc độ, không lấy lái gấp và không phanh gấp.",
                "Khi chạy trên đường quốc lộ, đường bằng phẳng không cần hạ hết thùng xe xuống.",
                "Khi đổ hàng phải chọn vị trí có nền đường cứng và phẳng, dừng hẳn xe, kéo chặt phanh tay; sau đó mới điều khiển cơ cấu nâng 'ben' để đổ hàng, đổ xong hàng mới hạ thùng xuống.",
                "Cả ý 1 và ý 3.",
                "D",
                "Khi điều khiển xe ô tô tự đổ, người lái xe cần chú ý khi chạy trên đường xấu, nhiều ổ gà nên chạy chậm để thùng xe không bị lắc mạnh và không gây hiện tượng lệch 'ben'. Khi chạy vào đường vòng, cần giảm tốc độ, không lấy lái gấp và không phanh gấp. Khi đổ hàng, phải chọn vị trí có nền đường cứng và phẳng, dừng hẳn xe, kéo chặt phanh tay, sau đó mới điều khiển cơ cấu nâng 'ben' để đổ hàng, đổ xong hàng mới hạ thùng xuống. Do đó, cả ý 1 và ý 3 đều đúng, trong khi ý 2 là sai vì khi đang chạy, phải hạ hết thùng xe xuống."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe qua đường sắt, người lái xe cần phải thực hiện các thao tác nào dưới đây để đảm bảo an toàn?",
                "Khi có chuông báo hoặc thanh chắn đã hạ xuống, người lái xe phải dừng xe tạm thời đúng khoảng cách an toàn, kéo phanh tay nếu đường dốc hoặc phải chờ lâu.",
                "Khi không có chuông báo hoặc thanh chắn không hạ xuống, người lái xe cần phải quan sát nếu thấy đủ điều kiện an toàn thì về số thấp, tăng ga nhẹ và không thay đổi số trong quá trình vượt qua đường sắt để tránh động cơ chết máy cho xe cho vượt qua.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Khi điều khiển xe qua đường sắt, nếu có chuông báo hoặc thanh chắn đã hạ xuống, người lái xe phải dừng xe tạm thời ở khoảng cách an toàn và kéo phanh tay nếu đường dốc hoặc phải chờ lâu. Nếu không có chuông báo hoặc thanh chắn không hạ xuống, người lái xe cần quan sát và nếu thấy đủ điều kiện an toàn thì về số thấp, tăng ga nhẹ và không thay đổi số trong quá trình vượt qua đường sắt để tránh động cơ chết máy."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe sử dụng hộp số cơ khí vượt qua rãnh lớn cắt ngang mặt đường, người lái xe cần thực hiện các thao tác nào để đảm bảo an toàn?",
                "Gài số một (1) và từ từ cho hai bánh xe trước xuống rãnh, tăng ga cho hai bánh xe trước vượt lên khỏi rãnh, tăng số, tăng tốc độ để bánh xe sau vượt qua rãnh.",
                "Tăng ga, tăng số để hai bánh xe trước và bánh xe sau vượt qua khỏi rãnh và chạy bình thường.",
                "Gài số một (1) và từ từ cho hai bánh xe trước xuống rãnh, tăng ga cho hai bánh xe trước vượt lên khỏi rãnh, tiếp tục để bánh xe sau từ từ xuống rãnh rồi tăng dần ga cho xe ô tô lên khỏi rãnh.",
                "",
                "C",
                "Khi điều khiển xe sử dụng hộp số cơ khí vượt qua rãnh lớn cắt ngang mặt đường, cần gài số một (1) và từ từ cho hai bánh xe trước xuống rãnh, tăng ga cho hai bánh xe trước vượt lên khỏi rãnh, tiếp tục để bánh xe sau từ từ xuống rãnh rồi tăng dần ga cho xe ô tô lên khỏi rãnh. Không tăng số cho đến khi xe đã vượt qua khỏi rãnh hoàn toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe ô tô rẽ trái ở chỗ đường giao nhau, người lái xe cần thực hiện các thao tác nào để đảm bảo an toàn?",
                "Cách chỗ rẽ một khoảng cách an toàn giảm tốc độ, có tín hiệu rẽ trái xin đổi làn đường; quan sát an toàn xung quanh đặc biệt là bên trái; đổi sang làn đường bên trái; cho xe chạy chậm tới phía trong của tâm đường giao nhau mới rẽ trái để điều khiển xe qua chỗ đường giao nhau.",
                "Cách chỗ rẽ một khoảng cách an toàn có tín hiệu rẽ trái, tăng tốc độ để xe nhanh chóng qua chỗ đường giao nhau; có tín hiệu xin đổi làn đường; quan sát an toàn xung quanh đặc biệt là bên trái; đổi làn đường sang phải để mở rộng vòng cua.",
                "",
                "",
                "A",
                "Khi điều khiển xe ô tô rẽ trái ở chỗ đường giao nhau, cần cách chỗ rẽ một khoảng cách an toàn, giảm tốc độ, có tín hiệu rẽ trái, xin đổi làn đường, quan sát an toàn xung quanh đặc biệt là bên trái, đổi sang làn đường bên trái, cho xe chạy chậm tới phía trong của tâm đường giao nhau mới rẽ trái để điều khiển xe qua chỗ đường giao nhau."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe ô tô rẽ phải ở chỗ đường giao nhau, người lái xe cần thực hiện các thao tác nào để đảm bảo an toàn?",
                "Có tín hiệu rẽ phải; quan sát an toàn phía sau; điều khiển xe sang làn đường bên trái; giảm tốc độ và quan sát an toàn phía bên phải để điều khiển xe qua chỗ đường giao nhau.",
                "Cách chỗ rẽ một khoảng cách an toàn có tín hiệu rẽ phải; quan sát an toàn phía sau; điều khiển xe bám sát vào phía phải đường; giảm tốc độ và quan sát an toàn phía bên phải để điều khiển xe qua chỗ đường giao nhau.",
                "Cách chỗ rẽ một khoảng cách an toàn có tín hiệu rẽ phải; quan sát an toàn phía sau; điều khiển xe bám sát vào phía phải đường; tăng tốc độ và quan sát an toàn phía bên trái để điều khiển xe qua chỗ đường giao nhau.",
                "",
                "B",
                "Khi điều khiển xe ô tô rẽ phải ở chỗ đường giao nhau, cần cách chỗ rẽ một khoảng cách an toàn, có tín hiệu rẽ phải, quan sát an toàn phía sau, điều khiển xe bám sát vào phía phải đường, giảm tốc độ và quan sát an toàn phía bên phải để điều khiển xe qua chỗ đường giao nhau."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe trên đường vòng người lái xe cần phải làm gì để đảm bảo an toàn?",
                "Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng coi, đèn; giảm tốc độ tới mức cần thiết, về số thấp và thực hiện quay vòng với tốc độ phù hợp với bán kính cong của đường vòng.",
                "Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng còi, đèn; tăng tốc để nhanh chóng qua đường vòng và giảm tốc độ sau khi qua đường vòng.",
                "",
                "",
                "A",
                "Khi điều khiển xe trên đường vòng, người lái xe cần quan sát cẩn thận các chướng ngại vật, báo hiệu bằng còi hoặc đèn, giảm tốc độ tới mức cần thiết, về số thấp và thực hiện quay vòng với tốc độ phù hợp với bán kính cong của đường vòng để đảm bảo an toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi xuống dốc, muốn dừng xe, người lái xe cần thực hiện các thao tác nào để đảm bảo an toàn?",
                "Có tín hiệu rẽ phải, điều khiển xe sát vào lề đường bên phải; đạp phanh sớm và mạnh hơn lúc dừng xe trên đường bằng để xe đi với tốc độ chậm đến mức dễ dàng dừng lại được; về số 1, đạp nửa ly hợp (côn) cho xe đến chỗ dừng; khi xe đã dừng, về số không (N), đạp phanh chân và kéo phanh tay.",
                "Có tín hiệu rẽ phải, điều khiển xe sát vào lề đường bên trái; đạp hết hành trình ly hợp (côn) và nhả bàn đạp ga để xe đi với tốc độ chậm đến mức dễ dàng dừng lại được tại chỗ dừng; khi xe đã dừng, đạp và giữ phanh chân.",
                "Có tín hiệu rẽ trái, điều khiển xe sát vào lề đường bên phải; đạp phanh sớm và mạnh hơn lúc dừng xe trên đường bằng để xe đi với tốc độ chậm đến mức dễ dàng dừng lại được; về số không (N) để xe đi đến chỗ dừng, khi xe đã dừng, kéo phanh tay.",
                "",
                "A",
                "Khi xuống dốc muốn dừng xe, cần có tín hiệu rẽ phải, điều khiển xe sát vào lề đường bên phải; đạp phanh sớm và mạnh hơn so với lúc dừng xe trên đường bằng để xe đi với tốc độ chậm đến mức dễ dàng dừng lại. Sau đó về số 1, đạp nửa ly hợp (côn) cho xe đến chỗ dừng; khi xe đã dừng, về số không (N), đạp phanh chân và kéo phanh tay."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển ô tô xuống dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để đảm bảo an toàn?",
                "Tăng lên số cao, nhả bàn đạp ga ở mức độ phù hợp, kết hợp với phanh chân để khống chế tốc độ.",
                "Về số thấp, nhả bàn đạp ga ở mức độ phù hợp, kết hợp với phanh chân để khống chế tốc độ.",
                "Về số không (0), nhả bàn đạp ga ở mức độ phù hợp, kết hợp với phanh chân để khống chế tốc độ.",
                "",
                "B",
                "Khi điều khiển ô tô xuống dốc cao, người lái xe cần về số thấp, nhả bàn đạp ga ở mức độ phù hợp và kết hợp với phanh chân để khống chế tốc độ, đảm bảo an toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển ô tô lên dốc cao, người lái xe cần thực hiện các thao tác nào?",
                "Tăng lên số cao từ chân dốc, điều chỉnh ga cho xe nhanh lên dốc; đến gần đỉnh dốc phải tăng ga để xe nhanh chóng qua dốc; về số thấp, đi sát về phía bên phải đường, có tín hiệu (còi, đèn) để báo cho người lái xe đi ngược chiều biết.",
                "Về số thấp từ chân dốc, điều chỉnh ga cho xe từ từ lên dốc; đến gần đỉnh dốc phải đi chậm, đi sát về phía bên phải đường, có tín hiệu (còi, đèn) để báo cho người lái xe đi ngược chiều biết.",
                "",
                "",
                "B",
                " Khi điều khiển ô tô lên dốc cao, người lái xe cần về số thấp từ chân dốc, điều chỉnh ga để xe từ từ lên dốc. Đến gần đỉnh dốc, cần đi chậm, đi sát về phía bên phải đường và sử dụng tín hiệu (còi, đèn) để báo cho người lái xe đi ngược chiều biết."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi tránh nhau trên đường hẹp, người lái xe cần phải chú ý những điểm nào để đảm bảo an toàn giao thông?",
                "Không nên đi cố vào đường hẹp; xe đi ở phía sườn núi nên dừng lại trước để nhường đường; khi dừng xe nhường đường phải đỗ ngay ngắn.",
                "Trong khi tránh nhau không nên đổi số; khi tránh nhau ban đêm, phải tắt đèn pha bật đèn cốt.",
                "Khi tránh nhau ban đêm, phải thường xuyên bật đèn pha tắt đèn cốt.",
                "Cả ý 1 và ý 2.",
                "D",
                "Khi tránh nhau trên đường hẹp, người lái xe cần chú ý không đi cố vào đường hẹp, xe đi ở phía sườn núi nên dừng lại trước để nhường đường và phải đỗ ngay ngắn khi dừng xe nhường đường. Trong khi tránh nhau, không nên đổi số và khi tránh nhau ban đêm, phải tắt đèn pha và bật đèn cốt. Cả ý 1 và ý 2 đều đúng, trong khi ý 3 là sai vì bật đèn pha khi tránh nhau ban đêm không đảm bảo an toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi quay đầu xe, người lái xe cần phải quan sát và thực hiện các thao tác nào để đảm bảo an toàn giao thông?",
                "Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe cho thích hợp; quay đầu xe với tốc độ thấp; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đầu xe về phía nguy hiểm đưa đuôi xe về phía an toàn.",
                "Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe; quay đầu xe với tốc độ tối đa; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đuôi xe về phía nguy hiểm và đầu xe về phía an toàn.",
                "",
                "",
                "A",
                "Khi quay đầu xe, người lái xe cần quan sát biển báo hiệu để biết nơi được phép quay đầu, quan sát kỹ địa hình nơi chọn để quay đầu, lựa chọn quỹ đạo quay đầu xe cho thích hợp, quay đầu xe với tốc độ thấp, và thường xuyên báo tín hiệu để người, các phương tiện xung quanh biết. Nếu quay đầu xe ở nơi nguy hiểm, cần đưa đầu xe về phía nguy hiểm và đuôi xe về phía an toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi khởi hành ô tô sử dụng hộp số cơ khí trên đường bằng, người lái xe cần thực hiện các thao tác nào theo trình tự dưới đây?",
                "Kiểm tra an toàn xung quanh xe ô tô; nhả từ từ đến 1/2 hành trình bàn đạp ly hợp (côn) và giữ trong khoảng 3 giây; vào số 1; nhả hết phanh tay, báo hiệu bằng còi, đèn trước khi xuất phát; tăng ga đủ để xuất phát, sau đó vừa tăng ga vừa nhả hết ly hợp để cho xe ô tô chuyển động.",
                "Kiểm tra an toàn xung quanh xe ô tô; đạp ly hợp (côn) hết hành trình; vào số 1; nhả hết phanh tay, báo hiệu bằng còi, đèn trước khi xuất phát; tăng ga đủ để xuất phát; nhả từ từ đến 1/2 hành trình bàn đạp ly hợp và giữ trong khoảng 3 giây, sau đó vừa tăng ga vừa nhả hết ly hợp (côn) để cho xe ô tô chuyển động.",
                "",
                "",
                "B",
                "Khi khởi hành ô tô sử dụng hộp số cơ khí trên đường bằng, cần kiểm tra an toàn xung quanh xe, đạp ly hợp (côn) hết hành trình, vào số 1, nhả hết phanh tay, báo hiệu bằng còi hoặc đèn trước khi xuất phát, tăng ga đủ để xuất phát, và nhả từ từ bàn đạp ly hợp đến 1/2 hành trình, giữ trong khoảng 3 giây, sau đó vừa tăng ga vừa nhả hết ly hợp để cho xe ô tô chuyển động."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi nhả hệ thống phanh dừng cơ khí điều khiển bằng tay (phanh tay), người lái xe cần phải thực hiện các thao tác nào?",
                "Dùng lực tay phải kéo cần phanh tay về phía sau hết hành trình; nếu khóa hãm bị kẹt cứng phải đẩy mạnh phanh tay về phía trước, sau đó bóp khóa hãm.",
                "Dùng lực tay phải bóp khóa hãm đẩy cần phanh tay về phía trước hết hành trình; nếu khóa hãm bị kẹt cứng phải kéo cần phanh tay về phía sau đồng thời bóp khóa hãm.",
                "Dùng lực tay phải đẩy cần phanh tay về phía trước hết hành trình; nếu khóa hãm bị kẹt cứng phải đẩy mạnh phanh tay về phía trước, sau đó bóp khóa hãm.",
                "",
                "B",
                "Khi nhả hệ thống phanh dừng cơ khí điều khiển bằng tay (phanh tay), cần dùng lực tay phải bóp khóa hãm và đẩy cần phanh tay về phía trước hết hành trình. Nếu khóa hãm bị kẹt cứng, phải kéo cần phanh tay về phía sau đồng thời bóp khóa hãm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi vào số để khởi hành xe ô tô có số tự động, người lái xe phải thực hiện các thao tác nào để đảm bảo an toàn?",
                "Đạp bàn đạp phanh chân hết hành trình, vào số và nhả phanh tay, kiểm tra lại xem có bị nhầm số không rồi mới cho xe lăn bánh.",
                "Đạp bàn đạp để tăng ga với mức độ phù hợp, vào số và kiểm tra lại xem có bị nhầm số không rồi mới cho xe lăn bánh.",
                "",
                "",
                "B",
                "Khi khởi hành xe ô tô số tự động, cần đạp bàn đạp phanh chân hết hành trình, vào số và nhả phanh tay, sau đó kiểm tra lại xem có bị nhầm số không trước khi cho xe lăn bánh để đảm bảo an toàn."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để đảm bảo an toàn?",
                "Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                "Nhả hết tay ga, tắt động cơ, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                "Sử dụng phanh trước để giảm tốc độ kết hợp với tắt chìa khóa điện của xe.",
                "",
                "A",
                "Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, cần giữ tay ga ở mức độ phù hợp và sử dụng cả phanh trước và phanh sau để giảm tốc độ, đảm bảo an toàn."
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
