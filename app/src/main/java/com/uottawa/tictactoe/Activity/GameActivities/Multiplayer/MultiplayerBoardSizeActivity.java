package com.uottawa.tictactoe.Activity.GameActivities.Multiplayer;

import android.content.Intent;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid3x3BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid4x4BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid5x5BoardActivity;
import com.uottawa.tictactoe.R;

/**
 * Created by user on 2017-03-31.
 */

public class MultiPlayerBoardSizeActivity extends BaseActivity{
    @Override
    protected void loadView() {
        setContentView(R.layout.activity_grid_size);
    }

    public void grid_btn3x3(View view){
        Intent intent = new Intent(this, Grid3x3BoardActivity.class);
        startActivity(intent);
    }

    public void grid_btn4x4(View view){
        Intent intent = new Intent(this, Grid4x4BoardActivity.class);
        startActivity(intent);
    }

    public void grid_btn5x5(View view){
        Intent intent = new Intent(this, Grid5x5BoardActivity.class);
        startActivity(intent);
    }
}
