package com.app.wihack.amina.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.app.wihack.amina.addemergencydata.AddEmergencyDataFragment_;
import com.app.wihack.amina.chatting.ChattingFragment_;
import com.app.wihack.amina.emergency.EmergencyFragment_;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);

        setupViewPager();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    private void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

    private void setupViewPager() {
        addFragment(new ChattingFragment_());
        addFragment(new EmergencyFragment_());


    }

    public int rotatePosition(int position) {
        return (getCount() - 1) - position;
    }

}