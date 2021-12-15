package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etUrl;       //변수 선언
    Button btnGo, btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.web);

        etUrl = (EditText) findViewById(R.id.etUrl); //생성된 변수를 위젯에 대입입
       btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.web);

        web.setWebViewClient(new CookWebViewClient()); //CookWebViewClient 생성해 웹뷰에 대입

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);  //WebSettings클래스를 사용해 줌 버튼 컨트롤이 화면에 보이게 (true)함

        webSet.setJavaScriptEnabled(true); //웹뷰에서 JS가 작동되게 한다.

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(etUrl.getText().toString()); //에딧텍스트에 입력한 url이 웹뷰에 나오게 한다.
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack(); //웹뷰의 이전 화면으로 돌아간다.
            }
        });

    }
    class CookWebViewClient extends WebViewClient {  //변수 생성 대입 후 오버라이드 실행

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view,url);
        }
    }
}