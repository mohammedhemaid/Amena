package com.app.wihack.amina.chatting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.commonAdapter.IBind;

import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.ViewById;

@EView
public class CurrentChatRow extends CardView implements IBind {

    @ViewById(R.id.sender_message_text) TextView senderMessageTextView;
    @ViewById(R.id.receiver_message_text) TextView receiverMessageTextView;

    public CurrentChatRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(Object o, int position) {

        Messages messages = (Messages) o;
        if (position % 2 == 0) {
            senderMessageTextView.setVisibility(View.VISIBLE);
            senderMessageTextView.setBackgroundResource(R.drawable.bg_sender_msg);
            senderMessageTextView.setTextColor(Color.BLACK);
            senderMessageTextView.setText(messages.getMessage());
        } else {
            senderMessageTextView.setVisibility(View.INVISIBLE);
            receiverMessageTextView.setVisibility(View.VISIBLE);

            receiverMessageTextView.setBackgroundResource(R.drawable.bg_receiver_msg);
            receiverMessageTextView.setTextColor(Color.BLACK);
            receiverMessageTextView.setText(messages.getMessage());
        }
    }
}
