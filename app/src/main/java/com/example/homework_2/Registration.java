package com.example.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;

public class Registration extends AppCompatActivity {

    EditText txtReg_Username,txtReg_Password,txtReg_PasswordTest;
    Button btnReg_Register;

    public static final String
            SPreferences = "SharedPreferences",
            Username = "Username",
            Password = "Password",
            Class = "Class",
            Gender = "Gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtReg_Password = (EditText) findViewById(R.id.txtReg_Password);
        txtReg_PasswordTest = (EditText) findViewById(R.id.txtPasswordTest);
        txtReg_Username = (EditText) findViewById(R.id.txtReg_Username);
        btnReg_Register = (Button) findViewById(R.id.btnReg_Register);

        SharedPreferences sharedPreferences = getSharedPreferences(SPreferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        btnReg_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String test = txtReg_Password.getText().toString();

                if (txtReg_Username.getText().toString().isEmpty() & txtReg_Password.getText().toString().isEmpty() & txtReg_PasswordTest.getText().toString().isEmpty())
                {
                    txtReg_Username.setError("Alanların dolu olduğundan emin olun");
                    txtReg_Password.setError("Alanların dolu  olduğundan emin olun");
                    txtReg_PasswordTest.setError("Alanların dolu olduğundan emin olun");

                }
                else {
                    if (txtReg_PasswordTest.getText().toString().equals(test)) {
                        editor.putString(Username, txtReg_Username.getText().toString());
                        editor.putString(Password, txtReg_Password.getText().toString());
                        editor.commit();
                        startActivity(new Intent(Registration.this , Giris.class));
                    }
                    else
                    {
                        txtReg_Password.setError("Alanların aynı olduğundan emin olun");
                        txtReg_PasswordTest.setError("Alanların aynı olduğundan emin olun");
                    }


                }
                //editor.putString(Username,txtReg_Username.getText().toString());
                //editor.putString(Password,txtReg_Password.getText().toString());
            }
        });
    }
}