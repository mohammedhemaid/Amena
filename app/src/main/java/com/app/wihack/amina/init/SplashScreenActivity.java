package com.app.wihack.amina.init;

import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wihack.amina.R;
import com.app.wihack.amina.userprofile.UserProfileActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_splash_screen)
public class SplashScreenActivity extends AppCompatActivity {

    @AfterViews
    public void after() {
        new Handler().postDelayed(() -> {
            UserProfileActivity_.intent(this).start();
            finish();
        }, 1500);
    }
}
