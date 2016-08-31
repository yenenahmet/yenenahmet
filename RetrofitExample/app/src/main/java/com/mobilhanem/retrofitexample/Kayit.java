package com.mobilhanem.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import utils.Constants;

public class Kayit extends AppCompatActivity {
    private TaskService taskService;
    private RestAdapter restAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        Button btnKayit = (Button)findViewById(R.id.btnKayit);
        final EditText edtAd= (EditText)findViewById(R.id.editText3);
        final EditText edtOkul = (EditText)findViewById(R.id.editText4);
        final EditText edtMail = (EditText)findViewById(R.id.editText5);
        final EditText edtSifre = (EditText)findViewById(R.id.editText6);
           restAdapter = new RestAdapter.Builder()
                   .setEndpoint(Constants.URL)
                   .build();
           taskService = restAdapter.create(TaskService.class);

           btnKayit.setOnClickListener(new View.OnClickListener() {

                   @Override
                   public void onClick (View v) {
                       if (EmailValidator.isEmailValid(edtMail.getText().toString()) == true) {
                           if (edtAd.length() < 6 || edtOkul.length() < 6 || edtMail.length() < 6 || edtSifre.length() < 6) {
                               Toast.makeText(getApplicationContext(), "Lütfen Alanları Boş Bırakmayınız ve  en az 6 Katakter olması gerekli", Toast.LENGTH_LONG).show();
                           } else {
                               Task task = new Task(edtMail.getText().toString(), edtAd.getText().toString(), edtSifre.getText().toString(), edtOkul.getText().toString());
                               taskService.createTask(task, new Callback<ResponseTask>() {
                                   @Override
                                   public void success(ResponseTask responseTask, Response response) {

                                       Toast.makeText(getApplicationContext(), "gidiyor....", Toast.LENGTH_LONG).show();
                                       Toast.makeText(getApplicationContext(), responseTask.getName(), Toast.LENGTH_LONG).show();
                                   }

                                   @Override
                                   public void failure(RetrofitError error) {
                                       String merror = error.getLocalizedMessage();
                                       Log.v("hello", merror);
                                   }
                               });
                           }
                       }else{
                           Toast.makeText(getApplicationContext(), "Email Hatalı !!!", Toast.LENGTH_LONG).show();
                       }


                   }
           });
       }

}
class EmailValidator{
    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public static boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN,
                Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }
}

