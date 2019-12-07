package com.app.wihack.amina.home;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.app.wihack.amina.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @ViewById(R.id.view_pager) ViewPager viewPager;
    @ViewById(R.id.navigation) BottomNavigationView bottomNavigation;

    ViewPagerAdapter viewPagerAdapter;

    @AfterViews
    public void after() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
        bottomNavigationHandler();

    }

    private void bottomNavigationHandler() {
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.emergency_call:
                viewPager.setCurrentItem(viewPagerAdapter.rotatePosition(0));
                return true;
            case R.id.chatting:
                viewPager.setCurrentItem(viewPagerAdapter.rotatePosition(2));
                return true;
        }
        return false;
    }
}
