package com.davidmiguel.taxsystem.utils;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SimpleWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
