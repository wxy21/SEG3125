package com.uottawa.tictactoe.Activity.GameActivities.Multiplayer;

import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid3x3BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid4x4BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid5x5BoardActivity;
import com.uottawa.tictactoe.R;

public class MultiplayerBoardSizeActivity extends BaseActivity{

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
        Intent intent = new Intent(this, Grid3x3BoardActivity.class);
        startActivity(intent);
    }

    public void grid_btn4x4(View view){
        clickSound();
        Intent intent = new Intent(this, Grid4x4BoardActivity.class);
        startActivity(intent);
    }

    public void grid_btn5x5(View view){
        clickSound();
        Intent intent = new Intent(this, Grid5x5BoardActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        clickSound();
        Intent intent = new Intent(this, NameSelectionActivity.class);
        startActivity(intent);
    }
}
