package com.example.sporuygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.sporuygulamasi.models.basketball.BTeams;
import com.example.sporuygulamasi.models.football.Adaptors.MacFragmentCollectionAdapter;
import com.example.sporuygulamasi.models.football.Teams;
import com.google.android.material.tabs.TabLayout;

public class FutbolActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TableLayout tableLayout;
    private  ImageView imageView;
    private MacFragmentCollectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futbol);

        final Teams team= (Teams) getIntent().getSerializableExtra("takim");
       //getSupportActionBar().setTitle(team.getName());




        viewPager= (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        MacFragmentCollectionAdapter adapter = new MacFragmentCollectionAdapter(getSupportFragmentManager());
        adapter.addFragment(MacFragment.newInstance() , "Maclar");
        adapter.addFragment(FutbolcuFragment.newInstance(),"Oyuncular");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

}

