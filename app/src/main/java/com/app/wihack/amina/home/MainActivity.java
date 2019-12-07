package com.app.wihack.amina.home;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;

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
        setTitle(R.string.emergency);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(2);
        bottomNavigationHandler();
        forceRTLIfSupported();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void forceRTLIfSupported() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
    }

    private void bottomNavigationHandler() {
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.emergency_call:
                viewPager.setCurrentItem(viewPagerAdapter.rotatePosition(0));
                setTitle(R.string.emergency);
                return true;
            case R.id.chatting:
                viewPager.setCurrentItem(viewPagerAdapter.rotatePosition(1));
                setTitle(R.string.chatting);
                return true;
            case R.id.profile:
                viewPager.setCurrentItem(viewPagerAdapter.rotatePosition(2));
                setTitle(R.string.profile);
                return true;
        }
        return false;
    }
}
