package com.css.cssapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.internal.zzs.TAG;

public class RegistrationActivity extends AppCompatActivity {
    Button registerButton;
    EditText fullName, skills, userName, password;
    Switch type;
    String userID;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    boolean canRegister = true;

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    // [END on_start_add_listener]

    // [START on_stop_remove_listener]
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fullName = (EditText)findViewById(R.id.registerFullName);
        skills = (EditText)findViewById(R.id.registerSkills);
        userName = (EditText)findViewById(R.id.registerUserName);
        password = (EditText)findViewById(R.id.registerPassword);
        type = (Switch) findViewById(R.id.switch1);
        registerButton = (Button)findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();

        // [END on_stop_remove_listener]

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    userID = new String(user.getUid());
                    Toast.makeText(getApplicationContext(),
                            "User ID: " + userID, Toast.LENGTH_LONG).show();
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
                if (fullName.length() > 0 && skills.length() > 0
                        && userName.length() > 4 && password.length() > 7 && canRegister == true) {
                    Toast.makeText(getApplicationContext(),
                            "Registration Successful!", Toast.LENGTH_LONG).show();
                    //Intent myIntent = new Intent(RegistrationActivity.this, ProjectForm.class);
                    //startActivity(myIntent);
                    String convertedUsername = userName.getText().toString();
                    String convertedPassword = password.getText().toString();

                    String convertedSkills = skills.getText().toString();
                    String convertedType;
                    if (type.isChecked()) {
                        convertedType = "Creator";
                    } else {
                        convertedType = "Collaborator";
                    }
                    
                    writeNewUser(userID, convertedSkills, "Default", convertedType);

                    createAccount(convertedUsername, convertedPassword);

                    Intent myIntent = new Intent(RegistrationActivity.this, ProjectForm.class);
                    startActivity(myIntent);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter all the fields.", Toast.LENGTH_LONG).show();
                }

                if(userName.length()<5)
                    Toast.makeText(getApplicationContext(),
                            "Username should contain more than 4 characters.", Toast.LENGTH_LONG).show();
                if(password.length()<8)
                    Toast.makeText(getApplicationContext(),
                            "Password should contain more than 7 characters.", Toast.LENGTH_LONG).show();
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

    private void writeNewUser(String userID, String skills, String bio, String type) {

        database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference();
        String key = mDatabase.child("users").push().getKey();
        User user = new User(key, skills, bio, type);
        Map<String, Object> userValues = user.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + key, userValues);

        mDatabase.updateChildren(childUpdates);
    }
}
