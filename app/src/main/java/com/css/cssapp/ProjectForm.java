package com.css.cssapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.google.android.gms.internal.zzs.TAG;


public class ProjectForm extends AppCompatActivity {
    EditText projectName, projectDescription, numPeople;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        projectName = (EditText) findViewById(R.id.projectName);
        projectDescription = (EditText) findViewById(R.id.projectDescription);
        numPeople = (EditText) findViewById(R.id.numPeople);

        final String projectNameConverted = projectName.getText().toString();
        final String projectDescriptionConverted = projectDescription.getText().toString();
        final int numPeopleConverted = Integer.parseInt(numPeople.getText().toString());

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
                // ...
            }
        };

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Button submitProject = (Button) findViewById(R.id.submitProject);

        submitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (projectName.length() > 0 && projectDescription.length() > 0 && numPeopleConverted > 0) {
                    projectToDatabase(projectNameConverted, projectDescriptionConverted, numPeopleConverted);
                }
            }
        });
    }
    protected void projectToDatabase(String name, String description, int numPeople) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("projects");

        myRef.child("user").setValue(user);
        myRef.child("name").setValue(name);
        myRef.child("description").setValue(description);
        myRef.child("numPeople").setValue(numPeople);
    }
}
