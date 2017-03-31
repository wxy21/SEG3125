package com.uottawa.tictactoe;

import java.util.ArrayList;

/**
 * Created by user on 2017-03-30.
 */

public class ThemeList {
    private ArrayList<ItemData> theme_list;
    private int position = 0;
    private int imageID;

    public ThemeList(){
        theme_list = new ArrayList<>();
        theme_list.add(new ItemData(R.drawable.background1));
        theme_list.add(new ItemData(R.drawable.background2));
        theme_list.add(new ItemData(R.drawable.background3));
    }

    public ArrayList<ItemData> getThemeList(){
        return theme_list;
    }


    public void setTheme(int theme_position){
        position = theme_position;
    }

    public int getPosition(){
        return position;
    }

    public int getImageID(){
        imageID = theme_list.get(position).getImageId();
        return imageID;
    }
}
