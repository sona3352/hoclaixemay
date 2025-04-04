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

public class Khainiem extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_khainiem, container, false);
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
                "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?",
                "Phần mặt đường và lề đường.",
                "Phần đường xe chạy.",
                "Phần đường xe cơ giới.",
                "",
                "B",
                "Tất nhiên là phần đường xe chạy rồi!."
        ));
        questionList.add(new Cauhoi(
                "",
                "Làn đường là gì?",
                "Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.",
                "Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",
                "Là đường cho xe ô tô chạy, dừng, đỗ an toàn.",
                "",
                "B",
                " Phải có chiều dọc và bề rộng nha mọi người "
        ));
        questionList.add(new Cauhoi(
                "",
                "Khái niệm Khổ giới hạn của đường bộ được hiểu như thế nào là đúng?",
                "Là khoảng trống có kích thước giới hạn về chiều cao, chiều rộng của đường, cầu, bến phà, hầm đường bộ để các xe kể cả hàng hóa xếp trên xe đi qua được an toàn.",
                "Là khoảng trống có kích thước giới hạn về chiều rộng của đường, cầu, bến phà, hầm trên đường bộ để các xe kể cả hàng hóa xếp trên xe đi qua được an toàn.",
                "Là khoảng trống có kích thước giới hạn về chiều cao của cầu, bến phà, hầm trên đường bộ để các xe đi qua được an toàn.",
                "",
                "A",
                "Khổ giới hạn đường sẽ có chiều cao, chiều rộng của đường nha "
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong các khái niệm dưới đây, dải phân cách được hiểu như thế nào là đúng?",
                "Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.",
                "Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.",
                "Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.",
                "",
                "C",
                " Dải phân cách nó nằm ở giữa đường đó, chia 2 chiều riêng biệt "
        ));
        questionList.add(new Cauhoi(
                "",
                "Dải phân cách trên đường bộ gồm những loại nào?",
                "Dải phân cách gồm loại cố định và loại di động.",
                "Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.",
                "Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.",
                "",
                "A",
                "Dải phân cách gồm cố định là mấy cái cột bê tông hoặc mấy thanh sắt ấy và di động là mấy cái như hộp nhựa đó"
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?",
                "Là người điều khiển xe cơ giới.",
                "Là người điều khiển xe thô sơ.",
                "Là người điều khiển xe có súc vật kéo.",
                "",
                "A",
                "Người lái xe là người điều khiển xe cơ giới.Câu này thì chắc không ai sai đâu"
        ));
        questionList.add(new Cauhoi(
                "",
                " Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?",
                "Đường không ưu tiên.",
                "Đường tỉnh lộ.",
                "Đường quốc lộ.",
                "Đường ưu tiên.",
                "D",
                "Đọc ở trên mà thấy chữ đường ưu tiên thì mình chọn đáp án đường ưu tiên luôn"
        ));
        questionList.add(new Cauhoi(
                "",
                "Khái niệm phương tiện giao thông cơ giới đường bộ được hiểu thế nào là đúng?",
                "Gồm xe ô tô; máy kéo; xe mô tô hai bánh; xe mô tô ba bánh; xe gắn máy; xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.",
                "Gồm xe ô tô; máy kéo; rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo; xe mô tô hai bánh; xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.",
                "",
                "",
                "B",
                " Phương tiện giao thông cơ giới không có xe máy chuyên dùng nha mấy ba"
        ));
        questionList.add(new Cauhoi(
                "",
                " Khái niệm phương tiện giao thông thô sơ đường bộ được hiểu thế nào là đúng?",
                "Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe xích lô, xe lăn dùng cho người khuyết tật, xe súc vật kéo và các loại xe tương tự.",
                "Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe gắn máy, xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.",
                "Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo.",
                "",
                "A",
                "Đáp án 2 và 3 có xe bằng động cơ mà, thô sơ gì không biết"
        ));
        questionList.add(new Cauhoi(
                "",
                "Phương tiện tham gia giao thông đường bộ gồm những loại nào?",
                "Phương tiện giao thông cơ giới đường bộ.",
                "Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Cả 2 luôn nha, đường bộ thì xe nào cũng chơi hết "
        ));
        questionList.add(new Cauhoi(
                "",
                "Người tham gia giao thông đường bộ gồm những đối tượng nào?",
                "Người điều khiển, người sử dụng phương tiện tham gia giao thông đường bộ.",
                "Người điều khiển, dẫn dắt súc vật; người đi bộ trên đường bộ.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Cả 2 luôn nha, đường bộ thì xe nào cũng chơi hết, dắt bò đi ăn cỏ còn được"
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển phương tiện tham gia giao thông đường bộ gồm những đối tượng nào dưới đây?",
                "Người điều khiển xe máy chuyên dùng tham gia giao thông đường bộ.",
                "Người điều khiển xe cơ giới, người điều khiển xe thô sơ.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Người điều khiển phương tiện bao gồm cả xe cơ giới và xe máy chuyên dùng nha! "
        ));
        questionList.add(new Cauhoi(
                "",
                "Khái niệm người điều khiển giao thông được hiểu như thế nào là đúng?",
                "Là người điều khiển phương tiện tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                "Là cảnh sát giao thông, người được giao nhiệm vụ hướng dẫn giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                "Là người tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                "",
                "B",
                "Người điều khiển giao thông là cảnh sát giao thông đó!"
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong các khái niệm dưới đây, khái niệm dừng xe được hiểu như thế nào là đúng?",
                "Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian để cho người lên, xuống phương tiện; xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                "Là trạng thái đứng yên tạm thời của phương tiện giao thông trong một khoảng thời gian cần thiết đủ để cho người lên, xuống phương tiện; xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                "Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian giữa 02 lần vận chuyển hàng hóa hoặc hành khách.",
                "",
                "B",
                "Dừng xe là đứng yên tạm thời nha!"
        ));
        questionList.add(new Cauhoi(
                "",
                "Khái niệm đỗ xe được hiểu như thế nào là đúng?",
                "Là trạng thái đứng yên của phương tiện giao thông có giới hạn trong một khoảng thời gian cần thiết đủ để cho người lên, xuống phương tiện đó; xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                "Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian.",
                "",
                "",
                "B",
                "Đỗ xe là đứng yên vô thời hạn, như nghỉ phép vậy!"
        ));
        questionList.add(new Cauhoi(
                "",
                "Khái niệm đường cao tốc được hiểu như thế nào là đúng?",
                "Đường dành riêng cho xe ô tô và một số loại xe chuyên dùng được phép đi vào theo quy định của Luật Giao thông đường bộ.",
                "Có dải phân cách phân chia đường cho xe chạy hai chiều riêng biệt mà dải phân cách này xe không được đi lên trên; không giao nhau cùng mức với một hoặc một số đường khác.",
                "Được bố trí đầy đủ trang thiết bị phục vụ, bảo đảm giao thông liên tục, an toàn, rút ngắn thời gian hành trình và chỉ cho xe ra, vào ở những điểm nhất định.",
                "Tất cả các ý trên.",
                "D",
                "Đường cao tốc bao gồm tất cả các ý trên nha!"
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi nào dưới đây bị nghiêm cấm?",
                "Đỗ xe trên đường phố.",
                "Sử dụng xe đạp đi trên các tuyến quốc lộ có tốc độ cao.",
                "Làm hỏng (cố ý) cọc tiêu, gương cầu, dải phân cách.",
                "Sử dụng còi và quay đầu xe trong khu dân cư.",
                "C",
                "Làm hỏng (cố ý) cọc tiêu, gương cầu, dải phân cách là không ổn đâu nha! "
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi đưa xe cơ giới, xe máy chuyên dùng không bảo đảm tiêu chuẩn an toàn kỹ thuật và bảo vệ môi trường vào tham gia giao thông đường bộ có bị nghiêm cấm hay không?",
                "Không nghiêm cấm.",
                "Bị nghiêm cấm.",
                "Bị nghiêm cấm tùy theo các tuyến đường.",
                "Bị nghiêm cấm tùy theo loại xe.",
                "B",
                "Hành vi đưa xe không đảm bảo an toàn kỹ thuật bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Cuộc đua xe chỉ được thực hiện khi nào?",
                "Diễn ra trên đường phố không có người qua lại.",
                "Được cơ quan có thẩm quyền cấp phép.",
                "Được người dân ủng hộ.",
                "",
                "C",
                "Cuộc đua xe cần cấp phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?",
                "Bị nghiêm cấm.",
                "Không bị nghiêm cấm.",
                "Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.",
                "",
                "A",
                "Có ma túy bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Việc lái xe mô tô, ô tô, máy kéo ngay sau khi uống rượu, bia có được phép hay không?",
                "Không được phép.",
                "Chỉ được lái ở tốc độ chậm và quãng đường ngắn.",
                "Chỉ được lái nếu trong cơ thể có nồng độ cồn thấp.",
                "",
                "A",
                "Uống rượu bia không được lái xe."
        ));
        questionList.add(new Cauhoi(
                "",
                " Người điều khiển xe mô tô, ô tô, máy kéo trên đường mà trong máu hoặc hơi thở có nồng độ cồn có bị nghiêm cấm không?",
                "Bị nghiêm cấm.",
                "Không bị nghiêm cấm.",
                "Không bị nghiêm cấm, nếu nồng độ cồn trong máu ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.",
                "",
                "A",
                "Trong máu hoặc hơi thở có nồng độ cồn bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Sử dụng rượu, bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào?",
                "Chỉ bị nhắc nhở.",
                "Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                "Không bị xử lý hình sự.",
                "",
                "B",
                "Sử dụng rượu, bia khi lái xe bị phạt hành chính hoặc xử lý hình sự."
        ));
        questionList.add(new Cauhoi(
                "",
                "Theo Luật phòng chống tác hại của rượu, bia đối tượng nào dưới đây bị cấm sử dụng rượu, bia khi tham gia giao thông?",
                "Người điều khiển: xe ô tô, xe mô tô, xe đạp, xe gắn máy.",
                "Người ngồi phía sau người điều khiển xe cơ giới.",
                "Người đi bộ.",
                "Cả ý 1 và ý 2.",
                "A",
                "Người điều khiển bị cấm sử dụng rượu, bia khi tham gia giao thông."
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi giao xe cơ giới, xe máy chuyên dùng cho người không đủ điều kiện để điều khiển xe tham gia giao thông có được phép hay không?",
                "Chỉ được thực hiện nếu đã hướng dẫn đầy đủ.",
                "Không được phép.",
                "Được phép tùy từng trường hợp.",
                "Chỉ được phép thực hiện với thành viên trong gia đình.",
                "B",
                "Không được phép giao xe cho người không đủ điều kiện tham gia giao thông."
        ));
        questionList.add(new Cauhoi(
                "",
                " Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?",
                "Bị nghiêm cấm tùy từng trường hợp.",
                "Không bị nghiêm cấm.",
                "Bị nghiêm cấm.",
                "",
                "C",
                "Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi lái xe trên đường, người lái xe cần quan sát và đảm bảo tốc độ phương tiện như thế nào?",
                "Chỉ lớn hơn tốc độ tối đa cho phép khi đường vắng.",
                "Chỉ lớn hơn tốc độ tối đa cho phép vào ban đêm.",
                "Không vượt quá tốc độ cho phép.",
                "",
                "C",
                "Không vượt quá tốc độ cho phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Phương tiện giao thông đường bộ di chuyển với tốc độ thấp hơn phải đi như thế nào?",
                "Đi về phía bên trái.",
                "Đi về phía bên phải.",
                "Đi ở giữa.",
                "",
                "B",
                "Di chuyển tốc độ thấp hơn đi về phía bên phải."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trên đường có nhiều làn đường, khi điều khiển phương tiện ở tốc độ chậm bạn phải đi ở làn đường nào?",
                "Đi ở làn bên phải trong cùng.",
                "Đi ở làn phía bên trái.",
                "Đi ở làn giữa.",
                "Đi ở bất cứ làn nào nhưng phải bấm đèn cảnh báo nguy hiểm để báo hiệu cho các phương tiện khác.",
                "A",
                "Tốc độ chậm đi ở làn bên phải trong cùng."
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi vượt xe tại các vị trí có tầm nhìn hạn chế, đường vòng, đầu dốc có bị nghiêm cấm hay không?",
                "Không bị nghiêm cấm.",
                "Không bị nghiêm cấm khi rất vội.",
                "Bị nghiêm cấm.",
                "Không bị nghiêm cấm khi khẩn cấp.",
                "C",
                "Hành vi vượt xe tại các vị trí có tầm nhìn hạn chế, đường vòng, đầu dốc bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi lái xe trong khu đô thị và đông dân cư trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi như thế nào trong các trường hợp dưới đây?",
                "Từ 22 giờ đêm đến 5 giờ sáng.",
                "Từ 5 giờ sáng đến 22 giờ tối.",
                "Từ 23 giờ đêm đến 5 giờ sáng hôm sau.",
                "",
                "A",
                "Chỉ sử dụng còi từ 5 giờ sáng đến 22 giờ tối."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm?",
                "Bất cứ đèn nào miễn là mắt nhìn rõ phía trước.",
                "Chỉ bật đèn chiếu xa (đèn pha) khi không nhìn rõ đường.",
                "Đèn chiếu xa (đèn pha) khi đường vắng, đèn pha chiếu gần (đèn cốt) khi có xe đi ngược chiều.",
                "Đèn chiếu gần (đèn cốt).",
                "D",
                "Trong đô thị sử dụng đèn chiếu gần."
        ));
        questionList.add(new Cauhoi(
                "",
                "Hành vi lắp đặt, sử dụng còi, đèn không đúng thiết kế của nhà sản xuất đối với từng loại xe cơ giới có được phép hay không?",
                "Được phép.",
                "Không được phép.",
                "Được phép tùy từng trường hợp.",
                "",
                "B",
                "Không được phép lắp đặt còi đèn không đúng thiết kế."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong trường hợp đặc biệt, để được lắp đặt, sử dụng còi, đèn không đúng với thiết kế của nhà sản xuất đối với từng loại xe cơ giới bạn phải đảm bảo yêu cầu nào dưới đây?",
                "Phải đảm bảo phụ tùng do đúng nhà sản xuất đó cung cấp.",
                "Phải được chấp thuận của cơ quan có thẩm quyền.",
                "Phải là xe đăng ký và hoạt động tại các khu vực có địa hình phức tạp.",
                "",
                "B",
                "Lắp đặt còi đèn không đúng thiết kế phải được chấp thuận của cơ quan có thẩm quyền."
        ));
        questionList.add(new Cauhoi(
                "",
                "Việc sản xuất, mua bán, sử dụng biển số xe cơ giới, xe máy chuyên dùng được quy định như thế nào trong Luật Giao thông đường bộ?",
                "Được phép sản xuất, sử dụng khi bị mất biển số.",
                "Được phép mua bán, sử dụng khi bị mất biển số.",
                "Nghiêm cấm sản xuất, mua bán, sử dụng trái phép.",
                "",
                "C",
                " Nghiêm cấm sản xuất, mua bán, sử dụng trái phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe không được vượt xe khác khi gặp trường hợp nào ghi ở dưới đây?",
                "Trên cầu hẹp có một làn xe. Nơi đường giao nhau, đường bộ giao nhau cùng mức với đường sắt; xe được quyền ưu tiên đang phát tín hiệu ưu tiên đi làm nhiệm vụ.",
                "Trên cầu có từ 02 làn xe trở lên; nơi đường bộ giao nhau không cùng mức với đường sắt; xe được quyền ưu tiên đang đi phía trước nhưng không phát tín hiệu ưu tiên.",
                "Trên đường có 2 làn đường được phân chia làn bằng vạch kẻ nét đứt.",
                "",
                "A",
                "Không được vượt trên cầu hẹp có một làn xe."
        ));
        questionList.add(new Cauhoi(
                "",
                "Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không?",
                "Được phép.",
                "Không được phép.",
                "Tùy từng trường hợp.",
                "",
                "B",
                "Không được phép quay đầu xe ở phần đường dành cho người đi bộ qua đường."
        ));
        questionList.add(new Cauhoi(
                "",
                "Bạn đang lái xe, phía trước có một xe cảnh sát giao thông không phát tín hiệu ưu tiên bạn có được phép vượt hay không?",
                "Không được vượt.",
                "Được vượt khi đang đi trên cầu.",
                "Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.",
                "Được vượt khi đảm bảo an toàn.",
                "D",
                "Được vượt khi xe không phát tín hiệu ưu tiên."
        ));
        questionList.add(new Cauhoi(
                "",
                "Bạn đang lái xe, phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?",
                "Không được vượt.",
                "Được vượt khi đang đi trên cầu.",
                "Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.",
                "Được vượt khi đảm bảo an toàn.",
                "A",
                "Không được vượt khi đang phát tín hiệu ưu tiên."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe không được quay đầu xe trong các trường hợp nào dưới đây?",
                "Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt.",
                "Ở phía trước hoặc phía sau của phần đường dành cho người đi bộ qua đường, trên đường quốc lộ, tại nơi đường bộ giao nhau không cùng mức với đường sắt.",
                "Cả ý 1 và ý 2.",
                "",
                "A",
                "Không được phép quay đầu xe ở phần đường dành cho người đi bộ qua đường."
        ));
        questionList.add(new Cauhoi(
                "",
                "Bạn đang lái xe trong khu dân cư, có đông xe qua lại, nếu muốn quay đầu bạn cần làm gì để tránh ùn tắc và đảm bảo an toàn giao thông?",
                "Đi tiếp đến điểm giao cắt gần nhất hoặc nơi có biển báo cho phép quay đầu xe.",
                "Bấm đèn khẩn cấp và quay đầu xe từ từ bảo đảm an toàn.",
                "Bấm còi liên tục khi quay đầu để cảnh báo các xe khác.",
                "Nhờ một người ra hiệu giao thông trên đường chậm lại trước khi quay đầu.",
                "A",
                "Chỉ quay đầu xe ở điểm giao cắt hoặc nơi có biển báo cho phép quay đầu."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe không được lùi xe ở những khu vực nào dưới đây?",
                "Ở khu vực cho phép đỗ xe.",
                "Ở khu vực cấm dừng và trên phần đường dành cho người đi bộ qua đường.",
                "Nơi đường bộ giao nhau, đường bộ giao nhau cùng mức với đường sắt, nơi tầm nhìn bị che khuất, trong hầm đường bộ, đường cao tốc.",
                "Cả ý 2 và ý 3.",
                "D",
                "Cấm lùi xe ở khu vực cấm dừng và nơi đường bộ giao nhau."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển phương tiện giao thông trên đường phố có được dừng xe, đỗ xe trên miệng cống thoát nước, miệng hầm của đường điện thoại, điện cao thế, chỗ dành riêng cho xe chữa cháy lấy nước hay không?",
                "Được dừng xe, đỗ xe trong trường hợp cần thiết.",
                "Không được dừng xe, đỗ xe.",
                "Được dừng xe, không được đỗ xe.",
                "",
                "B",
                " Không được dừng, đỗ xe trên miệng cống thoát nước."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi xe đã kéo 1 xe hoặc xe đã kéo 1 rơ moóc, bạn có được phép kéo thêm xe (kể cả xe thô sơ) hoặc rơ moóc thứ hai hay không?",
                "Chỉ được thực hiện trên đường quốc lộ có hai làn xe một chiều.",
                "Chỉ được thực hiện trên đường cao tốc.",
                "Không được thực hiện vào ban ngày.",
                "Không được phép.",
                "D",
                "Không được phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không?",
                "Được phép.",
                "Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình.",
                "Tùy trường hợp.",
                "Không được phép.",
                "D",
                "Xe mô tô không được kéo xe khác."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép hay không?",
                "Được phép.",
                "Tùy trường hợp.",
                "Không được phép.",
                "",
                "C",
                "Không được phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào không được phép?",
                "Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe để quệt xuống đường khi xe đang chạy.",
                "Buông một tay; sử dụng xe để chở người hoặc hàng hóa; để chân chạm xuống đất khi khởi hành.",
                "Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.",
                "Chở người ngồi sau dưới 16 tuổi.",
                "A",
                "Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe để quệt xuống đường khi xe đang chạy."
        ));
        questionList.add(new Cauhoi(
                "",
                " Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không?",
                "Được mang, vác tùy trường hợp cụ thể.",
                "Không được mang, vác.",
                "Được mang, vác nhưng phải đảm bảo an toàn.",
                "Được mang, vác tùy theo sức khoẻ của bản thân.",
                "B",
                "Xe mô tô không được mang vác vật cồng kềnh."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương tiện khác không?",
                "Được phép.",
                "Được bám trong trường hợp phương tiện của mình bị hỏng.",
                "Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng.",
                "Không được phép.",
                "D",
                "Xe mô tô không được kéo xe khác."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được sử dụng ô khi trời mưa hay không?",
                "Được sử dụng.",
                "Chỉ người ngồi sau được sử dụng.",
                "Không được sử dụng.",
                "Được sử dụng nếu không có áo mưa.",
                "C",
                " Khi tham gia giao thông, người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy không được sử dụng ô vì dễ gây mất cân bằng và nguy hiểm cho người điều khiển và các phương tiện khác."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi đang lên dốc người ngồi trên xe mô tô có được kéo theo người đang điều khiển xe đạp hay không?",
                "Chỉ được phép nếu cả hai đội mũ bảo hiểm.",
                "Không được phép.",
                "Chỉ được thực hiện trên đường thật vắng.",
                "Chỉ được phép khi người đi xe đạp đã quá mệt.",
                "B",
                "Xe mô tô không được kéo xe khác."
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
