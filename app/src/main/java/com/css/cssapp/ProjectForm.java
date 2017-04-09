package com.css.cssapp;

import android.content.Intent;
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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.internal.zzs.TAG;


public class ProjectForm extends AppCompatActivity {
    EditText projectName, projectDescription, numPeople;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;

    String projectNameConverted;
    String projectDescriptionConverted;
    int numPeopleConverted;
    String userConverted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        projectName = (EditText) findViewById(R.id.projectName);
        projectDescription = (EditText) findViewById(R.id.projectDescription);
        numPeople = (EditText) findViewById(R.id.numPeople);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    userConverted = user.getUid();
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
                projectNameConverted = projectName.getText().toString();
                projectDescriptionConverted = projectDescription.getText().toString();
                if (numPeople.getText().toString().equals("")) {
                    numPeopleConverted = 0;
                } else {
                    numPeopleConverted = Integer.parseInt(numPeople.getText().toString());
                }
                if (projectName.length() > 0 && projectDescription.length() > 0 && numPeopleConverted > 0) {
                Toast.makeText(ProjectForm.this, "Project created!",
                        Toast.LENGTH_SHORT).show();
                    Intent dashboard = new Intent(ProjectForm.this, DashboardLeader.class);
                    startActivity(dashboard);
            } else {
                Toast.makeText(ProjectForm.this, "Project not created!",
                        Toast.LENGTH_SHORT).show();
            }


                if (projectName.length() > 0 && projectDescription.length() > 0 && numPeopleConverted > 0) {
                    projectToDatabase(projectNameConverted, projectDescriptionConverted, userConverted, numPeopleConverted);
                }
            }
        });
    }
    protected void projectToDatabase(String name, String description, String uid, int numPeople) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        String key = myRef.child("projects").push().getKey();
        Projects projects = new Projects(uid, name, description, numPeople);
        Map<String, Object> projectValues = projects.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/projects/" + key, projectValues);

        myRef.updateChildren(childUpdates);


//        myRef.child("user").setValue(user);
//        myRef.child("name").setValue(name);
//        myRef.child("description").setValue(description);
//        myRef.child("numPeople").setValue(numPeople);
    }
}
