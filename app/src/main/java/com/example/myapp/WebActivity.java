package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web);

        // Set the status bar color
        //  getWindow().setStatusBarColor(getResources().getColor(R.color.customStatusBarColor));
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set custom title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("App Dashboard");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button
            // Change the back arrow color
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow); // Set the custom back arrow
        }


        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());  // To open links in the WebView itself
        webView.setWebChromeClient(new WebChromeClient());  // For media playback

        // Enable JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Load a URL
        webView.loadUrl("https://app.nasil.sa");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}