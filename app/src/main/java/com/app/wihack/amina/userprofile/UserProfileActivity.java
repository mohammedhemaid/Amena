package com.app.wihack.amina.userprofile;

import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.app.wihack.amina.R;
import com.app.wihack.amina.home.MainActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_user_profile)
public class UserProfileActivity extends AppCompatActivity {

    boolean mLocationPermissionGranted = true;
    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 9003;

    @ViewById(R.id.done) TextView doneTextView;

    @AfterViews
    public void after() {
        setTitle(R.string.profile);
        getLocationPermission();
        forceRTLIfSupported();
    }

    private void forceRTLIfSupported() {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Click(R.id.done)
    public void doneClick() {
        MainActivity_.intent(this).start();
    }
}
