package com.example.thixemay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Bienbao extends AppCompatActivity {
    RecyclerView rv6;

    TextView tieude;
    ArrayList<ClassLT> list1;
    int selectedItem;
    AdapterBienBao bienBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bienbao);

        tieude = findViewById(R.id.tieude);
        rv6 = findViewById(R.id.rv6);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        selectedItem = intent.getIntExtra("selected_item", -1);
        String title = intent.getStringExtra("title");
        tieude.setText(title);


        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 1);
        rv6.setLayoutManager(gridLayoutManager3);
        if (selectedItem == 0) {
            list1 = new ArrayList<>();
            list1.add(new ClassLT(R.drawable.aa1, "Biển số R.122 \"Dừng lại\"", "Để bảo các xe (cơ giới và thô sơ) dừng lại."
            ));
            list1.add(new ClassLT(R.drawable.aa2, "Biển số R.301a \"Hướng đi phải theo\"", "Khi đặt biển số R.301a ở trước nơi đường giao nhau thì hiệu lực tác dụng của biển là điều chỉnh việc đi vào khu vực nơi đường giao nhau ở phía trái. Nếu biển này đặt ở sau nơi đường giao nhau thì hiệu lực tác dụng của biển là điều chỉnh việc đi ra khỏi khu vực giao nhau. Trong trường hợp có biển này, người điều khiển phương tiện phải đi theo hướng chỉ dẫn trên biển."
            ));
            list1.add(new ClassLT(R.drawable.aa3, "Biển số R.301b \"Hướng đi phải theo\"", "Nhằm chỉ hướng cho phép xe đi ngang qua nơi đường giao nhau và ngăn chặn hướng đi ngược chiều trên đường phố với đường một chiều. Biển bắt buộc người tham gia giao thông chỉ được phép rẽ phải hoặc rẽ trái ở phạm vi nơi đường giao nhau trước mặt biển."
            ));
            list1.add(new ClassLT(R.drawable.aa4, "Biển số R.301c \"Hướng đi phải theo\"", "Nhằm chỉ hướng cho phép xe đi ngang qua nơi đường giao nhau và ngăn chặn hướng đi ngược chiều trên đường phố với đường một chiều. Biển bắt buộc người tham gia giao thông chỉ được phép rẽ phải hoặc rẽ trái ở phạm vi nơi đường giao nhau trước mặt biển."
            ));
            list1.add(new ClassLT(R.drawable.aa5, "Biển số R.301d \"Hướng đi phải theo\"", "Biển bắt buộc người tham gia giao thông chỉ được phép rẽ phải hoặc rẽ trái ở phạm vi nơi đường giao nhau dẫn sau mặt biển."
            ));
            list1.add(new ClassLT(R.drawable.aa6, "Biển số R.301e \"Hướng đi phải theo\"", "Biển bắt buộc người tham gia giao thông chỉ được phép rẽ phải hoặc rẽ trái ở phạm vi nơi đường giao nhau dẫn sau mặt biển."
            ));
            list1.add(new ClassLT(R.drawable.aa7, "Biển số R.301h \"Hướng đi phải theo\"", "Người tham gia giao thông chỉ được phép đi thẳng hay rẽ trái và được phép quay đầu xe để đi theo hướng ngược lại."
            ));
            list1.add(new ClassLT(R.drawable.aa8, "Biển số R.301i \"Hướng đi phải theo\"", "Nhằm ngăn ngừa chuyển động ngược chiều trên đường phố với đường một chiều. Biển bắt buộc người tham gia giao thông chỉ được phép rẽ trái, quay đầu hoặc rẽ phải ở phạm vi nơi đường giao nhau trước mặt biển."
            ));
            list1.add(new ClassLT(R.drawable.aa9, "Biển số R.302a \"Hướng phải đi vòng chướng ngại vật\"", "Để bảo các loại xe (cơ giới và thô sơ) hướng đi để qua một chướng ngại vật. Chỉ được vòng sang phải."
            ));
            list1.add(new ClassLT(R.drawable.aa10, "Biển số R.302c \"Hướng phải đi vòng chướng ngại vật\"", "Để bảo các loại xe (cơ giới và thô sơ) hướng đi để qua một chướng ngại vật. Phải vòng sang trái hoặc sang phải mà lựa chọn kiểu biển cho phù hợp."
            ));
            list1.add(new ClassLT(R.drawable.aa11, "Biển số R.303 \"Nơi giao nhau chạy theo vòng xuyến\"", "Để bảo cho các loại xe (thô sơ và cơ giới) phải chạy vòng theo đảo an toàn ở nơi đường giao nhau. Biển có hiệu lực bắt buộc các loại xe muốn chuyển hướng phải chạy theo đảo an toàn theo hướng mũi tên."
            ));
            list1.add(new ClassLT(R.drawable.aa2, "Biển số R.304 \"Đường dành cho xe thô sơ\"", "Để bảo đường dành cho xe thô sơ (kể cả xe của người tàn tật) và người đi bộ. Biển có hiệu lực bắt buộc các loại xe thô sơ (kể cả xe của người tàn tật) và người đi bộ phải đi trên đường dành riêng này để bảo đảm các xe cơ giới không gây gắt mái, các xe khác không được theo quy định đi vào đường đã đặt biển, trừ trường hợp đi cấp ngang mà những phải đảm bảo tuyệt đối an toàn cho xe thô sơ và người đi bộ."
            ));
            list1.add(new ClassLT(R.drawable.aa13, "Biển số R.305 \"Đường dành cho người đi bộ\"", "Để bảo đường dành cho người đi bộ. Biển có hiệu lực bắt buộc người đi bộ phải đi trên đường dành riêng này để đi. Các loại xe cơ giới và thô sơ (trừ xe đạp và xe lăn dành cho người tàn tật) sẽ không được ưu tiên theo quy định không được phép đi vào trên đường đã đặt biển, trừ trường hợp hợp lý cắt ngang mà những phải đảm bảo tuyệt đối an toàn cho người đi bộ."
            ));
            list1.add(new ClassLT(R.drawable.aa14, "Biển số R.306 \"Tốc độ tối thiểu cho phép\"", "Để bảo tốc độ tối thiểu cho phép các xe cơ giới chạy. Biển có hiệu lực bắt buộc các loại xe cơ giới vận hành với tốc độ không nhỏ hơn trị số ghi trên biển trong điều kiện giao thông thuận lợi và an toàn. Các loại xe không đi theo quy định này sẽ gây ảnh hưởng đến sản xuất dòng tốc độ cho các xe khác, gây cản trở việc điều khiển. Biển sẽ ghi trên biển khuyến khích các loại xe lưu thông trên đường và tổ chức giao thông, không được quy định trái trị số ghi trên biển an toàn."
            ));
            list1.add(new ClassLT(R.drawable.aa15, "Biển số R.307 \"Hết hạn chế tốc độ tối thiểu\"", "Biển có giá trị bảo cho người tham gia giao thông biết hiệu lực của biển số R.306 hết tác dụng. Kể từ biển này, các xe được phép chạy chậm hơn trị số ghi trên biển nhưng không được gây cản trở các xe khác."
            ));
            list1.add(new ClassLT(R.drawable.aa16, "Biển số R.308a \"Tuyến đường cầu vượt cắt qua\"", "Biểu thị phía trước có cầu vượt, xe có thể đi thẳng hoặc theo chỉ dẫn trên hình về để rẽ trái."
            ));
            list1.add(new ClassLT(R.drawable.aa17, "Biển số R.308b \"Tuyến đường cầu vượt cắt qua\"", "Biểu thị phía trước có cầu vượt, xe có thể đi thẳng hoặc theo chỉ dẫn trên hình về để rẽ phải."
            ));
        } else if (selectedItem == 1) {
            list1 = new ArrayList<>();
            list1.add(new ClassLT(R.drawable.bb1, "Biển số P.124a \"Cấm quay đầu xe\"", "Để bảo cấm các loại xe quay đầu (theo kiểu chữ U). Chiều mũi tên phù hợp với chiều cấm quay đầu xe. Biển số P.124a có hiệu lực cấm các loại xe (trừ xe được ưu tiên theo quy định). Biển không có giá trị cấm rẽ trái để sang hướng đường khác."
            ));
            list1.add(new ClassLT(R.drawable.bb2, "Biển số P.105 \"Cấm xe ô tô và xe máy\"", "Để đảm bảo cấm các loại xe cơ giới và xe máy đi qua."
            ));
            list1.add(new ClassLT(R.drawable.bb3, "Biển số P.101 \"Đường cấm\"", "Để bảo đảm đường cấm các loại phương tiện di lại cả hai hướng, trừ các xe được ưu tiên theo quy định."
            ));
            list1.add(new ClassLT(R.drawable.bb4, "Biển số P.102 \"Dấm đi ngược chiều\"", "Để đảm bảo cấm các loại xe (cơ sở và sơ đồ thô) đi vào chiều đặt biển, trừ các loại xe được ưu tiên theo quy định. Người được phép đi trên nhãn mác hoặc đoạn đường."));

            list1.add(new ClassLT(R.drawable.bb5, "Biển số P.103a \"Cấm xe ô tô\"", "Để đảm bảo đường cấm các loại xe cơ giới, kể cả xe máy 3 bánh có thùng đi qua, trừ xe máy 2 bánh, xe gắn máy và các xe được ưu tiên theo quy định."));
            list1.add(new ClassLT(R.drawable.bb6, "Biển số P.103b \"Cấm xe ô tô rẽ phải\"", "\"Cấm xe ô tô rẽ phải\". Biển này nhằm cấm tất cả các loại xe cơ giới, bao gồm xe máy 3 bánh có thùng, không được rẽ phải. Tuy nhiên, xe máy 2 bánh, xe gắn máy và các xe được ưu tiên theo quy định vẫn được phép rẽ."));

            list1.add(new ClassLT(R.drawable.bb7, "Biển số P.103c \"Cấm ô tô rẽ trái\"", "\"Cấm xe ô tô rẽ trái\". Biển này nhằm cấm tất cả các loại xe cơ giới, bao gồm xe máy 3 bánh có thùng, không được rẽ trái. Tuy nhiên, xe máy 2 bánh, xe gắn máy và các xe được ưu tiên theo quy định vẫn được phép rẽ."));

            list1.add(new ClassLT(R.drawable.bb8, "Biển số P.104 \"Cấm xe máy\"", "Biển này nhằm cấm tất cả các loại xe máy, trừ xe máy được ưu tiên theo quy định. Biển số P.104 \"Cấm xe máy\" phải được đặt đúng vị trí. Biển không có giá trị cấm đối với người đi xe máy."));

            list1.add(new ClassLT(R.drawable.bb9, "Biển số P.124b \"Cấm quay đầu xe\"", "Biển này nhằm cấm xe ô tô quay đầu (theo kiểu chữ U). Chiều mũi tên phải phù hợp với chiều cấm quay đầu xe. Biển số P.124b có hiệu lực cấm các loại xe máy 3 bánh (side car) quay đầu, trừ các xe được ưu tiên theo quy định. Biển không có giá trị cấm rẽ trái để sang hướng đường khác."));
            list1.add(new ClassLT(R.drawable.bb10, "Biển số P.106a \"Cấm xe ô tô tải\"", "Biển này nhằm cấm tất cả các loại xe ô tô tải, trừ những xe được ưu tiên theo quy định. Biển số P.106a \"Cấm xe ô tô tải\" phải được đặt đúng vị trí. Biển có hiệu lực cấm đối với cả máy kéo và các xe máy chuyên dùng đi vào đoạn đường đặt biển số P.106a."));

            list1.add(new ClassLT(R.drawable.bb11, "Biển số P.106b \"Cấm xe ô tô tải\"", "Biển này nhằm cấm tất cả các loại xe ô tô tải có khối lượng chuyên chở (theo Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường phương tiện giao thông cơ giới đường bộ) lớn hơn một giá trị nhất định, phải đặt biển số P.106b. Biển có hiệu lực cấm đối với xe tải có khối lượng chuyên chở xác định trong Giấy chứng nhận, cũng như các xe chuyên dùng đi vào đoạn đường đặt biển số P.106b."));

            list1.add(new ClassLT(R.drawable.bb12, "Biển số P.106c \"Cấm xe chở hàng nguy hiểm\"", "Biển này nhằm cấm tất cả các xe chở hàng nguy hiểm đi vào đoạn đường đó."));

            list1.add(new ClassLT(R.drawable.bb13, "Biển số P.107 \"Cấm xe ô tô khách và xe ô tô tải\"", "Biển này nhằm cấm các xe ô tô chở khách và các loại xe ô tô tải, kể cả các loại máy kéo và xe máy thi công chuyên dùng đi qua, trừ những xe được ưu tiên theo quy định."));
            list1.add(new ClassLT(R.drawable.bb14, "Biển số P.107a \"Cấm xe ô tô khách\"", "Biển này nhằm cấm các xe ô tô chở khách đi qua, trừ những xe được ưu tiên theo quy định. Biển này không cấm xe buýt"));

            list1.add(new ClassLT(R.drawable.bb15, "Biển số P.107b \"Cấm xe ô tô taxi\"", "Biển này nhằm cấm xe ô tô taxi di lại. Trong trường hợp cấm xe ô tô taxi theo giờ, cần đặt biển phụ ghi giờ cấm."));

            list1.add(new ClassLT(R.drawable.bb16, "Biển số P.108 \"Cấm xe kéo rơ-móc\"", "Biển này nhằm cấm các loại xe có giới kéo rơ-móc, bao gồm cả xe máy, máy kéo, và ô tô khách kéo theo rơ-móc di lại, trừ các xe ô tô miền rơ-móc và các xe được ưu tiên theo quy định."));
            list1.add(new ClassLT(R.drawable.bb17, "Biển số P.108a \"Cấm xe sơ-mi-rơ-móc\"", "Biển này nhằm cấm các loại xe sơ-mi-rơ-móc và các xe kéo rơ-móc, trừ những xe được ưu tiên theo quy định (bao gồm xe sơ-mi-rơ-móc hoặc xe kéo theo rơ-móc)."));

            list1.add(new ClassLT(R.drawable.bb18, "Biển số P.109 \"Cấm máy kéo\"", "Biển này nhằm cấm các loại máy kéo, bao gồm cả máy kéo bánh hơi và bánh xích đi qua."));
            ;
            list1.add(new ClassLT(R.drawable.bb19, "Biển số P.110a \"Cấm xe đạp\"", "Biển này nhằm cấm xe đạp đi qua. Biển không có giá trị cấm những người dắt xe đạp."));
            ;
            list1.add(new ClassLT(R.drawable.bb20, "Biển số P.110b \"Cấm xe đạp thồ\"", "Biển này nhằm cấm xe đạp thồ đi qua. Biển này không cấm người dắt loại xe này."));
            ;
            list1.add(new ClassLT(R.drawable.bb21, "Biển số P.127d \"Biển hết hạn chế tốc độ tối đa cho phép\"", "Biển này chỉ ra rằng đã hết đoạn đường hạn chế tốc độ tối đa cho phép."));
            ;
            list1.add(new ClassLT(R.drawable.bb22, "Biển số P.111a \"Cấm xe gắn máy\"", "Biển này nhằm cấm xe máy và xe gắn máy đi qua."));
            ;
            list1.add(new ClassLT(R.drawable.bb23, "Biển số P.111b \"Cấm xe ba bánh loại có động cơ\"", "Biển này nhằm cấm xe ba bánh loại có động cơ, như xe lam, xe xích lò máy, xe lôi máy, v.v."));
            ;
            list1.add(new ClassLT(R.drawable.bb24, "Biển số P.111d \"Cấm xe ba bánh loại không có động cơ\"", "Biển này nhằm cấm xe ba bánh loại không có động cơ, như xe xích lô, xe lôi đạp, v.v."));
            ;
            list1.add(new ClassLT(R.drawable.bb25, "Biển số P.112 \"Cấm người đi bộ\"", "Biển này nhằm cấm người đi bộ qua lại trên đoạn đường này."));
            ;
            list1.add(new ClassLT(R.drawable.bb26, "Biển số P.113 \"Cấm xe người kéo, đẩy\"", "Biển này nhằm cấm xe thồ, chuyển động do người kéo, đẩy đi qua. Biển không có giá trị cấm những xe nối cua trẻ em và phương tiện chuyển dùng để đi lại của những người tàn tật."));
            ;
            list1.add(new ClassLT(R.drawable.bb27, "Biển số P.114 \"Cấm xe sức vật kéo\"", "Biển này nhằm cấm xe sức vật vận tải hàng hóa hoặc hành khách dù kéo xe hay chở trên lưng đi qua."));
            ;
            list1.add(new ClassLT(R.drawable.bb28, "Biển số P.115 \"Hạn chế tải trọng toàn bộ xe\"", "Biển này nhằm cấm các loại xe (có giới vát thồ sơ) kể cả các xe được ưu tiên theo quy định, có tải trọng toàn bộ xe (tải trọng bản thân xe cộng với khối lượng chuyên chở) vượt quá trị số ghi trên biển đi qua."));
            ;
        } else if (selectedItem == 2) {
            list1 = new ArrayList<>();
            list1.add(new ClassLT(R.drawable.cc1, "Biển số I.401 \"Bắt đầu đường ưu tiên\"", "Biểu thị ưu tiên cho các phương tiện trên đường có đặt biển này được đi trước"));
            list1.add(new ClassLT(R.drawable.cc2, "Biển số I.402 \"Hết đoạn đường ưu tiên\"", "Biểu thị hết đoạn đường quy định là ưu tiên."));
            list1.add(new ClassLT(R.drawable.cc3, "Biển số I.405a \"Đường cục\"", "Chỉ lối rẽ vào đường cục."));
            list1.add(new ClassLT(R.drawable.cc4, "Biển số I.405b \"Đường cục\"", "Chỉ lối rẽ vào đường cục."));
            list1.add(new ClassLT(R.drawable.cc5, "Biển số I.405c \"Đường cục\"", "Chỉ dẫn phía trước là đường cục."));
            list1.add(new ClassLT(R.drawable.cc6, "Biển số I.406 \"Được ưu tiên qua đường hẹp\"", "Chỉ dẫn cho người tham gia giao thông có giới biết mình được quyền ưu tiên đi trước trên đoạn đường hẹp."));
            list1.add(new ClassLT(R.drawable.cc7, "Biển số I.407a \"Đường một chiều\"", "Chỉ dẫn những đoạn đường chạy một chiều."));
            list1.add(new ClassLT(R.drawable.cc8, "Biển số I.407b \"Đường một chiều\"", "Chỉ dẫn những đoạn đường chạy một chiều."));
            list1.add(new ClassLT(R.drawable.cc9, "Biển số I.407c \"Đường một chiều\"", "Chỉ dẫn những đoạn đường chạy một chiều."));
            list1.add(new ClassLT(R.drawable.cc10, "Biển số I.408 \"Nơi đỗ xe\"", "Chỉ dẫn những nơi được phép đỗ xe, những bãi đỗ xe, bến xe, v.v."));
            list1.add(new ClassLT(R.drawable.cc11, "Biển số I.408a \"Nơi đỗ xe một phần trên hè phố\"", "Chỉ dẫn những nơi được phép đỗ xe một phần trên hè phố rộng. Xe phải đỗ từ ½ thân xe trở lên trên hè phố."));
            list1.add(new ClassLT(R.drawable.cc12, "Biển số I.409 \"Chỗ quay xe\"", "Chỉ dẫn vị trí được phép quay đầu xe"));
            list1.add(new ClassLT(R.drawable.cc13, "Biển số I.410 \"Khu vực quay xe\"", "Chỉ dẫn khu vực được phép quay đầu xe."));
            list1.add(new ClassLT(R.drawable.cc14, "Biển số I.413a \"Đường phía trước có làn đường dành cho ô tô khách\"", "Chỉ dẫn cho người tham gia giao thông biết đường phía trước có làn đường dành riêng cho ô tô khách theo chiều ngược lại"));
            list1.add(new ClassLT(R.drawable.cc15, "Biển số I.413b \"Rẽ ra đường có làn đường dành cho ô tô khách\"", "Chỉ dẫn cho người tham gia giao thông biết ở nơi đường giao nhau rẽ phải là rẽ ra đường có làn đường dành riêng cho ô tô khách."));
            list1.add(new ClassLT(R.drawable.cc16, "Biển số I.413c \"Rẽ ra đường có làn đường dành cho ô tô khách\"", "Chỉ dẫn cho người tham gia giao thông biết ở nơi đường giao nhau rẽ trái là rẽ ra đường có làn đường dành riêng cho ô tô khách."));
            list1.add(new ClassLT(R.drawable.cc17, "Biển số I.414a \"Chỉ hướng đường\"", "Chỉ dẫn hướng đường đến các địa danh, khu dân cư."));
            list1.add(new ClassLT(R.drawable.cc18, "Biển số I.414b \"Chỉ hướng đường\"", "Chỉ dẫn hướng đường đến các địa danh, khu dân cư."));
            list1.add(new ClassLT(R.drawable.cc19, "Biển số I.414c \"Chỉ hướng đường\"", "Chỉ dẫn hướng đường đến các địa danh, khu dân cư."));
            list1.add(new ClassLT(R.drawable.cc20, "Biển số I.414d \"Chỉ hướng đường\"", "Chỉ dẫn hướng đường đến các địa danh, khu dân cư."));
            list1.add(new ClassLT(R.drawable.cc21, "Biển số I.415 \"Mũi tên chỉ hướng đi\"", "Chỉ hướng dẫn đi đến một địa điểm lân cận tiếp theo và cách làm khoảng cách (làm tròn đến km) đến nơi đó."));
            list1.add(new ClassLT(R.drawable.cc22, "Biển số I.416 \"Đường tránh\"", "Chỉ đường đi đường tránh, đường vòng trong trường hợp đường chính bị tắc hoặc cấm một số loại xe."));
            list1.add(new ClassLT(R.drawable.cc23, "Biển số I.416 \"Đường tránh\"", "Chỉ đường đi đường tránh, đường vòng trong trường hợp đường chính bị tắc hoặc cấm một số loại xe."));
        } else if (selectedItem == 3) {
            list1 = new ArrayList<>();
            list1.add(new ClassLT(R.drawable.dd1, "Biển số W.206 \"Giao nhau chạy theo vòng xuyên\"", "Báo trước nơi giao nhau có bố trí đảo an toàn giữa nút giao, các loại xe qua nút giao phải đi vòng xuyên quanh đảo an toàn theo chiều mũi tên."));
            list1.add(new ClassLT(R.drawable.dd2, "Biển số W.207a \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd3, "Biển số W.207b \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd4, "Biển số W.207c \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd5, "Biển số W.207d \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd6, "Biển số W.207e \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd7, "Biển số W.207f \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd8, "Biển số W.207g \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd9, "Biển số W.207h \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd10, "Biển số W.207i \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd11, "Biển số W.207k \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd12, "Biển số W.207l \"Giao nhau với đường không ưu tiên\"", "Đặt trên đường ưu tiên, để báo trước sắp đến nơi giao nhau với đường không ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd13, "Biển số W.208 \"Giao nhau với đường ưu tiên\"", "Đặt trên đường không ưu tiên, để báo trước sắp đến nơi giao nhau với đường ưu tiên."));
            list1.add(new ClassLT(R.drawable.dd14, "Biển số W.209 \"Giao nhau có tín hiệu đèn\"", "Báo trước nơi giao nhau có đèn tín hiệu điều khiển giao thông."));
            list1.add(new ClassLT(R.drawable.dd15, "Biển số W.210 \"Giao nhau với đường sắt rào chắn\"", "Báo trước nơi giao nhau với đường sắt có rào chắn."));
            list1.add(new ClassLT(R.drawable.dd16, "Biển số W.211a \"Giao nhau với đường sắt không có rào chắn\"", "Báo trước sắp đến chỗ giao nhau giữa đường bộ và đường sắt không có rào chắn, không có người điều khiển giao thông."));
            list1.add(new ClassLT(R.drawable.dd17, "Biển số W.211b \"Giao nhau với đường tàu điện\"", "Để chỉ nơi đường bộ giao nhau cùng mức với đường tàu điện."));
            list1.add(new ClassLT(R.drawable.dd18, "Biển số W.212 \"Cầu hẹp\"", "Báo trước sắp đến cầu hẹp là loại cầu có chiều rộng phần xe chạy nhỏ hơn hoặc bằng 4,50 m."));
            list1.add(new ClassLT(R.drawable.dd19, "Biển số W.213 \"Cầu tạm\"", "Báo trước sắp đến cầu tạm là loại cầu được làm để sử dụng tạm thời cho xe cộ qua lại."));
            list1.add(new ClassLT(R.drawable.dd20, "Biển số W.214 \"Cầu quay - cầu cất\"", "Báo phía trước gặp cầu quay, cầu cất là loại cầu trong từng thời gian có cắt giao thông đường bộ bằng cách quay hoặc nâng nhịp thông thuyền để cho tàu thuyền qua lại."));
            list1.add(new ClassLT(R.drawable.dd21, "Biển số W.215a \"Kè, vực sâu phía trước\"", "Báo trước sắp đến những vị trí có kè chắn vực sâu hoặc sông suối ở phía trước hoặc đi sát đường, cần đề phòng tình huống nguy hiểm rơi xuống vực sâu hoặc sông suối (thường có ở những chỗ ngọt nguy hiểm)."));
        } else if(selectedItem ==4)
        {
        list1 = new ArrayList<>();
        list1.add(new ClassLT(R.drawable.ee1, "Biển số S.501 \"Phạm vi tác dụng của biển\"", "Để thông báo phạm vi tác dụng của biển hiệu hoặc cảnh báo trên đường."));
        list1.add(new ClassLT(R.drawable.ee2, "Biển số S.502 \"Khoảng cách đến đối tượng báo hiệu\"", "Để thông báo khoảng cách thực tế tới biển báo hiệu hoặc đối tượng. Con số trên biển ghi theo đơn vị mét (m)."));
        list1.add(new ClassLT(R.drawable.ee3, "Biển số S.503a \"Hướng tác dụng của biển\"", "Để chỉ hướng tác dụng của biển."));
        list1.add(new ClassLT(R.drawable.ee4, "Biển số S.503b \"Hướng tác dụng của biển\"", "Để chỉ hướng tác dụng của biển (trái và phải)."));
        list1.add(new ClassLT(R.drawable.ee5, "Biển số S.503c \"Hướng tác dụng của biển\"", "Để chỉ hướng tác dụng của biển (trái và chiều sâu)."));
        list1.add(new ClassLT(R.drawable.ee6, "Biển số S.503d \"Hướng tác dụng của biển\"", "Để chỉ rõ biển có tác dụng là hướng song song với chiều đường."));
        list1.add(new ClassLT(R.drawable.ee7, "Biển số S.503e \"Hướng tác dụng của biển\"", "Để chỉ đồng thời hai hướng tác dụng (trước và sau) nơi đặt biển báo nhắc lại lệnh cấm dành cho xe."));
        list1.add(new ClassLT(R.drawable.ee8, "Biển số S.503f \"Hướng tác dụng của biển\"", "Để chỉ hướng tác dụng của biển là hướng song song với chiều đi."));
        list1.add(new ClassLT(R.drawable.ee9, "Biển số S.504 \"Làn đường\"", "Để chỉ làn đường chịu hiệu lực của biển báo hay tín hiệu."));
        list1.add(new ClassLT(R.drawable.ee10, "Biển số S.505a \"Loại xe\"", "Để chỉ loại xe chịu hiệu lực của biển báo cấm, biển hiệu lệnh hay biển chỉ dẫn."));
        list1.add(new ClassLT(R.drawable.ee11, "Biển số S.505b \"Loại xe hạn chế qua cầu\"", "Để chỉ các loại xe có tải trọng lớn hơn mức cho phép (bao gồm tải trọng bản thân xe và hàng hóa)."));
        list1.add(new ClassLT(R.drawable.ee12, "Biển số S.505c \"Tải trọng trục hạn chế qua cầu\"", "Để chỉ các loại xe có tải trọng trục lớn nhất cho phép tương ứng với từng loại xe."));
        list1.add(new ClassLT(R.drawable.ee13, "Biển số S.506a \"Hướng đường giao ưu tiên\"", "Để chỉ đường mà người tham gia giao thông phải nhường đường cho xe ưu tiên."));
        list1.add(new ClassLT(R.drawable.ee14, "Biển số S.506b \"Hướng đường ưu tiên\"", "Để chỉ đường ưu tiên mà người tham gia giao thông cần tuân thủ."));
        list1.add(new ClassLT(R.drawable.ee15, "Biển số S.507 \"Hướng rẽ\"", "Để báo trước cho người tham gia giao thông về hướng rẽ tiếp theo"));
        list1.add(new ClassLT(R.drawable.ee16, "Biển số S.508 \"Biểu thị thời gian\"", "Nhằm quy định phạm vi thời gian hiệu lực của các biển báo cấm, biển hiệu lệnh cho phù hợp yêu cầu."));
        list1.add(new ClassLT(R.drawable.ee17, "Biển số S.509 \"Biểu thị thời gian\"", "Nhằm quy định phạm vi thời gian hiệu lực của các biển báo cấm, biển hiệu lệnh cho phù hợp yêu cầu."));
        list1.add(new ClassLT(R.drawable.ee18, "Biển số S.509a \"Thuyết minh biển chỉnh\"", "Để bổ sung cho biển số W.239 \"Đường cấm các loại xe\" và điều chỉnh cao cho phương tiện đi vào."));
        list1.add(new ClassLT(R.drawable.ee19, "Biển số S.509b \"Thuyết minh biển chỉnh\"", "Để bổ sung cho biển số P.130 \"Cấm đỗ xe\", biển số P.131 (a, b, c) \"Cấm đậu\"."));
        list1.add(new ClassLT(R.drawable.ee20, "Biển số S.510 \"Chú ý đường tròn có băng tuyết\"", "Để cảnh báo đường tròn, có tuyết trong ngày trời có tuyết."));
        list1.add(new ClassLT(R.drawable.ee21, "Biển số S.H.3c \"Hướng tác dụng của biển\"", "Để chỉ hướng tác dụng của biển là hướng vuông góc với chiều đi. Trên cột tuyên đường đối ngoại và các tuyến đường có nhiều người đi lại."));
        list1.add(new ClassLT(R.drawable.ee22, "Biển số S.G.7 \"Chỉ dẫn tới địa điểm cắm trại\"", "Để chỉ dẫn tới địa điểm cắm trại."));
        list1.add(new ClassLT(R.drawable.ee23, "Biển số S.G.8 \"Chỉ dẫn tới nhà trọ\"", "Để chỉ dẫn tới nhà trọ."));
        }


        bienBao = new AdapterBienBao(this, list1);
        rv6.setLayoutManager(new LinearLayoutManager(this));
        rv6.setAdapter(bienBao);
    }


}
