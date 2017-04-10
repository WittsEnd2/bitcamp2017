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
    EditText projectName, projectDescription, numPeople, projectLeader;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private FirebaseUser user;

    // Strings or ints that are converted from the EditText values
    String projectNameConverted;
    String projectDescriptionConverted;
    int numPeopleConverted;
    String projectLeaderConverted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        projectName = (EditText) findViewById(R.id.projectName);
        projectDescription = (EditText) findViewById(R.id.projectDescription);
        numPeople = (EditText) findViewById(R.id.numPeople);
        projectLeader = (EditText) findViewById(R.id.projectLeader);

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
                projectNameConverted = projectName.getText().toString();
                projectDescriptionConverted = projectDescription.getText().toString();
                projectLeaderConverted = projectLeader.getText().toString();
                if (numPeople.getText().toString().equals("")) {
                    numPeopleConverted = 0;
                } else {
                    numPeopleConverted = Integer.parseInt(numPeople.getText().toString());
                }
                if (projectName.length() > 0 && projectDescription.length() > 0
                        && numPeopleConverted > 0 && projectLeader.length() > 0) {
                projectToDatabase(projectNameConverted, projectDescriptionConverted,

                        numPeopleConverted, projectLeaderConverted);
                Toast.makeText(ProjectForm.this, "Project created!",
                        Toast.LENGTH_SHORT).show();
                    //Intent dashboard = new Intent(ProjectForm.this, DashboardLeader.class);
                    //startActivity(dashboard);
            } else {
                Toast.makeText(ProjectForm.this, "Project not created!",
                        Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
    protected void projectToDatabase(String name, String description, int numPeople,
                                     String projectLeader) {
        database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference();
        String key = mDatabase.child("projects").push().getKey();
        Projects projects = new Projects(projectLeader, name, description, numPeople);
        Map<String, Object> postValues = projects.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/projects/" + key, postValues);

        mDatabase.updateChildren(childUpdates);

        // Adding the project to the user


    }
}
