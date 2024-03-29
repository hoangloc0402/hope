package com.sunset.hope.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunset.hope.R;
import com.sunset.hope.activities.ActivityPost;
import com.sunset.hope.adapters.AdapterMainTab;

public class FragmentMain  extends Fragment {
    View myView;
    FloatingActionButton fab;
    public FragmentMain(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView =  inflater.inflate(R.layout.fragment_main, container, false);
        TabLayout tabLayout = myView.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Donate"));
        tabLayout.addTab(tabLayout.newTab().setText("Request"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) myView.findViewById(R.id.pager);

        final AdapterMainTab adapter = new AdapterMainTab (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        fab = myView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityPost.class);
                startActivity(intent);
            }
        });

        return myView;
    }

}


