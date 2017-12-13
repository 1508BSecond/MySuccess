package com.pc.myapp.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by pc on 2017/12/13.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

    }
}
