package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorkoutRecorderActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recorder);
        initXML();
        setupTabs();
    }

    private void setupTabs() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initXML() {
        tabLayout = (TabLayout) findViewById(R.id.workout_recorder_activity_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.workout_recorder_activity_viewpager);
        toolbar = (Toolbar) findViewById(R.id.workout_recorder_activity_toolbar);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
    }

    /**
     * ViewPager Adapter (FragmentStatePagerAdapter) for the ViewPager
     */

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new TestFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Title 1";
                case 1:
                    return "Title 2";
                case 2:
                    return "Title 3";
            }
            return super.getPageTitle(position);
        }
    }
}