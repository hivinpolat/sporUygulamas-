package com.example.sporuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sporuygulamasi.UtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.football.Adaptors.Adaptor;
import com.example.sporuygulamasi.models.football.Teams;

import java.io.ByteArrayOutputStream;

public class FutbolTakimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futbol_takim);

        final int []imgs={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h,R.mipmap.k,
                R.mipmap.l,R.mipmap.m,R.mipmap.n,R.mipmap.o,R.mipmap.p,R.mipmap.r,R.mipmap.s,R.mipmap.t,R.mipmap.y};
        ListView lvTakim = (ListView) findViewById(R.id.takim_activity_listview);//view olusturuluyor
        Adaptor adapter = new Adaptor(FutbolTakimActivity.this, UtilMethods.teams,imgs);//adapdet da kul.parametreler gonderiliyor
        lvTakim.setAdapter(adapter);
        lvTakim.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Teams takim = UtilMethods.teams.get(i);
                int[] image=imgs;
                Intent intent = new Intent(FutbolTakimActivity.this, FutbolActivity.class);
                intent.putExtra("takim", takim);
                intent.putExtra("team",image);

                startActivity(intent);
            }

        });
    }
    }

