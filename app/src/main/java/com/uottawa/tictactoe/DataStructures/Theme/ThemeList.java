package com.uottawa.tictactoe.DataStructures.Theme;

import android.graphics.Color;

import com.uottawa.tictactoe.R;

import java.util.ArrayList;

public class ThemeList {
    private ArrayList<Theme> theme_list;
    private int position = 0;
    private int imageID;

    public ThemeList(){
        // Purple
        int theme1backgroundId = R.drawable.background1;
        int theme1Color = Color.rgb(255, 36, 226);
        int theme1SampleImage = theme1backgroundId;
        Theme theme1 = new Theme(theme1SampleImage, theme1backgroundId, theme1Color);

        int theme2backgroundId = R.drawable.background2;
        int theme2Color = Color.RED;
        int theme2SampleImage = theme2backgroundId;
        Theme theme2 = new Theme(theme2SampleImage, theme2backgroundId, theme2Color);

        int theme3backgroundId = R.drawable.background3;
        int theme3Color = Color.BLUE;
        int theme3SampleImage = theme3backgroundId;
        Theme theme3 = new Theme(theme3SampleImage, theme3backgroundId, theme3Color);

        theme_list = new ArrayList<Theme>();
        theme_list.add(theme1);
        theme_list.add(theme2);
        theme_list.add(theme3);
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
