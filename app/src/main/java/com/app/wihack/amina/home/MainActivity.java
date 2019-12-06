package com.app.wihack.amina.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.app.wihack.amina.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.view_pager) ViewPager viewPager;
    @ViewById(R.id.navigation) BottomNavigationView navigationButtom;

    @AfterViews
    public void after() {


    }
}
