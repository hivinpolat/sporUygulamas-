package com.example.sporuygulamasi.models.football.Adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.sporuygulamasi.R;
import com.example.sporuygulamasi.models.football.Teams;
import static com.example.sporuygulamasi.R.layout.satir;
import java.util.List;

public class Adaptor extends ArrayAdapter<Teams> {
    int[]imgs;
    public  Context mContext;
    public List<Teams> takimArrayList;
    public Adaptor(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<Teams> list, int[] imgs)
    {
        super(context,0,list);
        mContext=context;
        takimArrayList = list;
        this.imgs=imgs;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View takimArrayListItem=convertView;
        if(takimArrayListItem==null) {
            takimArrayListItem = LayoutInflater.from(mContext).inflate(satir,parent, false);
        }
        Teams currentTeam=takimArrayList.get(position);
        ImageView image=takimArrayListItem.findViewById(R.id.ivTeam);
        image.setImageResource(imgs[position]);
        TextView takimName = takimArrayListItem.findViewById(R.id.satir_textview_isim);
        //Teams takim = takimArrayList.get(position);
        takimName.setText(currentTeam.getName());
        return takimArrayListItem;
    }
}

