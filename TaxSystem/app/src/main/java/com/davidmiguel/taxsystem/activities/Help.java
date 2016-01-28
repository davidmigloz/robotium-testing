package com.davidmiguel.taxsystem.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.davidmiguel.taxsystem.R;
import com.davidmiguel.taxsystem.utils.SimpleWebViewClient;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set template
        setContentView(R.layout.activity_help);

        // Set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set back button
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        // Open web page in the web view
        WebView browser = (WebView) findViewById(R.id.webview);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            browser.setWebViewClient(new SimpleWebViewClient());
            WebSettings webSettings = browser.getSettings();
            webSettings.setJavaScriptEnabled(true);
            browser.loadUrl("http://davidmiguel.com/proyectos/robotium/taxsystem/");
        } else {
            // If there's no internet, show a message
            TextView message = (TextView) findViewById(R.id.message);
            browser.setVisibility(View.GONE);
            message.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
