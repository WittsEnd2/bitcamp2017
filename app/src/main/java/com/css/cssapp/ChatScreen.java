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

public class ChatScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button bitellButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bitellButton = (Button)findViewById(R.id.speechbutton);


        bitellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swipe;
                swipe= new Intent(ChatScreen.this, DashboardLeader.class);
                startActivity(swipe);
            }
        });

    }

}
