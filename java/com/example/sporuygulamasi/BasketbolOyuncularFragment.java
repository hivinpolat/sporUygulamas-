package com.example.sporuygulamasi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.sporuygulamasi.models.basketball.Adapters.BasketbolOyuncularAdapter;
import com.example.sporuygulamasi.models.basketball.BTeams;

import static android.content.Intent.getIntent;

@SuppressWarnings("deprecation")
public class BasketbolOyuncularFragment extends Fragment {
    private ListView listView;


    public BasketbolOyuncularFragment() {
        // Required empty public constructor
    }
    public static BasketbolOyuncularFragment newInstance() {
        BasketbolOyuncularFragment fragment = new BasketbolOyuncularFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basketbol_oyuncular, container, false);
        final BTeams team= (BTeams) getActivity().getIntent().getSerializableExtra("takim");


        listView = view.findViewById(R.id.basketbolcu_listview);
        int []imgs= {R.mipmap.allen, R.mipmap.dirk, R.mipmap.dwyne, R.mipmap.jordan, R.mipmap.kobe, R.mipmap.kyrie, R.mipmap.lebron,
                R.mipmap.kevin, R.mipmap.karl, R.mipmap.shaq, R.mipmap.stephen,R.mipmap.indir};
        BasketbolOyuncularAdapter adapterB = new BasketbolOyuncularAdapter(getActivity(),team.getBasketbolcular(),imgs);//takimdaki oyuncular aliniyor
        listView.setAdapter((ListAdapter) adapterB);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });

        return view;
    }
}
