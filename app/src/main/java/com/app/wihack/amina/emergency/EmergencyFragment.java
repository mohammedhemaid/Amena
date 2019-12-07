package com.app.wihack.amina.emergency;


import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.app.wihack.amina.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

@EFragment(R.layout.fragment_emergency)
public class EmergencyFragment extends Fragment {

    public boolean emergencyState;

    @ViewById(R.id.emergencyimageButton) ImageButton emergencyImageButton;
    @ViewById(R.id.cancelButton) Button cancelEmergency;
    @ViewById(R.id.panic_message) TextView panicMessageTextView;
    @ViewById(R.id.tab_to_start_message) TextView tabToStartTextView;
    @ViewById(R.id.spinner_linear_layout) LinearLayout spinnerLinearLayout;
    @ViewById(R.id.optional_info_label) TextView optionalInfoTextView;
    @ViewById(R.id.pulsator) PulsatorLayout pulsator;


    public EmergencyFragment() {
    }


    @AfterViews
    public void after() {
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
