package com.mobilhanem.retrofitexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import utils.Constants;

public class Loginactivity extends AppCompatActivity {
    private Button Login_button;
    private Button Kayit_button;
    private RestAdapter restAdapter;
    private RestInterfaceController restInterface;
    private ProgressDialog progressDialog;
    private int giris = 0;
   public static SharedPreferences preferences;
   public static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       final   EditText et1 = (EditText)findViewById(R.id.editText);
       final  EditText et2 = (EditText)findViewById(R.id.editText2);

        Login_button= (Button)findViewById(R.id.button);
        Kayit_button =(Button)findViewById(R.id.button3);
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.URL)
                .build();
        restInterface = restAdapter.create(RestInterfaceController.class);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();

        if(preferences.getBoolean("login", false)){
            Toast.makeText(getApplicationContext(),"Kontrol..",Toast.LENGTH_LONG).show();

        }
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("") && et2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Lütfen Alanları boş bırakmayınız...",Toast.LENGTH_LONG).show();
                }

                progressDialog = new ProgressDialog(Loginactivity.this);
                progressDialog.setMessage("Yükleniyor..");
                progressDialog.setCancelable(false);
                progressDialog.show();

                restInterface.getJsonValues(new Callback<RetrofitModel[]>() { // json array döneceği için modelimizi array tipinde belirledik
                    @Override
                    public void success(RetrofitModel[] model, Response response) {

                        try {
                            for (RetrofitModel modelValues : model) {

                                if (et1.getText().toString().equals(modelValues.email) && et2.getText().toString().equals(modelValues.Sifre)) {
                                    Toast.makeText(getApplicationContext(),String.valueOf(modelValues.aktiflik), Toast.LENGTH_LONG).show();
                                    if(modelValues.aktiflik == false) {
                                        editor.putBoolean("login", true);
                                        editor.commit();
                                        Toast.makeText(getApplicationContext(), String.valueOf(modelValues.aktiflik), Toast.LENGTH_LONG).show();
                                        //Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                                        //startActivity(intent);
                                        Toast.makeText(getApplicationContext(), "Login oldu !!!", Toast.LENGTH_LONG).show();

                                        progressDialog.cancel();
                                        giris = 1;
                                    }else if (modelValues.aktiflik == true){
                                        Toast.makeText(getApplicationContext(), "Başka Cihazdan Login Olunmuşutur Lütfen Çıkış yapınız !!!", Toast.LENGTH_LONG).show();
                                    }
                                }



                            }
                            if(giris == 0) {
                                Toast.makeText(getApplicationContext(), "Kullanıcı Bulunamadı !!!", Toast.LENGTH_LONG).show();
                            }
                        }  catch(Exception e){
                            Toast.makeText(getApplicationContext(),"Lütfen Email kontrol ediniz...",Toast.LENGTH_LONG).show();
                        }

                        progressDialog.cancel();
                    }

                    @Override
                    public void failure(RetrofitError error) {

                        String merror = error.getMessage();
                        Toast.makeText(getApplicationContext(),merror,Toast.LENGTH_LONG).show();
                        progressDialog.cancel();
                    }
                });
            }
        });
        Kayit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Kayit.class);
                startActivity(intent);
                finish();
            }
        });
        }

}




