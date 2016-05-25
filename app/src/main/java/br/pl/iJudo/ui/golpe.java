package br.pl.iJudo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import br.pl.iJudo.R;

public class golpe extends ActionBarActivity {

    WebView webviewActionView;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("nomedogolpe");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Bundle extras = getIntent().getExtras();
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

        button.setHapticFeedbackEnabled( true );

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Bundle extras = getIntent().getExtras();
                String nomedogolpe = extras.getString("nomedogolpe");
                button.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                Log.d("mytag", "detectei click no yourube");
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("query", nomedogolpe);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               // // app icon in action bar clicked; go home
               // Intent intent = new Intent(this, MainActivity.class);
               // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               // startActivity(intent);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

