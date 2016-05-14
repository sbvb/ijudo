package br.pl.iJudo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import br.pl.iJudo.R;

public class golpe extends Activity {

    WebView webviewActionView;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String xmlfile = null;
        if (extras != null) {
            xmlfile = extras.getString("xmlfile");
        }

        Log.d("mytag", "Abri um Golpe");

        int id = getResources().getIdentifier(xmlfile, "layout", getPackageName());

        setContentView(id);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        addListenerOnButton();


    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.btnYoutube);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Bundle extras = getIntent().getExtras();
                String nomedogolpe = extras.getString("nomedogolpe");
                Log.d("mytag", "detectei click no yourube");
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("query", nomedogolpe);
                Log.d("mytag", nomedogolpe);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }

        });

    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



}

