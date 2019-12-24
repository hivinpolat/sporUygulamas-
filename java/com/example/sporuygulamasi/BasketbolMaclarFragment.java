package com.example.sporuygulamasi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.basketball.BMatch;
import com.example.sporuygulamasi.models.basketball.BTeams;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class BasketbolMaclarFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<BMatch> arrayAdapter;



    public BasketbolMaclarFragment() {
        Log.i("Hivin", "Fragment One Oluşturuldu");
    }
    public static BasketbolMaclarFragment newInstance() {
        BasketbolMaclarFragment fragment = new BasketbolMaclarFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basketbol_maclar, container, false);
        //final Teams team = (Teams) getArguments().getSerializable("team");
        final BTeams team= (BTeams) getActivity().getIntent().getSerializableExtra("takim");
        listView = view.findViewById(R.id.mac_listview);
        show(team);

        return view;

    }
    public void show(BTeams team){
        List<BMatch> takimMaclari =new ArrayList<>();
        for (int i = 1; i <= 34; i++) {
            List<BMatch> macList = UtilMethods.fixture.get(i);

            for (BMatch match : macList) {
                if (team.getName().equals(match.getHomeTeam().getName()) ||
                        team.getName().equals(match.getAwayTeam().getName())) {
                    takimMaclari.add(match);
                    Log.i("---", match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
                    break;
                }
            }
        }
      arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, takimMaclari);
       // listView.setAdapter(arrayAdapter);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.setAdapter(arrayAdapter);

    }
}
