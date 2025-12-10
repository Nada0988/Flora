package com.example.flora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // تأكدي اسم ال-layout يطابق الملف (activity_check_out.xml)
        setContentView(R.layout.activity_check_out);

        // edge-to-edge padding guard (لو محتاجة) — لو مش محتاجة ممكن تشيلي
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // قراءة البيانات المرسلة من الـ Adapter
        String name = getIntent().getStringExtra("name");
        int price = getIntent().getIntExtra("price", -1);
        int imageRes = getIntent().getIntExtra("imageRes", -1);

        // ربط الفيوز
        ImageView img = findViewById(R.id.img_checkout);
        TextView tvName = findViewById(R.id.tv_checkout_name);
        TextView tvPrice = findViewById(R.id.tv_checkout_price);
        Button btnConfirm = findViewById(R.id.btn_confirm);

        // عرض البيانات (مع فحص القيم)
        if (name != null) tvName.setText(name);
        if (price != -1) tvPrice.setText("$" + price);
        if (imageRes != -1) img.setImageResource(imageRes);

        // مثال: عند الضغط Confirm يمكن ترسلي الطلب أو ترجعي
        btnConfirm.setOnClickListener(v -> {
            // هنا تضيفي منطق التأكيد (Toast، HTTP request، أو Finish)
            finish(); // كمثال نرجع للصفحة السابقة
        });
    }
}
