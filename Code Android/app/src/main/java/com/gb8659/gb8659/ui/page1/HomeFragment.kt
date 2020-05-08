package com.gb8659.gb8659.ui.page1

import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.gb8659.gb8659.DataStorage
import com.gb8659.gb8659.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONObject

class HomeFragment : Fragment() {



    private var soundPool: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private val soundId = 1


    var liveData : MutableLiveData<JSONObject> = MutableLiveData<JSONObject>()
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })


        soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool!!.load(root.context, R.raw.switch23   , 1)
        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(root.context, R.raw.button6543  , 1)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            playSound2(view);
        }, 200)


        getQuery();
        liveData.observe(this, object: Observer<JSONObject> {
            override fun onChanged(json: JSONObject?) {
                var t= json
                update_card(json)
//                liveData.removeObserver(this)
            }
        })

    }

    fun update_card(json:JSONObject?) {
        allert8754.visibility = View.INVISIBLE
        scr8543.visibility = View.VISIBLE
        msgscreen()
        var title:String =  json!!.get("title").toString()
               text_home.setText(title)

    }

    fun msgscreen(){


        val toast = Toast.makeText(
            this.context,
            R.string.msg_update,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }
    fun getQuery() {

        val queue = Volley.newRequestQueue(this.context)
        val url: String =  DataStorage().url_title()
        var resp:String ="";
        val stringReq = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                resp = response.toString();
                var strResp = response.toString()
                val jsonObj: JSONObject = JSONObject(strResp)
                liveData.postValue(jsonObj)

            },
            Response.ErrorListener {
                resp = ""
            })
        queue.add(stringReq)
    }

    fun playSound2(view: View) {
        soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
//        Toast.makeText(this.context, "ОТКРЫТИЕ ШЛАГБАУМА", Toast.LENGTH_SHORT).show()
    }

}
