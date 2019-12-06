package com.app.wihack.amina.AddOrgChatting;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.chatting.IBind;
import com.app.wihack.amina.institutionsprofile.InstitutionsProfileActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.ViewById;


@EView
public class InstitutionRow extends CardView implements IBind {
    @ViewById(R.id.organization_picture) SimpleDraweeView orginizationPicture;

    public InstitutionRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(Object o, int position) {


    }

    @Click(R.id.organization_picture)
    public void openInstitutionProfile(){

    }
}
