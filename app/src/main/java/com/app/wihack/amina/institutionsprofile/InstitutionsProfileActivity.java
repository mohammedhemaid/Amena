package com.app.wihack.amina.institutionsprofile;

import android.os.Build;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wihack.amina.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_institutions_profile)
public class InstitutionsProfileActivity extends AppCompatActivity {

    @AfterViews
    public void after() {
        hideTop();
    }


    @Click(R.id.back_ib)
    public void onBackClick() {
        finish();
    }

    void hideTop() {
        //hide Action bar and status bar color
        //  getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

}
