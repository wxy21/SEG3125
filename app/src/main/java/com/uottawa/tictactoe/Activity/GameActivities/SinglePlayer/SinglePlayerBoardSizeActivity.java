package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class SinglePlayerBoardSizeActivity extends BaseActivity {

    @Override
    protected void loadView() {
        content = R.id.content_grid_size;
        setContentView(R.layout.activity_grid_size);
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_grid_size;
        textViews.add((TextView) findViewById(R.id.grid_size_title));
        buttons.add((Button) findViewById(R.id.grid_size_btn_3x3));
        buttons.add((Button) findViewById(R.id.grid_size_btn_4x4));
        buttons.add((Button) findViewById(R.id.grid_size_btn_5x5));
    }

    public void grid_btn3x3(View view){
        clickSound();
        applicationSettings.saveBoardSize(3);
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

    public void grid_btn4x4(View view){
        clickSound();
        applicationSettings.saveBoardSize(4);
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

    public void grid_btn5x5(View view){
        clickSound();
        applicationSettings.saveBoardSize(5);
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

}
