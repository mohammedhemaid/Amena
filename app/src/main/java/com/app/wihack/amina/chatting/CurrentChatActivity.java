package com.app.wihack.amina.chatting;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.commonAdapter.RecycleViewAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_current_chat)
public class CurrentChatActivity extends AppCompatActivity {

    @ViewById(R.id.private_list_messages) RecyclerView listMessagesRecyclerView;
    @ViewById(R.id.send_chat_message_edit_text) EditText messageEditText;
    ArrayList<String> receiverMessagesArrayList = new ArrayList<>();

    int messageCount = 0;
    RecycleViewAdapter adapter;

    @AfterViews
    public void after() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new RecycleViewAdapter();
        adapter.setData(Messages.getListMessages());
        adapter.setRecycleViewRes(R.layout.row_current_chat);
        listMessagesRecyclerView.setAdapter(adapter);
        receiverMessagesArrayList.add("Hello, How can I help you?");
        receiverMessagesArrayList.add("Thanks for contact us, We will reply soon");
       forceRTLIfSupported();
    }

    private void forceRTLIfSupported() {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    @Click(R.id.send_chat_message_ib)
    public void sendMessage() {
        String message = String.valueOf(messageEditText.getText());
        Messages.setMessages("1", message);
        Messages.setMessages("2", receiverMessagesArrayList.get(messageCount));
        messageCount++;
        adapter.setData(Messages.getListMessages());
        messageEditText.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Messages.setListOfMessages(new ArrayList<>());
    }
}
