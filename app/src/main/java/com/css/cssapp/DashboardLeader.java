package com.css.cssapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sparkpost.SparkPost;
import com.sparkpost.exception.SparkPostException;

public class DashboardLeader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button speechButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_leader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        speechButton = (Button)findViewById(R.id.speechbutton);


        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent(DashboardLeader.this, ChatScreen.class);
                startActivity(chat);
            }
        });

    }

}
