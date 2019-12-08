package com.app.wihack.amina.emergency;


import android.graphics.Color;
import android.location.Location;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.app.wihack.amina.R;
import com.app.wihack.amina.userprofile.UserProfile;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

@EFragment(R.layout.fragment_emergency)
public class EmergencyFragment extends Fragment {
    private static final String TAG = "EmergencyFragment";

    @ViewById(R.id.emergencyimageButton) ImageButton emergencyImageButton;
    @ViewById(R.id.cancelButton) Button cancelEmergency;
    @ViewById(R.id.panic_message) TextView panicMessageTextView;
    @ViewById(R.id.tab_to_start_message) TextView tabToStartTextView;
    @ViewById(R.id.spinner_linear_layout) LinearLayout spinnerLinearLayout;
    @ViewById(R.id.optional_info_label) TextView optionalInfoTextView;
    @ViewById(R.id.pulsator) PulsatorLayout pulsator;

    private FusedLocationProviderClient fusedLocationProviderClient;


    public boolean emergencyState;
    private FirebaseFirestore mDb;

    public EmergencyFragment() {
    }

    @AfterViews
    public void after() {
        mDb = FirebaseFirestore.getInstance();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        SpannableString spannableString = new SpannableString(getString(R.string.tab_to_start_the_emergency));
        spannableString.setSpan(
                new ForegroundColorSpan(Color.RED),
                spannableString.length() - 10, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tabToStartTextView.setText(spannableString);

    }

    @Click(R.id.emergencyimageButton)
    public void emergencyClick() {

        if (!emergencyState) {
            emergencyImageButton.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bg_circle_red));
            cancelEmergency.setVisibility(View.VISIBLE);
            panicMessageTextView.setVisibility(View.VISIBLE);
            tabToStartTextView.setVisibility(View.INVISIBLE);
            spinnerLinearLayout.setVisibility(View.INVISIBLE);
            optionalInfoTextView.setVisibility(View.INVISIBLE);
            pulsator.start();

            DocumentReference docRef = mDb.collection("users").document("1");
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        UserProfile userProfile = task.getResult().toObject(UserProfile.class);
                        userProfile.setViolence_type("عنف جسدي");
                        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {

                                if (task.isSuccessful()) {
                                    Location location = task.getResult();
                                    GeoPoint geoPoint = new GeoPoint(location.getLatitude(), location.getLongitude());
                                    Log.d(TAG, "onComplete: latitude " + geoPoint.getLatitude());
                                    Log.d(TAG, "onComplete: longitude " + geoPoint.getLongitude());

                                    userProfile.setGeo_point(geoPoint);
                                    mDb.collection("violenced_users")
                                            .document("1")
                                            .set(userProfile);
                                }
                            }
                        });
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });


        }

    }

    @Click(R.id.cancelButton)
    public void setCancelEmergency() {
        emergencyState = false;
        emergencyImageButton.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bg_circle_light));
        cancelEmergency.setVisibility(View.INVISIBLE);
        panicMessageTextView.setVisibility(View.INVISIBLE);
        tabToStartTextView.setVisibility(View.VISIBLE);
        spinnerLinearLayout.setVisibility(View.VISIBLE);
        optionalInfoTextView.setVisibility(View.VISIBLE);
        pulsator.stop();


    }
}
