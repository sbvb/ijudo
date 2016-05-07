package br.pl.iJudo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.pl.iJudo.R;

public class golpe extends Activity {

    WebView webviewActionView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String xmlfile = null;
        if (extras != null) {
            xmlfile = extras.getString("xmlfile");
        }


        int id = getResources().getIdentifier(xmlfile, "layout", getPackageName());
        setContentView(id);


    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}