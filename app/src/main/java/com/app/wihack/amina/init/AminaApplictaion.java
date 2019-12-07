package com.app.wihack.amina.init;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

public class AminaApplictaion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }


}
