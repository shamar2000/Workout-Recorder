package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class WorkoutRecorderActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recorder);

        Bundle bundle = getIntent().getExtras();
        String exerciseName = bundle.getString("EXERCISE_NAME");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        tabLayout = (TabLayout) findViewById(R.id.workout_recorder_activity_tablayout);
        viewPager = (ViewPager) findViewById(R.id.workout_recorder_activity_viewpager);
        toolbar = (Toolbar) findViewById(R.id.workout_recorder_activity_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(exerciseName);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    /**
     * ViewPager Adapter (FragmentStatePagerAdapter) for the ViewPager
     */

    class ViewPagerAdapter extends FragmentPagerAdapter {

        TrackTabFragment trackTabFragment = new TrackTabFragment();

        private ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return trackTabFragment;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.menu.menu_done:
                // Get reps and weight from TrackTabFragment and pass it to
                // WorkoutInformation and record the info.
        }

        return true;
    }
}