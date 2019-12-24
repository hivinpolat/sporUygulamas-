package com.example.sporuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;

import com.example.sporuygulamasi.models.basketball.Adapters.BasketbolTakimAdaptor;
import com.example.sporuygulamasi.models.basketball.BTeams;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
@SuppressWarnings("deprecation")
public class BasketbolTakimActivity extends AppCompatActivity {
private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketbol_takim);

        final int []imgs={R.mipmap.lakers,R.mipmap.golden,R.mipmap.housten,R.mipmap.toronto,R.mipmap.boston,R.mipmap.dallas,R.mipmap.clippers,R.mipmap.miami,R.mipmap.milwaukee,
                R.mipmap.sanantonio,R.mipmap.philadelphia,R.mipmap.newyork,R.mipmap.chicago,R.mipmap.portland,R.mipmap.neworleans,R.mipmap.utah,R.mipmap.denver,R.mipmap.brooklyn};
        ListView lvTakim = findViewById(R.id.takim_activity_listview);//view olusturuluyor
        BasketbolTakimAdaptor adapter = new BasketbolTakimAdaptor(BasketbolTakimActivity.this, UtilMethods.teams,imgs);//adapdet da kul.parametreler gonderiliyor
        lvTakim.setAdapter(adapter);
        lvTakim.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BTeams takim= UtilMethods.teams.get(i);
                int image = R.drawable.imageinquestion;
                Intent intent=new Intent(BasketbolTakimActivity.this, BasketbolActivity.class);
                intent.putExtra("takim",takim);
                intent.putExtra("IMAGE",image);

                startActivity(intent);
            }
        });
    }
}