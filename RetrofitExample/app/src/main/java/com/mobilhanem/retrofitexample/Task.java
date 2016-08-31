package com.mobilhanem.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmet on 25.8.2016.
 */
public class Task {
    @SerializedName("email")
    private String email;
    @SerializedName("KullaniciAdi")
    private String KullaniciAdi;
    @SerializedName("Sifre")
    private String Sifre;
    @SerializedName("Okul")
    private String Okul;

    public Task(String email, String KullaniciAdi,String Sifre,String Okul) {
        this.email = email;
        this.KullaniciAdi = KullaniciAdi;
        this.Sifre = Sifre;
        this.Okul = Okul;

    }
}
