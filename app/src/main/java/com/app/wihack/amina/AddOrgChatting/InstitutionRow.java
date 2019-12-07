package com.app.wihack.amina.AddOrgChatting;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.chatting.CurrentChatActivity_;
import com.app.wihack.amina.commonAdapter.IBind;
import com.app.wihack.amina.institutionsprofile.InstitutionsProfileActivity_;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.ViewById;


@EView
public class InstitutionRow extends CardView implements IBind {
    @ViewById(R.id.organization_picture) SimpleDraweeView orginizationPicture;
    @ViewById(R.id.start_chat_image_button) ImageButton imageButton;

    public InstitutionRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(Object o, int position) {


    }

    @Click(R.id.organization_picture)
    public void openInstitutionProfile() {
        InstitutionsProfileActivity_.intent(getContext()).start();
    }

      @Click(R.id.start_chat_image_button)
    public void startChat() {
        CurrentChatActivity_.intent(getContext()).start();
    }
}
