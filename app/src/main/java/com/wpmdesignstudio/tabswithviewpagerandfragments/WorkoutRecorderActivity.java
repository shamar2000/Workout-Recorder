package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class WorkoutRecorderActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recorder);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        tabLayout = (TabLayout) findViewById(R.id.workout_recorder_activity_tablayout);
        viewPager = (ViewPager) findViewById(R.id.workout_recorder_activity_viewpager);
        toolbar = (Toolbar) findViewById(R.id.workout_recorder_activity_toolbar);

        setSupportActionBar(toolbar);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    /**
     * ViewPager Adapter (FragmentStatePagerAdapter) for the ViewPager
     */

    class ViewPagerAdapter extends FragmentPagerAdapter {

        TrackFragment trackFragment = new TrackFragment();

        private ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return trackFragment;
                case 1:
                    return new HistoryFragment();
                case 2:
                    return new GraphFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "track";
                case 1:
                    return "history";
                case 2:
                    return "graph";
            }
            return super.getPageTitle(position);
        }
    }
}