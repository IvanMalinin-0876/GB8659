package com.gb8659.gb8659.ui.page4

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.gb8659.gb8659.DataStorage
import com.gb8659.gb8659.R
import kotlinx.android.synthetic.main.fragment_git.view.*

class gitFragment : Fragment() {

    private lateinit var GitViewModel: gitViewModel
    private lateinit var webView1: WebView

    private var soundPool: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private var soundPool3: SoundPool? = null
    private val soundId = 1


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        GitViewModel =
                ViewModelProviders.of(this).get(gitViewModel::class.java)
       val root = inflater.inflate(R.layout.fragment_git, container, false)



//        webView1 = root.findViewById(R.id.webview7653)
//        webView1.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//        }
////        webview.settings.javaScriptEnabled = true
//        webView1.loadUrl(DataStorage().url_git())
//
//        webView1.getSettings().setJavaScriptEnabled(true);
//        webView1.getSettings().setBuiltInZoomControls(true);
//        webView1.setInitialScale(100)



        root.button2564!!.setOnClickListener {
            Handler().postDelayed({
                playSound3(root);
            }, 200)
            openlink();
        }

//       root.button6533!!.setOnClickListener {
//            // TODO Auto-generated method stub
//
//            if (webView1.canGoBack()) {
//                webView1.goBack()
//            }
//        }
//        root.button2853!!.setOnClickListener {
//            // TODO Auto-generated method stub
//
//            if (webView1.canGoForward()) {
//                webView1.goForward()
//            }
//        }
        soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool!!.load(root.context, R.raw.switch23   , 1)
        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(root.context, R.raw.button6543  , 1)
        soundPool3 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool3!!.load(root.context, R.raw.button6543   , 1)


       return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Handler().postDelayed({
            playSound2(view);
        }, 200)
    }

    fun playSound3(view: View) {
        soundPool3?.play(soundId, 1F, 1F, 0, 0, 1F)
//        Toast.makeText(this.context, "ОТКРЫТИЕ ШЛАГБАУМА", Toast.LENGTH_SHORT).show()
    }

    fun openlink(){
        openNewTabWindow(DataStorage().url_git(), view!!.context)
    }


    fun openNewTabWindow(urls: String, context: Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }

    fun playSound2(view: View) {
        soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
//        Toast.makeText(this.context, "ОТКРЫТИЕ ШЛАГБАУМА", Toast.LENGTH_SHORT).show()
    }

}
