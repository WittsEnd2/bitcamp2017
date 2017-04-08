package com.css.cssapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Blog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://css.umd.edu/blog/");
    }
}
