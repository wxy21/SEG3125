package com.uottawa.tictactoe.DataStructures.Theme;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.uottawa.tictactoe.R;

import java.util.ArrayList;

public class ThemeSpinnerAdapter extends ArrayAdapter<Theme> {

    int groupid;
    ArrayList<Theme> list;
    LayoutInflater inflater;

    public ThemeSpinnerAdapter(Activity context, int groupid, ArrayList<Theme> list){
        super(context, groupid, list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View itemView=inflater.inflate(groupid,parent,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.img);
        imageView.setImageResource(list.get(position).getSampleImageId());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }
}
