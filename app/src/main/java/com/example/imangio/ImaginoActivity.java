package com.example.imangio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.imangio.DATA.DemoModal;
import com.example.imangio.DATA.MemeAdapter;
import com.example.imangio.DATA.MemeInterface;
import com.example.imangio.databinding.ActivityMemeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImaginoActivity extends AppCompatActivity {

    private ActivityMemeBinding binding;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<String> list = new ArrayList<>();

        // Recyclerview code point to remember

        recyclerView = binding.recyclerview;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //retrofit class

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.imgflip.com/").build();

        MemeInterface retro = retrofit.create(MemeInterface.class);

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        retro.getMemes().enqueue(
                                new Callback<DemoModal>() {
                                    @Override
                                    public void onResponse(Call<DemoModal> call, Response<DemoModal> response) {
                                        List<DemoModal.Data.Memes> memesData = response.body().getData().getMemes();

                                        for(int i = 0 ; i<memesData.size() ;i++){
                                            list.add(memesData.get(i).getUrl());
                                        }
                                        RecyclerView.Adapter adapter = new MemeAdapter(ImaginoActivity.this , list);
                                        recyclerView.setAdapter(adapter);

                                    }

                                    @Override
                                    public void onFailure(Call<DemoModal> call, Throwable t) {
                                        Toast.makeText(ImaginoActivity.this, "error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        );
                    }
                }

        );
        thread.start();

    }

}