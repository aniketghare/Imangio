package com.example.imangio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.imangio.databinding.ActivityFullBinding;
import com.squareup.picasso.Picasso;

public class FullActivity extends AppCompatActivity {
    private ActivityFullBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String url = getIntent().getStringExtra("url");
        Picasso.get().load(url).into(binding.imageView2);
    }
}