package com.uottawa.tictactoe.DataStructures;

public class ItemData {

    Integer imageId;

    public ItemData(Integer imageId){
        this.imageId=imageId;
    }


    public Integer getImageId(){
        return imageId;
    }

    @Override
    public boolean equals(Object obj) {

        if (getClass() != obj.getClass()) {
            return false;
        }

        ItemData data = (ItemData) obj;

        if (imageId.equals(data.getImageId())) {
            return true;
        }

        return false;

    }
}
