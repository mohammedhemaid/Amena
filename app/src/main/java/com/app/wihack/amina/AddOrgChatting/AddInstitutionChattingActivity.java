package com.app.wihack.amina.AddOrgChatting;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wihack.amina.R;
import com.app.wihack.amina.chatting.OrganizationProfile;
import com.app.wihack.amina.commonAdapter.RecycleViewAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_add_org_chatting)
public class AddInstitutionChattingActivity extends AppCompatActivity {

    @ViewById(R.id.institutes_list) RecyclerView institutesListRecyclerView;
    RecycleViewAdapter adapter;

    @AfterViews
    public void after() {
        setTitle(R.string.choose_institution);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        OrganizationProfile.setContext(this);
        adapter = new RecycleViewAdapter();
        adapter.setData(OrganizationProfile.getOrganizationProfiles());
        adapter.setRecycleViewRes(R.layout.row_institution);
        institutesListRecyclerView.setAdapter(adapter);
        forceRTLIfSupported();
    }

    private void forceRTLIfSupported() {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
