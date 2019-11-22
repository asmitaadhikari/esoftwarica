package com.example.esoftwarica.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private WebView webView;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
//        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        webView = root.findViewById(R.id.webview);
        webView.loadUrl("https://softwarica.edu.np/");
        webView.setWebViewClient(new WebViewClient());
        return root;
    }
}