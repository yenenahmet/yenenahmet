package com.mobilhanem.retrofitexample;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by alperbeyler on 10/11/15.
 */

public interface RestInterfaceController {

    @GET("/api/Satinalma/getLogin")
    void getJsonValues(Callback<RetrofitModel[]> response);


}
