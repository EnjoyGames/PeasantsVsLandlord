package com.wooou.pvl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PlayActivity<T:BaseP<BaseView>> : AppCompatActivity(),BaseView {

    var  TP :T  = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        TP.test(this)
    }


    override fun hello() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
