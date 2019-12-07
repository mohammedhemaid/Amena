package com.app.wihack.amina.chatting;

import android.content.Context;
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
        if (messages.getFrom().equals("1")) {
            senderMessageTextView.setVisibility(View.VISIBLE);
            senderMessageTextView.setText(messages.getMessage());
            receiverMessageTextView.setVisibility(View.INVISIBLE);

        } else {
            receiverMessageTextView.setVisibility(View.VISIBLE);
            receiverMessageTextView.setText(messages.getMessage());
            senderMessageTextView.setVisibility(View.INVISIBLE);

        }
    }
}
