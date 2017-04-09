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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import android.widget.Toast;
import com.sparkpost.SparkPost;
import com.sparkpost.exception.SparkPostException;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import org.w3c.dom.Text;

public class DashboardLeader extends AppCompatActivity {
    Button no,yes;
    int i =0;
    ImageSwitcher imageSwitcher;
    TextSwitcher textSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button speechButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_leader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
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

    }

}
