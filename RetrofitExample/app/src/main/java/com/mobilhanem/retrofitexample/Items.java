package com.mobilhanem.retrofitexample;

/**
 * Created by alperbeyler on 17/11/15.
 */
public class Items   {

    private String KullaniciAdi;
    private String Sifre;
    private String email;
    private boolean aktiflik;

    public void setKullaniciAdi(String KullaniciAdi){

        this.KullaniciAdi = KullaniciAdi;
    }
    public String getKullaniciAdi(){

        return this.KullaniciAdi;
    }
    public void setSifre(String Sifre){

        this.Sifre = Sifre;
    }
    public String getSifre(){

        return this.Sifre;
    }
    public void setEmail(String email){

        this.email = email;
    }
    public String getEmail(){

        return this.email;
    }
    public void setAktiflik(boolean aktiflik){

        this.aktiflik = aktiflik;
    }
    public boolean getAktiflik(){

        return this.aktiflik;
    }
}
