package com.example.sporuygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.sporuygulamasi.models.basketball.Adapters.BasketbolFragmentCollectionAdapter;
import com.example.sporuygulamasi.models.basketball.BTeams;
import com.google.android.material.tabs.TabLayout;
@SuppressWarnings("deprecation")
public class BasketbolActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TableLayout tableLayout;
    private ImageView imageView;
    private BasketbolFragmentCollectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketbol);

        // Intent intent=getIntent();
        final BTeams team = (BTeams) getIntent().getSerializableExtra("takim");
        // getSupportActionBar().setTitle(team.getName());

        imageView = (ImageView) findViewById(R.id.takim_resim);
        Bundle b = getIntent().getExtras();

     // imageView=  b.get("IMAGE");



            viewPager = (ViewPager) findViewById(R.id.pager);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

            BasketbolFragmentCollectionAdapter adapter = new BasketbolFragmentCollectionAdapter(getSupportFragmentManager());
            adapter.addFragment(BasketbolMaclarFragment.newInstance(), "Maclar");
            adapter.addFragment(BasketbolOyuncularFragment.newInstance(), "Oyuncular");
            viewPager.setAdapter(adapter);

            tabLayout.setupWithViewPager(viewPager);

        }
    }

