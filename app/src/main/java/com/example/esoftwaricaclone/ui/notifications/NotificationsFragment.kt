package com.example.esoftwaricaclone.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.esoftwaricaclone.R

class NotificationsFragment : Fragment() {
    private lateinit var webView: WebView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        webView = view.findViewById(R.id.websoftwarica)
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("https://softwarica.edu.np/")
            settings.javaScriptEnabled = true
            settings.allowFileAccess = true
        }
        return view
    }
}