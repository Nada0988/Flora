package com.example.flora;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FloraAdapter extends RecyclerView.Adapter<FloraAdapter.Holder> {

    List<Flower> list;
    Context ctx;

    public FloraAdapter(List<Flower> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flora, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower f = list.get(position);

        holder.name.setText(f.name);
        holder.price.setText("$" + f.price);
        holder.image.setImageResource(f.imageRes);

        // فتح شاشة CheckOut عند الضغط على زر +
        holder.add.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, CheckOut.class);

            // إرسال بيانات العنصر للشاشة الجديدة
            intent.putExtra("name", f.name);
            intent.putExtra("price", f.price);
            intent.putExtra("imageRes", f.imageRes);

            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView price;
        ImageButton add;

        Holder(View v) {
            super(v);
            image = v.findViewById(R.id.img_flower);
            name = v.findViewById(R.id.tv_name);
            price = v.findViewById(R.id.tv_price);
            add = v.findViewById(R.id.btn_add);
        }
    }
}
