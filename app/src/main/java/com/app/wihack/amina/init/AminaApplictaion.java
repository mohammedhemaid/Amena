package com.app.wihack.amina.init;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class AminaApplictaion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
