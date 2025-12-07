package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Edge-to-edge padding
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Button click listeners
        Button btnBuy = findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(v -> startActivity(new Intent(Home.this, CheckOut.class)));

        Button btnDetails = findViewById(R.id.btnDetails);
        btnDetails.setOnClickListener(v -> startActivity(new Intent(Home.this, Details.class)));
    }
}
