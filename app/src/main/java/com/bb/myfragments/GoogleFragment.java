package com.bb.myfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GoogleFragment extends Fragment {
    private WebView webCbView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webview_frag, container, false);
        webCbView = view.findViewById(R.id.webView);
        webCbView.setWebViewClient(new WebViewClient());
        WebSettings settings = webCbView.getSettings();
        settings.setJavaScriptEnabled(true);
        webCbView.loadUrl("http://www.google.com");
        return view;
    }
}
