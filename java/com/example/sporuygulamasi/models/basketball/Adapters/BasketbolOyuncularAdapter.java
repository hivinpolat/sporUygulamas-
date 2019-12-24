package com.example.sporuygulamasi.models.basketball.Adapters;

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
import com.example.sporuygulamasi.models.basketball.BPlayers;
import com.example.sporuygulamasi.models.football.Players;

import java.util.List;

import static com.example.sporuygulamasi.R.layout.satir;
import static com.example.sporuygulamasi.R.layout.satir_layout;

@SuppressWarnings("deprecation")

    public class  BasketbolOyuncularAdapter extends ArrayAdapter<BPlayers> {
        int[]imgs;
        public  Context mContext;
        public List<BPlayers> basketbolcuArrayList;
        public BasketbolOyuncularAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<BPlayers> list, int[] imgs)
        {
            super(context,0,list);
            mContext=context;
            basketbolcuArrayList = list;
            this.imgs=imgs;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View basketbolcuArrayListItem=convertView;
            if(basketbolcuArrayListItem==null) {
                basketbolcuArrayListItem = LayoutInflater.from(mContext).inflate(satir_layout,parent, false);
            }
            BPlayers currentTeam=basketbolcuArrayList.get(position);
            ImageView image=basketbolcuArrayListItem.findViewById(R.id.ivTeam);
            image.setImageResource(imgs[position]);
            TextView takimName = basketbolcuArrayListItem.findViewById(R.id.satir_layout_textview_isim);
            takimName.setText(currentTeam.getName());
            return basketbolcuArrayListItem;
        }
    }