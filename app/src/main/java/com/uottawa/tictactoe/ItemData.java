package com.uottawa.tictactoe;

/**
 * Created by user on 2017-03-27.
 */

public class ItemData {

    String text;
    Integer imageId;
    public ItemData(Integer imageId){
        this.imageId=imageId;
    }


    public Integer getImageId(){
        return imageId;
    }
}
