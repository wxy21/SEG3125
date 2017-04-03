package com.uottawa.tictactoe.DataStructures.Theme;

import android.graphics.Color;

import com.uottawa.tictactoe.R;

import java.util.ArrayList;

public class ThemeList {
    private ArrayList<Theme> theme_list;
    private int position = 0;
    private int imageID;

    public ThemeList(){
        int theme1backgroundId = R.drawable.background1;
        int theme1Color = Color.rgb(255, 36, 226); //Purple
        int theme1SampleImage = R.drawable.background1sample;
        Theme theme1 = new Theme(theme1SampleImage, theme1backgroundId, theme1Color);

        int theme2backgroundId = R.drawable.background2;
        int theme2Color = Color.RED;
        int theme2SampleImage = R.drawable.background2sample;
        Theme theme2 = new Theme(theme2SampleImage, theme2backgroundId, theme2Color);

        int theme3backgroundId = R.drawable.background3;
        int theme3Color = Color.rgb(128,128,128); // Gray
        int theme3SampleImage = R.drawable.background3sample;
        Theme theme3 = new Theme(theme3SampleImage, theme3backgroundId, theme3Color);

        int theme4backgroundId = R.drawable.background4;
        int theme4Color = Color.rgb(102,153,0); // holo_green_light
        int theme4SampleImage = R.drawable.background4sample;
        Theme theme4 = new Theme(theme4SampleImage, theme4backgroundId, theme4Color);

        theme_list = new ArrayList<Theme>();
        theme_list.add(theme1);
        theme_list.add(theme2);
        theme_list.add(theme3);
        theme_list.add(theme4);
    }

    public ArrayList<Theme> getThemeList(){
        return theme_list;
    }

    public void setTheme(int theme_position){
        position = theme_position;
    }

    public int getPosition(){
        return position;
    }

    public int getSampleImageId(){
        imageID = theme_list.get(position).getSampleImageId();
        return imageID;
    }
}
