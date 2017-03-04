package com.jxnu.cic.fragment;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mfrag;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> mfrag) {
        super(fm);
        this.mfrag = mfrag;
    }

    @Override
    public int getCount() {
        return mfrag.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        return mfrag.get(arg0);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
