package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class Logic_game extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_game);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MobileAds.initialize(this, initializationStatus -> {
        });

        @SuppressLint({"CutPasteId", "MissingInflatedId", "LocalSuppress"}) WebView myWebView1 = findViewById(R.id.wb_game);
        WebSettings webSettings = myWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        @SuppressLint({"MissingInflatedId", "LocalSuppress", "CutPasteId"}) WebView myWebView = findViewById(R.id.wb_game);
        myWebView.loadUrl("https://yandex.ru/games/app/96860#app-id=96860&catalog-session-uid=catalog-4532a089-2e78-505d-b80b-f84371de9536-1705316451754-3257&rtx-reqid=8537820415275199671&pos=%7B%22listType%22%3A%22suggested%22%2C%22tabCategory%22%3A%22tag%22%7D&redir-data=%7B%22http_ref%22%3A%22https%253A%252F%252Fyandex.ru%252Fgames%252Ftag%252Flogicheskie_148%22%2C%22rn%22%3A556890930%7D");
    }

    private long timeOnBackPressed ;
    private Toast backToast;


    @Override
    public void onBackPressed() {


        if (timeOnBackPressed + 5000> System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            backToast =  Toast.makeText(this, "Нажмите ещё раз , чтобы выйти ", Toast.LENGTH_SHORT);
            backToast.show();
        }
        timeOnBackPressed = System.currentTimeMillis();


    }
}