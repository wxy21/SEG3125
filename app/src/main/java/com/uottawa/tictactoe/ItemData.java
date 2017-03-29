package com.uottawa.tictactoe;

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
