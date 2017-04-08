package com.css.cssapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProjectForm extends AppCompatActivity {
    EditText projectName, projectDescription, numPeople;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_form);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Projects");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        projectName = (EditText) findViewById(R.id.projectName);
        projectDescription = (EditText) findViewById(R.id.projectDescription);
        numPeople = (EditText) findViewById(R.id.numPeople);

        String projectNameConverted = projectName.getText().toString();
        String projectDescriptionConverted = projectDescription.getText().toString();
        final int numPeopleConverted = Integer.parseInt(numPeople.getText().toString());

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Button submitProject = (Button) findViewById(R.id.submitProject);
        submitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (projectName.length() > 0 && projectDescription.length() > 0 && numPeopleConverted > 0) {

            }
            }
        });
    }

}
