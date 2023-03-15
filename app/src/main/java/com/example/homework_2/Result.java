package com.example.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView lbl_Counter,lblRes_Password,lblRes_Username,lblRes_Class,lblRes_Gender;

    String TUsername ,TPassword,TClass ,TGender;
    public static final String
            SPreferences = "SharedPreferences",
            Username = "Username",
            Password = "Password",
            Class = "Class",
            Gender = "Gender";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lbl_Counter =(TextView) findViewById(R.id.lbl_Counter);
        lblRes_Class =(TextView) findViewById(R.id.lblRes_Class);
        lblRes_Gender =(TextView) findViewById(R.id.lblRes_Gender);
        lblRes_Password =(TextView) findViewById(R.id.lblRes_Password);
        lblRes_Username =(TextView) findViewById(R.id.lblRes_Username);

        TPassword= lblRes_Password.getText().toString();
        TUsername= lblRes_Username.getText().toString();
        TGender= lblRes_Gender.getText().toString();
        TClass= lblRes_Class.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(SPreferences, Context.MODE_PRIVATE);

        TPassword += sharedPreferences.getString(Password,"Kayıt bulunamadı");
        TUsername += sharedPreferences.getString(Username,"Kayıt bulunamadı");
        TGender += sharedPreferences.getString(Gender,"Kayıt bulunamadı");
        TClass += sharedPreferences.getString(Class,"Kayıt bulunamadı");


        lblRes_Username.setText(TUsername);
        lblRes_Password.setText(TPassword);
        lblRes_Class.setText(TClass);
        lblRes_Gender.setText(TGender);

        // Geriye sayım için CountDownTimer sınıfının nesnesini oluşturduk
        // 1. parametrede geriye sayımın kaçtan başlayacağını belirttik. milisaniye türünden istedğininden dolayı 60000 milisaniye = 60 saniye
        // 2. parametrede 1000 yani her 1 saniyede bir, bir işlem yapsın.
        new CountDownTimer(10000,1000) {

            // 2. parametrede girilen (1000) saniyede bir aşağıdaki işlem yapılsın.
            @Override
            public void onTick(long l) {
                // Her 1 saniyede bir TextView'a kalan değer yazdırılısın.
                // Milisaniye türünden gözükmesin diye 1000'e bölüyoruz.
                lbl_Counter.setText(""+l/1000);
            }

            // Geriye sayım işlemi bittiğinde yapılacak işlem.
            @Override
            public void onFinish() {
                lbl_Counter.setVisibility(lbl_Counter.INVISIBLE);
                lblRes_Username.setVisibility(lblRes_Username.VISIBLE);
                lblRes_Password.setVisibility(lblRes_Password.VISIBLE);
                lblRes_Class.setVisibility(lblRes_Class.VISIBLE);
                lblRes_Gender.setVisibility(lblRes_Gender.VISIBLE);
            }
        }.start();

    }
}