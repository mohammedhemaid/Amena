package com.app.wihack.amina.chatting;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wihack.amina.AddOrgChatting.AddInstitutionChattingActivity_;
import com.app.wihack.amina.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_chatting)
public class ChattingFragment extends Fragment {
    @ViewById(R.id.chatting_list) RecyclerView institutesListRecyclerView;

    RecycleViewAdapter adapter;

    public ChattingFragment() {
        // Required empty public constructor
    }


    @AfterViews
    public void after() {
        adapter = new RecycleViewAdapter();
        adapter.setData(new ArrayList<>());
        adapter.setRecycleViewRes(R.layout.institution_row);
        institutesListRecyclerView.setAdapter(adapter);
    }

    @Click(R.id.add_org_to_chat)
    public void navToAddChatGroup() {
        AddInstitutionChattingActivity_.intent(getContext()).start();
    }
}
