package com.mobilhanem.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmet on 29.8.2016.
 */
public class ResponseTask {
    @SerializedName("name")
    @Expose
    private String name;
    public void setName(String name){

        this.name = name;
    }
    public String getName(){

        return this.name;
    }
}
