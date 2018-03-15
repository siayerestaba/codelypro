package com.codely.pro.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codely.pro.R;
import com.codely.pro.fragments.AboutFragment;
import com.codely.pro.fragments.PathFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        initTabs();
    }

    private void initTabs() {
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("About"));
        tabs.addTab(tabs.newTab().setText("Path"));

        ViewPager vpPager = findViewById(R.id.card_pager);
        TabsPagerAdapter adapterViewPager = new TabsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        tabs.setupWithViewPager(vpPager);
    }

    public class TabsPagerAdapter extends FragmentPagerAdapter {
        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {
            switch (index) {
                case 0:
                    AboutFragment aboutFragment = new AboutFragment();
                    return aboutFragment;
                case 1:
                    PathFragment pathFragment = new PathFragment();
                    return pathFragment;
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "About";
                case 1:
                    return "Path";
            }

            return "";
        }

        @Override
        public int getCount() {
            // get item count - equal to number of slides
            return 2;
        }
    }
}
