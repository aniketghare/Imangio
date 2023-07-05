package com.example.imangio.DATA;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MemeInterface {
    @GET("/get_memes")
   Call <DemoModal> getMemes();
}
