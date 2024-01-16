package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
@SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        @SuppressLint({"CutPasteId", "MissingInflatedId", "LocalSuppress"}) WebView myWebView1 = findViewById(R.id.wb_polici);
        WebSettings webSettings = myWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        @SuppressLint({"MissingInflatedId", "LocalSuppress", "CutPasteId"}) WebView myWebView = findViewById(R.id.wb_polici);
        myWebView.loadUrl("https://metanit.com/");

    }
}