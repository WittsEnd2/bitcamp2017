package com.css.cssapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    Button registerButton;
    EditText firstName, lastName, userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = (EditText)findViewById(R.id.registerFirstName);
        lastName = (EditText)findViewById(R.id.registerLastName);
        userName = (EditText)findViewById(R.id.registerUserName);
        password = (EditText)findViewById(R.id.registerPassword);
        registerButton = (Button)findViewById(R.id.register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstName.length() > 0 && lastName.length() > 0
                        && userName.length() > 4 && password.length() > 7) {
                    Toast.makeText(getApplicationContext(),
                            "Registration Successful!", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter all the fields.", Toast.LENGTH_LONG).show();
                }

                if(userName.length()<5)
                    Toast.makeText(getApplicationContext(),
                            "Username contain more than 4 characters.", Toast.LENGTH_LONG).show();
                if(userName.length()<5)
                    Toast.makeText(getApplicationContext(),
                            "Password contain more than 7 characters.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
