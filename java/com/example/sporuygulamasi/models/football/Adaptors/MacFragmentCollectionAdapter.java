package com.example.sporuygulamasi.models.football.Adaptors;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sporuygulamasi.FutbolcuFragment;
import com.example.sporuygulamasi.MacFragment;

import java.util.ArrayList;
import java.util.List;

public class MacFragmentCollectionAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitles = new ArrayList<>();
    public MacFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }


    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }


    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitles.add(title);
    }

}

