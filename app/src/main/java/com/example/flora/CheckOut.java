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
        setContentView(R.layout.activity_check_out);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("name");
        int price = getIntent().getIntExtra("price", -1);
        int imageRes = getIntent().getIntExtra("imageRes", -1);

        ImageView img = findViewById(R.id.img_checkout);
        TextView tvName = findViewById(R.id.tv_checkout_name);
        TextView tvPrice = findViewById(R.id.tv_checkout_price);
        Button btnConfirm = findViewById(R.id.btn_confirm);

        if (name != null) tvName.setText(name);
        if (price != -1) tvPrice.setText("$" + price);
        if (imageRes != -1) img.setImageResource(imageRes);

        btnConfirm.setOnClickListener(v -> {
            finish(); 
        });


    }
}
