package com.css.cssapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import android.widget.ViewSwitcher;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

<<<<<<< HEAD
public class DashboardLeader extends AppCompatActivity {
    Button no,yes;
    int i =0;
    ImageSwitcher imageSwitcher;
    TextSwitcher textSwitcher;
=======
import java.util.ArrayList;

import static com.google.android.gms.internal.zzs.TAG;
>>>>>>> ccc0e96ff75e7f82509f729568bcf9ca7cd7c3e2

public class DashboardLeader extends AppCompatActivity {
    ArrayList<Projects> projectList = new ArrayList<Projects>();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button speechButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_leader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        speechButton = (Button)findViewById(R.id.speechbutton);
        no = (Button)findViewById(R.id.cross);
        yes = (Button)findViewById(R.id.check);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        textSwitcher = (TextSwitcher) findViewById(R.id.textswitcher);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
                    public View makeView(){
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new TextSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
=======
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
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


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");
>>>>>>> ccc0e96ff75e7f82509f729568bcf9ca7cd7c3e2

        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Projects post = postSnapshot.getValue(Users.class);
                    projectList.add(post);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("The read failed: " ,databaseError.getMessage());
            }
        });

<<<<<<< HEAD
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0){
                    i--;
                   /* imageSwitcher.setImageResource(images[i]); PUT IN IMAGES HERE*/
                   /*textSwitcher.setText("blaaa"); PUT IN TEXT HERE*/
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i< 10 - 1){ /*PUT NUM OF USERS HERE replace 10*/
                    i++;
                   /* imageSwitcher.setImageResource(images[i]); PUT IN IMAGES HERE*/
                   /* textSwitcher.setText("blaaa"); PUT IN TEXT HERE*/
                }
            }
        });

=======
>>>>>>> ccc0e96ff75e7f82509f729568bcf9ca7cd7c3e2
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
