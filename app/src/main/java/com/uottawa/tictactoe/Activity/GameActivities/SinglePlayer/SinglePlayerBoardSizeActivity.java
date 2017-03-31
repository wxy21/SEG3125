package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class SinglePlayerBoardSizeActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_grid_size);
    }

    public void grid_btn3x3(View view){
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

    public void grid_btn4x4(View view){
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

    public void grid_btn5x5(View view){
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

}
