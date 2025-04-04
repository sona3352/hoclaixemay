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

public class Vanhoa extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_vanhoa, container, false);
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
                " Người hành nghề lái xe khi thực hiện tốt việc rèn luyện, nâng cao trách nhiệm, đạo đức nghề nghiệp sẽ thu được kết quả như thế nào dưới đây?",
                "Được khách hàng, xã hội tôn trọng; được đồng nghiệp quý mến, giúp đỡ; được doanh nghiệp tin dùng và đóng góp nhiều cho xã hội.",
                "Thu hút được khách hàng, góp phần quan trọng trong xây dựng thương hiệu, kinh doanh có hiệu quả cao.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Người hành nghề lái xe khi thực hiện tốt việc rèn luyện, nâng cao trách nhiệm và đạo đức nghề nghiệp sẽ được khách hàng, xã hội tôn trọng; được đồng nghiệp quý mến và giúp đỡ; được doanh nghiệp tin dùng và đóng góp nhiều cho xã hội. Đồng thời, điều này cũng thu hút khách hàng, góp phần quan trọng trong xây dựng thương hiệu và kinh doanh có hiệu quả cao."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe vận tải hàng hóa cần thực hiện những nhiệm vụ gì ghi ở dưới đây?",
                "Thực hiện nghiêm chỉnh những nội dung hợp đồng giữa chủ phương tiện với chủ hàng trong việc vận chuyển và bảo quản hàng hóa trong quá trình vận chuyển; không chở hàng cấm, không xếp hàng quá trọng tải của xe, quá trọng tải cho phép của cầu, đường; khi vận chuyển hàng hóa quá khổ, quá tải, hàng nguy hiểm, hàng siêu trường, siêu trọng phải có giấy phép.",
                "Thực hiện nghiêm chỉnh những nội dung hợp đồng giữa chủ hàng với khách hàng trong việc vận chuyển và bảo quản hàng hóa trong quá trình vận chuyển; trong trường hợp cần thiết có thể xếp hàng quá trọng tải của xe, quá trọng tải cho phép của cầu theo yêu cầu của chủ hàng; khi vận chuyển hàng hóa quá khổ, quá tải, hàng nguy hiểm, hàng siêu trường, siêu trọng phải được chủ hàng cho phép.",
                "",
                "",
                "A",
                "Người lái xe vận tải hàng hóa phải thực hiện nghiêm chỉnh các nội dung hợp đồng giữa chủ phương tiện với chủ hàng, không chở hàng cấm, không xếp hàng quá trọng tải của xe và quá trọng tải cho phép của cầu, đường. Khi vận chuyển hàng hóa quá khổ, quá tải, hàng nguy hiểm, hàng siêu trường, siêu trọng phải có giấy phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe kinh doanh vận tải cần thực hiện những công việc gì ghi ở dưới đây để thường xuyên rèn luyện nâng cao đạo đức nghề nghiệp?",
                "Phải yêu quý xe, quản lý và sử dụng xe tốt; bảo dưỡng xe đúng định kỳ; thực hành tiết kiệm vật tư, nhiên liệu; luôn tu dưỡng bản thân, có lối sống lành mạnh, tác phong làm việc công nghiệp.",
                "Cả ý 1 và ý 3.",
                "Nắm vững các quy định của pháp luật, tự giác chấp hành pháp luật, lái xe an toàn; coi hành khách như người thân, là đối tác tin cậy; có ý thức tổ chức kỷ luật và xây dựng doanh nghiệp vững mạnh; có tinh thần hợp tác, tương trợ, giúp đỡ đồng nghiệp.",
                "",
                "B",
                "Người lái xe kinh doanh vận tải cần thực hiện cả hai ý để nâng cao đạo đức nghề nghiệp. Họ cần yêu quý, quản lý và sử dụng xe tốt, bảo dưỡng xe đúng định kỳ, thực hành tiết kiệm vật tư và nhiên liệu. Đồng thời, họ phải nắm vững và chấp hành các quy định của pháp luật, lái xe an toàn, coi hành khách như người thân và là đối tác tin cậy, có ý thức tổ chức kỷ luật và tinh thần hợp tác, tương trợ đồng nghiệp."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe và nhân viên phục vụ trên ô tô vận tải hành khách phải có những trách nhiệm gì theo quy định dưới đây?",
                "Kiểm tra các điều kiện bảo đảm an toàn của xe sau khi khởi hành; có trách nhiệm lái xe thật nhanh khi chậm giờ của khách.",
                "Kiểm tra các điều kiện bảo đảm an toàn của xe trước khi khởi hành; có thái độ văn minh, lịch sự, hướng dẫn hành khách ngồi đúng nơi quy định; kiểm tra việc sắp xếp, chằng buộc hành lý, bảo đảm an toàn.",
                "Có biện pháp bảo vệ tính mạng, sức khỏe, tài sản của hành khách đi xe, giữ gìn trật tự; vệ sinh trong xe; đóng cửa lên xuống của xe trước và trong khi xe chạy.",
                "Cả ý 2 và ý 3.",
                "D",
                "Người lái xe và nhân viên phục vụ trên ô tô vận tải hành khách phải kiểm tra các điều kiện bảo đảm an toàn của xe trước khi khởi hành, có thái độ văn minh, lịch sự, hướng dẫn hành khách ngồi đúng nơi quy định và kiểm tra việc sắp xếp, chằng buộc hành lý để đảm bảo an toàn. Đồng thời, họ phải có biện pháp bảo vệ tính mạng, sức khỏe, tài sản của hành khách, giữ gìn trật tự và vệ sinh trong xe, và đảm bảo cửa lên xuống của xe được đóng trước và trong khi xe chạy."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khái niệm về văn hóa giao thông được hiểu như thế nào là đúng?",
                "Là sự hiểu biết và chấp hành nghiêm chỉnh pháp luật về giao thông; là ý thức trách nhiệm với cộng đồng khi tham gia giao thông.",
                "Là ứng xử có văn hóa, có tình yêu thương con người trong các tình huống không may xảy ra khi tham gia giao thông.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Khái niệm về văn hóa giao thông bao gồm cả sự hiểu biết và chấp hành nghiêm chỉnh pháp luật về giao thông, ý thức trách nhiệm với cộng đồng khi tham gia giao thông, và ứng xử có văn hóa, có tình yêu thương con người trong các tình huống không may xảy ra khi tham gia giao thông."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trên làn đường dành cho ô tô có vũng nước lớn, có nhiều người đi xe mô tô trên làn đường bên cạnh, người lái xe ô tô xử lý như thế nào là có văn hóa giao thông?",
                "Cho xe chạy thật nhanh qua vũng nước.",
                "Giảm tốc độ cho xe chạy chậm qua vũng nước.",
                "Giảm tốc độ cho xe chạy qua làn đường dành cho mô tô để tránh vũng nước.",
                "",
                "B",
                " Người lái xe ô tô cần giảm tốc độ và cho xe chạy chậm qua vũng nước để tránh làm bắn nước vào những người đi xe mô tô bên cạnh, thể hiện ý thức và văn hóa giao thông."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe cố tình không phân biệt làn đường, vạch phân làn, phóng nhanh, vượt ẩu, vượt đèn đỏ, đi vào đường cấm, đường một chiều được coi là hành vi nào trong các hành vi dưới đây?",
                "Là bình thường.",
                "Là thiếu văn hóa giao thông.",
                "Là có văn hóa giao thông.",
                "",
                "B",
                "Hành vi cố tình không phân biệt làn đường, vạch phân làn, phóng nhanh, vượt ẩu, vượt đèn đỏ, đi vào đường cấm, đường một chiều được coi là thiếu văn hóa giao thông, thể hiện sự thiếu tôn trọng luật lệ và an toàn giao thông."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi sơ cứu người bị tai nạn giao thông đường bộ, có vết thương chảy máu ngoài, màu đỏ tươi phun thành tia và phun mạnh khi mạch đập, bạn phải làm gì dưới đây?",
                "Thực hiện cầm máu trực tiếp.",
                "Thực hiện cầm máu không trực tiếp (chặn động mạch).",
                "",
                "",
                "B",
                " Khi sơ cứu người bị tai nạn giao thông với vết thương chảy máu ngoài, màu đỏ tươi phun thành tia và phun mạnh khi mạch đập, cần thực hiện cầm máu không trực tiếp (chặn động mạch) để ngăn chặn dòng máu lưu thông và giảm nguy cơ mất máu nghiêm trọng."
        ));
        questionList.add(new Cauhoi(
                "",
                "Người lái xe có văn hóa khi tham gia giao thông phải đáp ứng các điều kiện nào dưới đây?",
                "Có trách nhiệm với bản thân và với cộng đồng; tôn trọng, nhường nhịn người khác.",
                "Tận tình giúp đỡ người tham gia giao thông gặp hoạn nạn; giúp đỡ người khuyết tật, trẻ em và người cao tuổi.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Người lái xe có văn hóa khi tham gia giao thông phải có trách nhiệm với bản thân và cộng đồng, tôn trọng và nhường nhịn người khác. Họ cũng nên tận tình giúp đỡ người gặp hoạn nạn, cũng như hỗ trợ người khuyết tật, trẻ em và người cao tuổi."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông, chỉ đội mũ bảo hiểm ở nơi có biển báo bắt buộc đội mũ bảo hiểm.",
                "Chấp hành quy định về tốc độ, đèn tín hiệu, biển báo hiệu, vạch kẻ đường khi lái xe; chấp hành hiệu lệnh, chỉ dẫn của người điều khiển giao thông; nhường đường cho người đi bộ, người già, trẻ em và người khuyết tật.",
                "Cả ý 1 và ý 2.",
                "",
                "B",
                "Người lái xe mô tô có văn hóa giao thông phải chấp hành quy định về tốc độ, đèn tín hiệu, biển báo hiệu, và vạch kẻ đường. Họ cũng cần tuân thủ hiệu lệnh và chỉ dẫn của người điều khiển giao thông, cũng như nhường đường cho người đi bộ, người già, trẻ em và người khuyết tật."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; đội mũ bảo hiểm đạt chuẩn, cài quai đúng quy cách.",
                "Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông.",
                "Điều khiển xe và đội mũ bảo hiểm ở nơi có biển báo bắt buộc đội mũ bảo hiểm.",
                "",
                "A",
                "Người lái xe mô tô có văn hóa giao thông phải điều khiển xe đi bên phải theo chiều đi của mình, đi đúng phần đường, làn đường quy định. Họ cũng phải đội mũ bảo hiểm đạt chuẩn và cài quai đúng quy cách mọi lúc khi tham gia giao thông, không chỉ ở nơi có biển báo bắt buộc."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong các hành vi dưới đây, người lái xe ô tô, mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; dừng, đỗ xe đúng nơi quy định; đã uống rượu, bia thì không lái xe.",
                "Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông; dừng xe, đỗ xe ở nơi thuận tiện hoặc theo yêu cầu của hành khách, của người thân.",
                "Dừng và đỗ xe ở nơi thuận tiện cho việc chuyên chở hành khách và giao nhận hàng hóa; sử dụng rượu, bia thì có thể lái xe.",
                "",
                "A",
                "Người lái xe ô tô, mô tô có văn hóa giao thông phải đi bên phải theo chiều đi của mình, đi đúng phần đường, làn đường quy định, và dừng, đỗ xe đúng nơi quy định. Quan trọng nhất, nếu đã uống rượu, bia thì không được lái xe. "
        ));
        questionList.add(new Cauhoi(
                "",
                " Người có văn hóa giao thông khi điều khiển xe cơ giới tham gia giao thông đường bộ phải đảm bảo các điều kiện gì dưới đây?",
                "Có giấy phép lái xe phù hợp với loại xe được phép điều khiển; xe cơ giới đảm bảo các quy định về chất lượng, an toàn kỹ thuật và bảo vệ môi trường.",
                "Có giấy chứng nhận bảo hiểm trách nhiệm dân sự của chủ xe cơ giới còn hiệu lực; nộp phí sử dụng đường bộ theo quy định.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Người có văn hóa giao thông khi điều khiển xe cơ giới tham gia giao thông đường bộ phải có giấy phép lái xe phù hợp với loại xe được phép điều khiển, xe cơ giới phải đảm bảo các quy định về chất lượng, an toàn kỹ thuật và bảo vệ môi trường. Đồng thời, họ phải có giấy chứng nhận bảo hiểm trách nhiệm dân sự còn hiệu lực và nộp phí sử dụng đường bộ theo quy định."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi xảy ra tai nạn giao thông, người lái xe và người có mặt tại hiện trường vụ tai nạn phải thực hiện các công việc gì dưới đây?",
                "Đặt các biển cảnh báo hoặc vật báo hiệu ở phía trước và phía sau hiện trường xảy ra tai nạn để cảnh báo; kiểm tra khả năng xảy ra hỏa hoạn do nhiên liệu bị rò rỉ; bảo vệ hiện trường vụ tai nạn và cấp cứu người bị thương.",
                "Đặt các biển cảnh báo hoặc vật báo hiệu ở phía trên nóc xe xảy ra tai nạn để cảnh báo; kiểm tra khả năng xảy ra mất an toàn do nước làm mát bị rò rỉ.",
                "Cả ý 1 và ý 2.",
                "",
                "A",
                "Khi xảy ra tai nạn giao thông, người lái xe và người có mặt tại hiện trường phải đặt các biển cảnh báo hoặc vật báo hiệu ở phía trước và phía sau hiện trường để cảnh báo, kiểm tra khả năng xảy ra hỏa hoạn do nhiên liệu bị rò rỉ, bảo vệ hiện trường và cấp cứu người bị thương."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi xảy ra tai nạn giao thông, có người bị thương nghiêm trọng, người lái xe và người có mặt tại hiện trường vụ tai nạn phải thực hiện các công việc gì dưới đây?",
                "Thực hiện sơ cứu ban đầu trong trường hợp khẩn cấp; thông báo vụ tai nạn đến cơ quan thi hành pháp luật.",
                "Nhanh chóng lái xe gây tai nạn hoặc đi nhờ xe khác ra khỏi hiện trường vụ tai nạn.",
                "Cả ý 1 và ý 2.",
                "",
                "A",
                "Khi xảy ra tai nạn giao thông có người bị thương nghiêm trọng, người lái xe và người có mặt tại hiện trường phải thực hiện sơ cứu ban đầu trong trường hợp khẩn cấp và thông báo vụ tai nạn đến cơ quan thi hành pháp luật. Không nên rời khỏi hiện trường trừ khi để báo cáo hoặc tìm kiếm sự giúp đỡ."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi sơ cứu ban đầu cho người bị tai nạn giao thông đường bộ không còn hô hấp, người lái xe và người có mặt tại hiện trường vụ tai nạn phải thực hiện các công việc gì dưới đây?",
                "Đặt nạn nhân nằm ngửa, khai thông đường thở của nạn nhân.",
                "Thực hiện các biện pháp hô hấp nhân tạo.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Khi sơ cứu ban đầu cho người bị tai nạn giao thông không còn hô hấp, cần đặt nạn nhân nằm ngửa và khai thông đường thở, sau đó thực hiện các biện pháp hô hấp nhân tạo để giúp nạn nhân thở trở lại."
        ));
        questionList.add(new Cauhoi(
                "",
                " Hành vi bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm hoặc khi có điều kiện mà cố ý không cứu giúp người bị tai nạn giao thông có bị nghiêm cấm hay không?",
                "Không bị nghiêm cấm.",
                "Nghiêm cấm tùy từng trường hợp cụ thể.",
                "Bị nghiêm cấm.",
                "",
                "C",
                " Hành vi bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm hoặc khi có điều kiện mà cố ý không cứu giúp người bị tai nạn giao thông là bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi xảy ra tai nạn giao thông, những hành vi nào dưới đây bị nghiêm cấm?",
                "Xâm phạm tính mạng, sức khỏe, tài sản của người bị tai nạn và người gây tai nạn.",
                "Bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm.",
                "Cả ý 1 và ý 2.",
                "",
                "C",
                "Khi xCảy ra tai nạn giao thông, các hành vi xâm phạm tính mạng, sức khỏe, tài sản của người bị tai nạn và người gây tai nạn, cũng như hành vi bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm đều bị nghiêm cấm."
        ));
        questionList.add(new Cauhoi(
                "",
                "Khi xảy ra tai nạn giao thông, những hành vi nào dưới đây bị nghiêm cấm?",
                "Xâm phạm tính mạng, sức khỏe, tài sản của người bị nạn và người gây tai nạn.",
                "Sơ cứu người bị nạn khi cơ quan có thẩm quyền chưa cho phép.",
                "Sơ cứu người gây tai nạn khi cơ quan có thẩm quyền chưa cho phép.",
                "",
                "A",
                "Khi xảy ra tai nạn giao thông, hành vi xâm phạm tính mạng, sức khỏe, tài sản của người bị nạn và người gây tai nạn bị nghiêm cấm. Việc sơ cứu người bị nạn và người gây tai nạn là hành động cần thiết và không cần phải chờ cơ quan có thẩm quyền cho phép."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trong đoạn đường hai chiều tại khu đông dân cư đang ùn tắc, người điều khiển xe mô tô hai bánh có văn hóa giao thông sẽ lựa chọn xử lý tình huống nào dưới đây?",
                "Cho xe lấn sang làn ngược chiều để nhanh chóng thoát khỏi nơi ùn tắc.",
                "Điều khiển xe lên vỉa hè để nhanh chóng thoát khỏi nơi ùn tắc.",
                "Kiên nhẫn tuân thủ hướng dẫn của người điều khiển giao thông hoặc tín hiệu giao thông, di chuyển trên đúng phần đường bên phải theo chiều đi, nhường đường cho các phương tiện đi ngược chiều để nút tắc nhanh chóng được giải tỏa.",
                "",
                "C",
                "Người điều khiển xe mô tô hai bánh có văn hóa giao thông sẽ kiên nhẫn tuân thủ hướng dẫn của người điều khiển giao thông hoặc tín hiệu giao thông, di chuyển trên đúng phần đường bên phải theo chiều đi, và nhường đường cho các phương tiện đi ngược chiều để giúp nút tắc nhanh chóng được giải tỏa."
        ));
        questionList.add(new Cauhoi(
                "",
                "Trên đường đang xảy ra ùn tắc những hành vi nào sau đây là thiếu văn hóa khi tham gia giao thông?",
                "Bấm còi liên tục thúc giục các phương tiện phía trước nhường đường.",
                "Đi lên vỉa hè, tận dụng mọi khoảng trống để nhanh chóng thoát khỏi nơi ùn tắc.",
                "Lấn sang trái đường cố gắng vượt lên xe khác.",
                "Tất cả các ý nêu trên.",
                "D",
                " Những hành vi bấm còi liên tục, đi lên vỉa hè, tận dụng mọi khoảng trống để nhanh chóng thoát khỏi nơi ùn tắc, và lấn sang trái đường cố gắng vượt lên xe khác đều là những hành vi thiếu văn hóa khi tham gia giao thông."
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
