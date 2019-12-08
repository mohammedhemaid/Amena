package com.app.wihack.amina.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.app.wihack.amina.commonAdapter.IBind;

import org.androidannotations.annotations.EView;

@EView
public class ChatListRow extends CardView implements IBind, View.OnClickListener {

    public ChatListRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void bind(Object o, int position) {
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CurrentChatActivity_.intent(getContext()).from(true).start();
    }
}