package com.uottawa.tictactoe.DataStructures.Avatar;

public class Avatar {

    Integer imageId;

    public Avatar(Integer imageId){
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

        Avatar data = (Avatar) obj;

        if (imageId.equals(data.getImageId())) {
            return true;
        }

        return false;

    }
}
