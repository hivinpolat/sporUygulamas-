package com.example.sporuygulamasi.models.basketball.Adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.sporuygulamasi.BasketbolMaclarFragment;
import com.example.sporuygulamasi.BasketbolOyuncularFragment;

import java.util.ArrayList;
import java.util.List;

public class BasketbolFragmentCollectionAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitles = new ArrayList<>();
    public BasketbolFragmentCollectionAdapter(FragmentManager fm) {
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
