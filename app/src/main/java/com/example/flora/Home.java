package com.example.flora;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Home extends AppCompatActivity {

    RecyclerView recycler;
    FloraAdapter adapter;
    List<Flower> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        data = new ArrayList<>();
        int[] images = {R.drawable.flower1, R.drawable.flower2, R.drawable.flower3, R.drawable.flower4};
        Random rnd = new Random();
        for (int i = 0; i < images.length; i++) {
            int price = 50 + rnd.nextInt(300);
            data.add(new Flower("Flower " + (i + 1), price, images[i]));
        }

        adapter = new FloraAdapter(data, this);
        recycler.setAdapter(adapter);
    }
}
