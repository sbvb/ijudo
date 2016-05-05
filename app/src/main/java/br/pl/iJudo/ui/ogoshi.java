package br.pl.iJudo.ui;

import android.app.Activity;
import android.os.Bundle;

import br.pl.iJudo.R;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ogoshi extends Activity {

    WebView webviewActionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogoshi);

    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}