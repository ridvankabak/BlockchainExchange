package com.ridvankabak.blockchainapp.ui.WebActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.ridvankabak.blockchainapp.R;

public class WebActivity extends AppCompatActivity implements WebActivityContract.View {
    private String TAG = "WebActivity";
    private WebActivityContract.Presenter mPresenter;

    WebView webView;
    ImageView imageViewBack;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initUi();
        setListener();
        mPresenter = new WebActivityPresenter(this);
        mPresenter.getWeb();
    }

    @Override
    public void getLoadWeb() {
        Toast.makeText(this,"Birkaç saniye içerisinde web sitesine yönlendiriliyorsunuz",Toast.LENGTH_SHORT).show();

        webView.getSettings().setJavaScriptEnabled(true) ;
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.loadUrl(url);
    }

    private void setListener() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initUi() {
        webView = findViewById(R.id.webView);
        imageViewBack = findViewById(R.id.imageViewBackWeb);

        url = getIntent().getStringExtra("url");
    }
}
