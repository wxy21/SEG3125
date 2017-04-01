package com.uottawa.tictactoe.DataStructures.Avatar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.uottawa.tictactoe.R;

import java.util.ArrayList;

public class AvatarSpinnerAdapter extends ArrayAdapter<Avatar> {
    int groupid;
    ArrayList<Avatar> list;
    LayoutInflater inflater;

    public AvatarSpinnerAdapter(Activity context, int groupid, ArrayList<Avatar> list){
        super(context, groupid, list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View itemView=inflater.inflate(groupid,parent,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.img);
        imageView.setImageResource(list.get(position).getImageId());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);

    }
}