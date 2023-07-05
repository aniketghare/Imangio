package com.example.imangio.DATA;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.imangio.FullActivity;
import com.example.imangio.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.viewHoldder> {
    Context context;
    List<String> listData;

    public MemeAdapter(Context context , List<String>  listData){
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public viewHoldder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutManager = LayoutInflater.from(context)
                .inflate(R.layout.memescard, parent, false);
        viewHoldder vh = new viewHoldder(layoutManager);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoldder holder, int position) {
        String url = listData.get(position).toString();
        Picasso.get().load(url).into(holder.imageView);

        holder.imageView.setOnClickListener(
                v -> {
                    Intent intent =new Intent(context , FullActivity.class);
                    intent.putExtra("url",url);
                    context.startActivity(intent);
                }
        );

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class viewHoldder extends ViewHolder {
        ImageView imageView;
        public viewHoldder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
