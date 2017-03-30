package com.uottawa.tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;

import com.uottawa.tictactoe.SpinnerAdapter;
import com.uottawa.tictactoe.R;
/**
 * Created by user on 2017-03-29.
 */

public class AvatarList {


    public static ArrayList<ItemData> getAvatarList() {

        ArrayList<ItemData> avatar_list = new ArrayList<>();

        avatar_list.add(new ItemData(R.drawable.avatar1));
        avatar_list.add(new ItemData(R.drawable.avatar2));
        avatar_list.add(new ItemData(R.drawable.avatar3));
        return avatar_list;
    }


    public int setAvatar(int position){
        return position;
    }
}
