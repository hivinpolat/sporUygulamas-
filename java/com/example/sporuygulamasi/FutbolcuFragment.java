package com.example.sporuygulamasi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sporuygulamasi.models.football.Adaptors.AdapterFutbolcu;
import com.example.sporuygulamasi.models.football.Teams;

public  class FutbolcuFragment extends Fragment {
    private ListView listView;


    public FutbolcuFragment() {
        // Required empty public constructor
    }
    public static FutbolcuFragment newInstance() {
        FutbolcuFragment fragment = new FutbolcuFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_futbolcu, container, false);
        final Teams team= (Teams) getActivity().getIntent().getSerializableExtra("takim");
        listView = view.findViewById(R.id.futbolcu_listview);
        int []imgs= {R.mipmap.apdul, R.mipmap.arda, R.mipmap.burak, R.mipmap.caglar, R.mipmap.cengiz, R.mipmap.cenk, R.mipmap.emre,
                R.mipmap.emree,
                R.mipmap.emreee, R.mipmap.enes, R.mipmap.hakan, R.mipmap.kaan, R.mipmap.merih, R.mipmap.mesut, R.mipmap.nuri,
                R.mipmap.okay, R.mipmap.omer, R.mipmap.ozan,R.mipmap.yunus,R.mipmap.yusuf,R.mipmap.zeki,R.mipmap.yildirim,
                R.mipmap.salih,R.mipmap.semih,R.mipmap.zeki};
        AdapterFutbolcu adapterF = new AdapterFutbolcu(getActivity(),team.getPlayerss(),imgs);//takimdaki oyuncular aliniyor
        listView.setAdapter(adapterF);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        return view;
    }
}


