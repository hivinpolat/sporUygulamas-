package com.example.sporuygulamasi.models.basketball.Adapters;

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
import com.example.sporuygulamasi.models.basketball.BTeams;

import java.util.List;
import static com.example.sporuygulamasi.R.layout.satir_layout;
@SuppressWarnings("deprecation")
public class BasketbolTakimAdaptor extends ArrayAdapter<BTeams> {
    int[]imgs;
    public Context mContext;
    public List<BTeams> takimArrayList;
    public BasketbolTakimAdaptor(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<BTeams> list, int[] imgs)
    {
        super(context,0,list);
        mContext=context;
        takimArrayList = list;
        this.imgs=imgs;
    }
    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View takimArrayListItem=convertView;
        if(takimArrayListItem==null) {
            takimArrayListItem = LayoutInflater.from(mContext).inflate(satir_layout,parent, false);
        }
        BTeams currentTeam=takimArrayList.get(position);
        ImageView image=takimArrayListItem.findViewById(R.id.ivTeam);
        image.setImageResource(imgs[position]);
        TextView takimName = takimArrayListItem.findViewById(R.id.satir_layout_textview_isim);
       // BTeams takim = takimArrayList.get(position);
        takimName.setText(currentTeam.getName());
        return takimArrayListItem;
    }
}
