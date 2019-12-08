package com.app.wihack.amina.chatting;

import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.commonAdapter.RecycleViewAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_current_chat)
public class CurrentChatActivity extends AppCompatActivity {

    public static final String FROM_PAGE = "from_current_chats";
    @ViewById(R.id.private_list_messages) RecyclerView listMessagesRecyclerView;
    @ViewById(R.id.send_chat_message_edit_text) EditText messageEditText;
    ArrayList<String> receiverMessagesArrayList = new ArrayList<>();

    @Extra OrganizationProfile organizationProfile;
    @Extra boolean from;

    int messageCount = 0;
    RecycleViewAdapter adapter;

    @AfterViews
    public void after() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (organizationProfile != null) {
            setTitle(organizationProfile.getOrganization_name());
        }
        adapter = new RecycleViewAdapter();
        adapter.setData(Messages.getListMessages());
        adapter.setRecycleViewRes(R.layout.row_current_chat);
        listMessagesRecyclerView.setAdapter(adapter);
        receiverMessagesArrayList.add("Hello, How can I help you?");
        receiverMessagesArrayList.add("Thanks for contact us, We will reply soon");
        receiverMessagesArrayList.add("Thanks for contact us, We will reply soon");
        receiverMessagesArrayList.add("Thanks for contact us, We will reply soon");
        forceRTLIfSupported();
        if (from) {
            dummyChat();
        }
    }

    public void dummyChat() {
        setTitle(R.string.aisha_institutes);
        ArrayList<Messages> dummyChat = new ArrayList<>();
        dummyChat.add(new Messages("1", "Hello"));
        dummyChat.add(new Messages("2", "Hello, How can I help you?"));
        dummyChat.add(new Messages("1", "I am facing a problem with my family and I need help"));
        dummyChat.add(new Messages("1", "He still hitting me I afraid about me and my children"));
        dummyChat.add(new Messages("2", "ok, don't worry"));
        adapter.setData(dummyChat);
    }

    private void forceRTLIfSupported() {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    @Click(R.id.send_chat_message_ib)
    public void sendMessage() {
        String message = String.valueOf(messageEditText.getText());
        if (TextUtils.isEmpty(messageEditText.getText())) {
            Toast.makeText(this, R.string.write_message, Toast.LENGTH_SHORT).show();
            return;
        }
        Messages.setMessages("1", message);
        adapter.setData(Messages.getListMessages());
        messageEditText.setText("");
        new Handler().postDelayed(() -> {
                    Messages.setMessages("2", receiverMessagesArrayList.get(messageCount));
                    messageCount++;
                    adapter.setData(Messages.getListMessages());
                }
                , 1200);

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
