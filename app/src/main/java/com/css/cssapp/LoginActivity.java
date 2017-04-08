package com.css.cssapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity  {
    Button loginButton;
    EditText userName, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.btn);
        userName = (EditText)findViewById(R.id.usr);
        password = (EditText)findViewById(R.id.psd);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Login Successful!",Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(LoginActivity.this, WAHF.class);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Login unsuccessful. Try again.",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}