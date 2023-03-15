package com.example.homework_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText txtLog_Password , txtLog_Username;
    Button btnLog_Login;
    String testUsername ,testPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLog_Password =(EditText) findViewById(R.id.txtLog_Password);
        txtLog_Username =(EditText) findViewById(R.id.txtLog_Username);
        btnLog_Login =(Button) findViewById(R.id.btnlog_Login);

        final String SPreferences = "SharedPreferences",Username = "Username",Password = "Password";

        AlertDialog.Builder Alert = new AlertDialog.Builder(Login.this);


        SharedPreferences sharedPreferences = getSharedPreferences(SPreferences, Context.MODE_PRIVATE);
        testUsername = sharedPreferences.getString(Username,"Kayıt bulunamadı");
        testPassword = sharedPreferences.getString(Password,"Kayıt bulunamadı");

        btnLog_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (txtLog_Username.getText().toString().isEmpty() & txtLog_Password.getText().toString().isEmpty())
                {
                    Alert.setTitle("Hata !");
                    Alert.setMessage("Alanların dolu olduğundan emin olun");
                    Alert.show();

                }
                else
                {
                    if (txtLog_Password.getText().toString().equals(testPassword)&txtLog_Username.getText().toString().equals(testUsername))
                    {
                        startActivity(new Intent(Login.this , MainPage.class));
                    }
                    else
                    {
                        Alert.setTitle("Hata !");
                        Alert.setMessage("Alanların doğru şekilde doldurulduğundan emin ol");
                        Alert.show();
                    }


                }
            }
        });
    }
}