package com.example.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {
    RadioGroup rg_Gender , rg_Class;
    RadioButton rb_Gender , rb_Class;
    TextView lblMain_Title;
    Button btnMain_Login;

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
        setContentView(R.layout.activity_main_page);

        SharedPreferences sharedPreferences = getSharedPreferences(SPreferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        lblMain_Title = (TextView) findViewById(R.id.lblMain_Title);
        rg_Gender =(RadioGroup) findViewById(R.id.rg_Gender);
        rg_Class =(RadioGroup) findViewById(R.id.rg_Class);
        btnMain_Login =(Button) findViewById(R.id.btnMain_Login);
        lblMain_Title =(TextView) findViewById(R.id.lblMain_Title);

        String str = lblMain_Title.getText().toString();
        String str1 = sharedPreferences.getString(Username,"");
        str += str1;
        lblMain_Title.setText(str);


        btnMain_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rgId_Gender = rg_Gender.getCheckedRadioButtonId();
                rb_Gender = (RadioButton) findViewById(rgId_Gender);

                int rgId_Class = rg_Class.getCheckedRadioButtonId();
                rb_Class =(RadioButton) findViewById(rgId_Class);

                editor.putString(Class,rb_Class.getText().toString());
                editor.putString(Gender,rb_Gender.getText().toString());

                editor.commit();

                startActivity(new Intent(MainPage.this,Result.class));
            }
        });




    }
}