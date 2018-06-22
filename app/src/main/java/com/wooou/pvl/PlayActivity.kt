package com.wooou.pvl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.View
import kotlinx.android.synthetic.main.activity_play.*
import android.graphics.BitmapFactory
import com.wooou.pvl.R.drawable.ic_launcher_foreground


class PlayActivity: AppCompatActivity(), View.OnTouchListener, SurfaceHolder.Callback {

    private var mThread: DrawingThread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        mSurfaceView.setOnTouchListener(this)
        mSurfaceView.holder.addCallback(this)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (event!!.action === MotionEvent.ACTION_DOWN) {
            mThread!!.addPoint(event!!.x , event!!.y)
        }
        return true
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        mThread!!.onSurfaceChanged(holder,format,width, height)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        mThread!!.onPause()
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        if(mThread==null){
            mThread = DrawingThread(holder)
            mThread!!.start()
        }else{
            mThread!!.onResume()
        }

    }
}
