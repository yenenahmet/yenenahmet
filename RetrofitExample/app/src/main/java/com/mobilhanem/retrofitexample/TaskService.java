package com.mobilhanem.retrofitexample;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;


/**
 * Created by Ahmet on 25.8.2016.
 */
public interface TaskService {
        @POST("/api/Satinalma/Save")
        void createTask(@Body Task task, Callback<ResponseTask> cb);
}
