package com.wooou.pvl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lenovo on 2018/6/22.
 */

public class DrawingThread extends Thread {

    private Timer mTimer = new Timer();
    private SurfaceHolder mSurfaceHolder;
    private Rect mSurfaceFrame;
    private Paint normalPaint = new Paint();
    private Bitmap mCacheBitmap;
    private Canvas mCacheCanvas;
    private int i=0;

    public DrawingThread(SurfaceHolder holder) {
        this.mSurfaceHolder = holder;
        normalPaint.setColor(Color.RED);
        mSurfaceFrame = mSurfaceHolder.getSurfaceFrame();
        mCacheBitmap = Bitmap.createBitmap(mSurfaceFrame.right, mSurfaceFrame.bottom, Bitmap.Config.ARGB_8888);
        mCacheCanvas = new Canvas(mCacheBitmap);
    }

    @Override
    public void run() {
        running = true;
        mTimer.schedule(mTimerTask, 0,60);
    }

    public void addPoint(float x, float y) {
        mCacheCanvas.drawText("HelloWorld", x, y, normalPaint);
    }

    public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.e("DEBUG", "===onSurfaceChanged===");
        this.mSurfaceHolder = holder;
        mSurfaceFrame = mSurfaceHolder.getSurfaceFrame();
        mCacheBitmap = Bitmap.createBitmap(mSurfaceFrame.right, mSurfaceFrame.bottom, Bitmap.Config.ARGB_8888);
        mCacheCanvas = new Canvas(mCacheBitmap);
    }

    private boolean running = false;
    private TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            Log.e("DEBUG", "===TimerTask run==="+running);
            if (running) {
                Canvas mCanvas = mSurfaceHolder.lockCanvas();
                mCanvas.drawColor(Color.WHITE);
                mCanvas.drawBitmap(mCacheBitmap, 0, 0, null);
                mCanvas.drawText(""+i++, 10, 10, normalPaint);
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    };

    public void onPause() {
        running = false;
    }

    public void onResume() {
        running = true;
    }
}

