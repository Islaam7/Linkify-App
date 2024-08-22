package com.example.portfolioapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class WebActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView wv_webview = findViewById(R.id.webView);
        wv_webview.getSettings().getBuiltInZoomControls();
        wv_webview.getSettings().setJavaScriptEnabled(true);

        SwipeRefreshLayout swipe = findViewById(R.id.swipe);
        swipe.setOnRefreshListener(wv_webview::reload);

        wv_webview.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                swipe.setRefreshing(true);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                swipe.setRefreshing(false);
            }
        });

        String url = getIntent().getStringExtra("url");

        if (!(url == null)) wv_webview.loadUrl(url);
    }
    @Override
    public void onBackPressed() {
        WebView wv_webview = findViewById(R.id.webView);
        if (wv_webview.canGoBack()) wv_webview.goBack();
        else alert();
    }
private void alert() {
    AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
    builder.setTitle("Close");
    builder.setMessage("Do you want to exit?");
    builder.setPositiveButton("Yes", (dialog, which) -> super.onBackPressed());
    builder.setNegativeButton("No", null);
    builder.show();
    }

}