package com.mobilhanem.retrofitexample;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitModel {

    @SerializedName("KullaniciAdi")
    @Expose
    public String KullaniciAdi;
    @SerializedName("Sifre")
    @Expose
    public String Sifre;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("aktiflik")
    @Expose
    public boolean aktiflik;
}