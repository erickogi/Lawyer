package com.erickogi14gmail.lawyer.ServicesList;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.erickogi14gmail.lawyer.MainActivity;
import com.erickogi14gmail.lawyer.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by kimani kogi on 7/27/2017.
 */

public class ReadService extends Fragment {
    private View view;
    TextView textViewTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.readservice, container, false);
        getActivity().setTitle(MainActivity.serviceName);
        textViewTitle=(TextView)view.findViewById(R.id.txtTitle);
        textViewTitle.setText(MainActivity.serviceName);
        set("trial.htm");

        return view;
    }
    public void set(String htmlFilename){
        WebView htmlWebView = (WebView)view.findViewById(R.id.webView);
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);


        AssetManager mgr = getActivity().getBaseContext().getAssets();
        try {
            InputStream in = mgr.open(htmlFilename, AssetManager.ACCESS_BUFFER);
            final   String htmlContentInStringFormat = StreamToString(in);
            in.close();

            htmlWebView.loadDataWithBaseURL(null,null,null,null,null);
            htmlWebView.loadDataWithBaseURL(null, htmlContentInStringFormat, "text/html", "utf-8", null);
            htmlWebView.setWebViewClient(new WebViewClient() {



            });
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
    public static String StreamToString(InputStream in) throws IOException {
        if(in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }

}
