package com.example.victorina;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class BuyAccout extends AppCompatActivity {

    private Button btnBuyBack;

    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_accout);
        btnBuyBack = findViewById(R.id.btn_buyAccount_back);

        btnBuyBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, Menu_Activity.class);
            startActivity(intent);
            finish();

        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MobileAds.initialize(this, initializationStatus -> {
        });


        @SuppressLint({"CutPasteId", "MissingInflatedId", "LocalSuppress"}) WebView myWebView1 = findViewById(R.id.wb_BuyAccont);
        WebSettings webSettings = myWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        @SuppressLint({"MissingInflatedId", "LocalSuppress", "CutPasteId"}) WebView myWebView = findViewById(R.id.wb_BuyAccont);
        myWebView.loadUrl("https://playerok.com/categories/accounts");

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