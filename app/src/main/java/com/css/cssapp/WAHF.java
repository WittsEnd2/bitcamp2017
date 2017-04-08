package com.css.cssapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WAHF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wahf);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdaZ4hnJpch3y76n2_PcLGQEpQUjbDDstGgCGJ3AnzMlNBTTw/viewform");
    }
}
