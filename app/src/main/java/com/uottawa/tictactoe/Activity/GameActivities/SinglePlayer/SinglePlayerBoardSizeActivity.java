package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.RulesActivity;
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

    public void btn_grid(View view){
        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

}
