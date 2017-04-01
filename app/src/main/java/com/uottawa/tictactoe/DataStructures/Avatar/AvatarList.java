package com.uottawa.tictactoe.DataStructures.Avatar;

import java.util.ArrayList;

import com.uottawa.tictactoe.R;
/**
 * Created by user on 2017-03-29.
 */

public class AvatarList {

    private ArrayList<Avatar> avatar_list;
    private int position = 0;
    private int imageID;

    public AvatarList(){
        avatar_list = new ArrayList<>();
        avatar_list.add(new Avatar(R.drawable.avatar1));
        avatar_list.add(new Avatar(R.drawable.avatar2));
        avatar_list.add(new Avatar(R.drawable.avatar3));
    }


    public ArrayList<Avatar> getAvatarList(){
        return avatar_list;
    }


    public void setAvatar(int avatar_position){
        position = avatar_position;
    }

    public int getPosition(){
        return position;
    }

    public int getImageID(){
        imageID = getAvatarList().get(position).getImageId();
        return imageID;
    }

}
