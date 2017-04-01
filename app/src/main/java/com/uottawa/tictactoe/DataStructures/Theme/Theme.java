package com.uottawa.tictactoe.DataStructures.Theme;

import android.graphics.Color;

import com.uottawa.tictactoe.DataStructures.Avatar.Avatar;

/**
 * Created by alanr on 2017-04-01.
 */

public class Theme {

    Integer sampleImageId;
    Integer backgroundId;
    Integer themeColor;

    public Theme(int sampleImageId, int backgroundId, int themeColor) {
        this.sampleImageId = sampleImageId;
        this.backgroundId = backgroundId;
        this.themeColor = themeColor;
    }

    // We only require the sampleImageId to determine the current theme used on the main screen.
    @Override
    public boolean equals(Object obj) {

        if (getClass() != obj.getClass()) {
            return false;
        }

        Theme data = (Theme) obj;

        if (sampleImageId.equals(data.getSampleImageId())) {
            return true;
        }

        return false;

    }

    public int getSampleImageId() {
        return sampleImageId;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public int getThemeColor() {
        return themeColor;
    }

}
