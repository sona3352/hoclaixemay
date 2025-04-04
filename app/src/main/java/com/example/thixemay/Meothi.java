package com.example.thixemay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Meothi extends AppCompatActivity {
    RecyclerView rv4;
    ImageView iv3;
    TextView tieude, mota3;
    ArrayList<ClassLT> list1, list2;
    int selectedItem;
    AdapterLT2 adapterLT2;
    AdapterBienBao bienBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meothi);

        tieude = findViewById(R.id.tieude);
        iv3 = findViewById(R.id.iv3);
        mota3 = findViewById(R.id.mota3);
        rv4 = findViewById(R.id.rv4);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        selectedItem = intent.getIntExtra("selected_item", -1);
        int imageResId = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");
        String mota = intent.getStringExtra("mota");

        // Gán dữ liệu lên giao diện
        mota3.setText(mota);
        iv3.setImageResource(imageResId);
        tieude.setText(title);

        // Tạo danh sách mẹo
        list1 = new ArrayList<>();
        list1.add(new ClassLT(R.drawable.ava1, "Mẹo Nhớ Biển Báo",
                "Biển báo giao thông được chia thành 5 loại: Cấm, Nguy hiểm, Hiệu lệnh, Chỉ dẫn, Phụ. \n\n" +
                        "🚫 Biển cấm: Hình tròn, viền đỏ, nền trắng, có hình màu đen. Dùng để báo hiệu các hành vi bị cấm như cấm rẽ trái, cấm quay đầu, cấm xe máy.\n\n" +
                        "⚠️ Biển nguy hiểm: Hình tam giác, viền đỏ, nền vàng, có hình màu đen. Cảnh báo nguy hiểm phía trước để người lái xe giảm tốc độ, chú ý quan sát.\n\n" +
                        "🔵 Biển hiệu lệnh: Hình tròn, nền xanh, hình màu trắng. Chỉ thị bắt buộc như đi thẳng, quay đầu, đường dành cho xe đạp.\n\n" +
                        "🔷 Biển chỉ dẫn: Hình vuông hoặc chữ nhật, nền xanh, hình màu trắng. Cung cấp thông tin hữu ích như bãi đỗ xe, trạm xăng, đường cụt.\n\n" +
                        "📌 Biển phụ: Hình chữ nhật, nền trắng hoặc đen, giải thích thêm cho các biển chính như khoảng cách áp dụng lệnh cấm, thời gian cấm đỗ xe.\n\n" +
                        "📌 Mẹo nhớ nhanh:\n" +
                        "- TRÒN: Biển CẤM (viền đỏ) hoặc HIỆU LỆNH (nền xanh).\n" +
                        "- TAM GIÁC: Luôn là biển NGUY HIỂM.\n" +
                        "- CHỮ NHẬT/VUÔNG: Biển CHỈ DẪN (nền xanh) hoặc BIỂN PHỤ (nền trắng/đen).\n\n" +
                        "Hãy luyện tập quan sát biển báo trên đường để ghi nhớ nhanh hơn nhé! 🚗💨"
        ));


        list1.add(new ClassLT(R.drawable.ava1, "Mẹo Ghi Nhớ Luật",
                "📌 Một số nguyên tắc giúp nhớ luật dễ dàng hơn:\n\n" +
                        "✅ Thứ tự ưu tiên: Xe ưu tiên gồm Công an 🚔, Quân đội 🚛, Cứu thương 🚑, Cứu hỏa 🚒.\n\n" +
                        "✅ Khoảng cách an toàn: Nếu đề bài hỏi 'Tốc độ X km/h, khoảng cách an toàn là bao nhiêu?', hãy nhớ:\n" +
                        "- Dưới 60 km/h: Tối thiểu 5m.\n" +
                        "- Trên 60 km/h: Lấy tốc độ / 2 (VD: 80 km/h ⇒ 80/2 = 40m).\n\n" +
                        "✅ Làn đường: Nếu có biển báo, đi đúng làn. Nếu không có biển, luôn đi bên phải.\n\n" +
                        "📌 Mẹo nhớ nhanh:\n" +
                        "- Khi gặp đèn đỏ: Dừng lại đúng vạch, không lấn làn.\n" +
                        "- Khi rẽ phải: Quan sát kỹ, nhường đường cho người đi bộ.\n" +
                        "- Khi đi trong khu dân cư: Không bóp còi lớn, giảm tốc độ khi qua trường học.\n\n" +
                        "Ghi nhớ những nguyên tắc này giúp bạn tham gia giao thông an toàn hơn! 🚗🛣️"
        ));

        list1.add(new ClassLT(R.drawable.ava3, "Mẹo Thiệt Hại Tai Nạn",
                "🚑 Khi gặp câu hỏi về tai nạn giao thông, hãy ưu tiên các phương án liên quan đến:\n\n" +
                        "✔️ Gọi cấp cứu 115 hoặc cơ quan chức năng ngay lập tức.\n" +
                        "✔️ Đặt biển cảnh báo từ xa để tránh tai nạn tiếp theo.\n" +
                        "✔️ Sơ cứu nạn nhân đúng cách (cầm máu, đặt tư thế an toàn).\n\n" +
                        "⛔ Tránh các lựa chọn như di chuyển nạn nhân ngay lập tức trừ khi có nguy hiểm đe dọa trực tiếp.\n\n" +
                        "📌 Mẹo nhớ nhanh:\n" +
                        "- Bình tĩnh đánh giá tình huống trước khi hành động.\n" +
                        "- Không di chuyển nạn nhân có dấu hiệu chấn thương cột sống.\n" +
                        "- Luôn gọi cấp cứu trước khi thực hiện sơ cứu.\n\n" +
                        "Hãy nắm vững các bước sơ cứu cơ bản để cứu người đúng cách khi gặp tình huống khẩn cấp! 🚗⚠️"
        ));
        list1.add(new ClassLT(R.drawable.ava4, "Mẹo Chọn Đáp Án Đúng",
                "📝 Một số mẹo khi không chắc câu trả lời:\n\n" +
                        "✔️ Đáp án dài nhất thường là đáp án đúng.\n" +
                        "✔️ Câu có từ 'Không được', 'Chắc chắn', 'Luôn luôn' thường sai.\n" +
                        "✔️ Các con số: 5m, 25m, 40m, 80m thường xuất hiện ở câu hỏi khoảng cách.\n" +
                        "✔️ Luôn chọn phương án liên quan đến an toàn giao thông!\n\n" +
                        "📌 Mẹo nhớ nhanh:\n" +
                        "- Đọc kỹ đề, tìm từ khóa quan trọng.\n" +
                        "- Loại bỏ các đáp án vô lý trước.\n" +
                        "- Nếu có hai đáp án gần giống nhau, một trong hai thường đúng.\n\n" +
                        "Áp dụng các mẹo này sẽ giúp bạn tăng cơ hội chọn đáp án chính xác! ✅"
        ));

        list1.add(new ClassLT(R.drawable.ava1, "Mẹo Nhớ Hệ Thống Đèn",
                "💡 Gặp câu hỏi về đèn tín hiệu giao thông, hãy nhớ nguyên tắc:\n\n" +
                        "🚦 Đỏ = Dừng lại.\n" +
                        "🚦 Vàng = Giảm tốc (trừ khi đèn vàng nhấp nháy, thì được đi).\n" +
                        "🚦 Xanh = Đi tiếp nếu an toàn.\n\n" +
                        "📌 Nếu có đèn xanh nhưng cảnh sát ra hiệu dừng, phải dừng*!\n\n" +
                        "📌 Mẹo nhớ nhanh:\n" +
                        "- Luôn chú ý tín hiệu đèn và hiệu lệnh của cảnh sát giao thông.\n" +
                        "- Khi đèn chuyển vàng, nếu đã vào giao lộ, tiếp tục đi; nếu chưa vào, phải dừng.\n" +
                        "- Đèn xanh không có nghĩa là an toàn tuyệt đối, hãy quan sát kỹ trước khi đi.\n\n" +
                        "Nắm vững nguyên tắc này để lái xe an toàn và đúng luật! 🚗⚠️"
        ));

        adapterLT2 = new AdapterLT2(this, list1);
        rv4.setLayoutManager(new LinearLayoutManager(this));
        rv4.setAdapter(adapterLT2);

    }


}
