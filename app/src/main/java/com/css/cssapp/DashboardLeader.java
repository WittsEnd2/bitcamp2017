package com.css.cssapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sparkpost.SparkPost;
import com.sparkpost.exception.SparkPostException;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class DashboardLeader extends AppCompatActivity {
    Button no, yes;
    int i = 0;
    TextSwitcher textSwitcher;
    String[] skillSet = {"Steven Tra\nVidMe", "Michael Alper\nTibell", "Michael Wittner\nSpaceBook"};

    ArrayList<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button speechButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_leader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        speechButton = (Button) findViewById(R.id.speechbutton);
        no = (Button) findViewById(R.id.cross);
        yes = (Button) findViewById(R.id.check);

        textSwitcher = (TextSwitcher) findViewById(R.id.textswitcher);

        textSwitcher.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(DashboardLeader.this);
                textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                textView.setTextSize(30);
                textView.setTextColor(Color.BLUE);
                return textView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, R.anim.in);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.out);

        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);

        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent(DashboardLeader.this, ChatScreen.class);
                startActivity(chat);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < skillSet.length) {
                    i++;
                    textSwitcher.setText(skillSet[i]);
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < users.size()) { /*PUT NUM OF USERS HERE replace 10*/
                    i++;
                   textSwitcher.setText(skillSet[i]);
                }
            }
        });

        textSwitcher.setText(skillSet[i]);

        //init();
    }

    private void addUsers() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("users").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 0;
                String[] entries = new String[4];
                users.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot innerSnap : snapshot.getChildren()) {
                        entries[i++] = (String) snapshot.getValue();
                    }
                    User user = new User(entries[3], entries[1], entries[0], entries[2]);
                    users.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError e) {

            }
        });

    }

    private void init() {
        addUsers();
        textSwitcher.setText(users.get(i).getSkills());
    }


}


