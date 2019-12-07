package com.app.wihack.amina.institutionsprofile;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wihack.amina.R;
import com.app.wihack.amina.chatting.CurrentChatActivity_;
import com.app.wihack.amina.chatting.OrganizationProfile;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_institutions_profile)
public class InstitutionsProfileActivity extends AppCompatActivity {
    @Extra OrganizationProfile organizationProfile;

    @ViewById(R.id.institution_name) TextView mInstitutionName;
    @ViewById(R.id.institutes_profile_picture) SimpleDraweeView institutionProfilePicture;
    @ViewById(R.id.text_desc) TextView mTextDesc;
    @ViewById(R.id.mobile_number) TextView mMobileNumber;
    @ViewById TextView email;

    @AfterViews
    public void after() {
        hideTop();

        if (organizationProfile!=null){
            institutionProfilePicture.setImageResource(organizationProfile.getOrganization_picture());
            mInstitutionName.setText(organizationProfile.getOrganization_name());
        }
    }


    @Click(R.id.back_ib)
    public void onBackClick() {
        finish();
    }

    void hideTop() {
        //hide Action bar and status bar color
        //  getSupportActionBar().hide();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    @Click(R.id.nav_to_chat_button)
    public void navToChat() {
        CurrentChatActivity_.intent(this).start();
    }
}
