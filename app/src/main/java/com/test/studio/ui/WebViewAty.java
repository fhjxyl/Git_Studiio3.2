package com.test.studio.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebChromeClient;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.test.studio.R;
import com.test.studio.entity.UserInfo;

public class WebViewAty extends Activity {

    UserInfo mUserInfo;

    BridgeWebView mBridgeWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_webview_layout);

        Intent intent = this.getIntent();
        String email = intent.getStringExtra("email");

        mUserInfo = new UserInfo(email);

        mBridgeWebView = findViewById(R.id.web_view);
        mBridgeWebView.setDefaultHandler(new DefaultHandler());
        mBridgeWebView.setWebChromeClient(new WebChromeClient() {

        });
        mBridgeWebView.loadUrl("file:///android_asset/getuserinfo.html");


        mBridgeWebView.registerHandler("callNative", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.e("WebViewAty", "handler = getUserInfo, data from web = " + data);
                function.onCallBack(new Gson().toJson(mUserInfo));
            }
        });

    }
}
