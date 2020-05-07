package com.gb8659.gb8659.ui.page3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.gb8659.gb8659.DataStorage
import com.gb8659.gb8659.R
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NotificationsFragment : Fragment() {

    var closeAlert1 : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var webView1: WebView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

//        webView1 = root.findViewById(R.id.webview)
//        webView1.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//        }
//        webview.settings.javaScriptEnabled = true
//        webView1.loadUrl(DataStorage().url_site())
//
//        webView1.getSettings().setJavaScriptEnabled(true);
//        webView1.getSettings().setBuiltInZoomControls(true);
//        webView1.setInitialScale(100)



        root.button5626!!.setOnClickListener {
            openlink();
        }

//        root.button7543!!.setOnClickListener {
//            // TODO Auto-generated method stub
//
//            if (webView1.canGoBack()) {
//                webView1.goBack()
//            }
//        }
//        root.button3652!!.setOnClickListener {
//            // TODO Auto-generated method stub
//
//            if (webView1.canGoForward()) {
//                webView1.goForward()
//            }
//        }


        return root
    }


    fun openlink(){

        openNewTabWindow(DataStorage().url_site(), view!!.context)
    }


    fun openNewTabWindow(urls: String, context: Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }


}
