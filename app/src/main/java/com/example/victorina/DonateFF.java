package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class DonateFF extends AppCompatActivity {
    private Button btn_bak , sup;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_ff);

        sup = findViewById(R.id.btn_support2);
        btn_bak = findViewById(R.id.btn_backd);



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MobileAds.initialize(this, initializationStatus -> {
        });

        btn_bak.setOnClickListener(view -> {
            Intent intent = new Intent(this , Menu_Activity.class);
            startActivity(intent);
            finish();
        });

        @SuppressLint("CutPasteId") WebView myWebView1 = findViewById(R.id.wb_GARENA);
        WebSettings webSettings = myWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) WebView myWebView = findViewById(R.id.wb_GARENA);
        myWebView.loadUrl("https://playerok.com/categories/donate");
    }
    private long timeOnBackPressed ;
    private Toast backToast;
    @Override
    public void onBackPressed() {


        if (timeOnBackPressed + 3000> System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            backToast =  Toast.makeText(this, "Нажмите ещё раз , чтобы выйти ", Toast.LENGTH_SHORT);
            backToast.show();
        }
        timeOnBackPressed = System.currentTimeMillis();

    }
}