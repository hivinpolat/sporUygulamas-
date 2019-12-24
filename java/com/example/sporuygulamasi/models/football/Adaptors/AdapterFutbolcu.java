package com.example.sporuygulamasi.models.football.Adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.sporuygulamasi.R;
import com.example.sporuygulamasi.models.football.Players;
import com.example.sporuygulamasi.models.football.Teams;

import java.util.List;

import static com.example.sporuygulamasi.R.layout.satir;

public class AdapterFutbolcu extends ArrayAdapter<Players> {
    int[]imgs;
    public  Context mContext;
    public List<Players> futbolcuArrayList;
    public AdapterFutbolcu(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<Players> list, int[] imgs)
    {
        super(context,0,list);
        mContext=context;
        futbolcuArrayList = list;
        this.imgs=imgs;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View futbolcuArrayListItem=convertView;
        if(futbolcuArrayListItem==null) {
            futbolcuArrayListItem = LayoutInflater.from(mContext).inflate(satir,parent, false);
        }
        Players currentTeam=futbolcuArrayList.get(position);
        ImageView image=futbolcuArrayListItem.findViewById(R.id.ivTeam);
        image.setImageResource(imgs[position]);
        TextView takimName = futbolcuArrayListItem.findViewById(R.id.satir_textview_isim);
        //Teams takim = takimArrayList.get(position);
        takimName.setText(currentTeam.getName());
        return futbolcuArrayListItem;
    }
}