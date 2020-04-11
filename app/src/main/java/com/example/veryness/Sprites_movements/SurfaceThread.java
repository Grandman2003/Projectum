package com.example.veryness.Sprites_movements;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

class SurfaceThread extends Thread {
    SurfaceHolder Holder;
    MySurfaceView view;
    long Time;
    boolean runBool = true;

    public SurfaceThread(SurfaceHolder holder, MySurfaceView view) { //constructor
        Holder = holder;
        this.view = view; //remember полученные переменные to local
        Time = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (runBool) {
            //super.run();
            Canvas canvas = null;
            long Time0 = System.currentTimeMillis();
            long Time_ = Time0 - Time;

            if (Time_ > 30) {
                Time = Time0;
                canvas = Holder.lockCanvas();
                synchronized (Holder) {
                    this.view.draw(canvas);

                }

                if (canvas != null) Holder.unlockCanvasAndPost(canvas);
            }
        }
    }




}