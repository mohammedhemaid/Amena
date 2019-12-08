package com.app.wihack.amina.userprofile;

import android.Manifest;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.app.wihack.amina.R;
import com.app.wihack.amina.home.MainActivity_;
import com.google.firebase.firestore.FirebaseFirestore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_user_profile)
public class UserProfileActivity extends AppCompatActivity {

    boolean mLocationPermissionGranted = true;
    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 9003;

    @ViewById(R.id.done) TextView doneTextView;
    @ViewById(R.id.user_name_edit_text) EditText mUserNameEditText;
    @ViewById(R.id.age_edit_text) EditText mAgeEditText;
    @ViewById(R.id.children_no_edit_text) EditText mChildrenNoEditText;

    private FirebaseFirestore mDb;

    @AfterViews
    public void after() {
        setTitle(R.string.profile);
        mDb = FirebaseFirestore.getInstance();

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
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Click(R.id.done)
    public void doneClick() {
        String name = "none";
        int age = 0;
        int childrenNumber = 0;
        if (!TextUtils.isEmpty(mUserNameEditText.getText())) {
            name = String.valueOf(mUserNameEditText.getText());

        }
        if (!TextUtils.isEmpty(mAgeEditText.getText())) {
            age = Integer.parseInt(String.valueOf(mAgeEditText.getText()));

        }
        if (!TextUtils.isEmpty(mChildrenNoEditText.getText())) {
            childrenNumber = Integer.parseInt(String.valueOf(mChildrenNoEditText.getText()));
        }


        UserProfile userProfile = new UserProfile(name, age, childrenNumber);
        mDb.collection("users")
                .document("1")
                .set(userProfile);
        MainActivity_.intent(this).start();
    }
}
