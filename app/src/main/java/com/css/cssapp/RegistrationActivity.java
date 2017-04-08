package com.css.cssapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.google.android.gms.internal.zzs.TAG;

public class RegistrationActivity extends AppCompatActivity {
    Button registerButton;
    EditText firstName, lastName, userName, password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = (EditText)findViewById(R.id.registerFirstName);
        lastName = (EditText)findViewById(R.id.registerLastName);
        userName = (EditText)findViewById(R.id.registerUserName);
        password = (EditText)findViewById(R.id.registerPassword);
        registerButton = (Button)findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // [START_EXCLUDE]
            }
        };

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstName.length() > 0 && lastName.length() > 0
                        && userName.length() > 4 && password.length() > 7) {
                    Toast.makeText(getApplicationContext(),
                            "Registration Successful!", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(myIntent);
                    String convertedUsername = userName.getText().toString();
                    String convertedPassword = password.getText().toString();

                    createAccount(convertedUsername, convertedPassword);

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
    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Firebase did not register account",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        // [END create_user_with_email]
    }
}
