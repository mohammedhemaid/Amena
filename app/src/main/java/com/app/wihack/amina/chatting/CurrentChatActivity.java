package com.app.wihack.amina.chatting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.commonAdapter.RecycleViewAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_current_chat)
public class CurrentChatActivity extends AppCompatActivity {

    @ViewById(R.id.private_list_messages) RecyclerView listMessagesRecyclerView;

    RecycleViewAdapter adapter;

    @AfterViews
    public void after() {
        adapter = new RecycleViewAdapter();
        adapter.setData(Messages.getListMessages());
        adapter.setRecycleViewRes(R.layout.row_current_chat);
        listMessagesRecyclerView.setAdapter(adapter);
    }
}
