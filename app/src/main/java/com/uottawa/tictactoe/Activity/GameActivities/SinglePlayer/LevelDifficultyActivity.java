package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid3x3BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid5x5BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid4x4BoardActivity;
import com.uottawa.tictactoe.R;

public class LevelDifficultyActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_level_difficulty);

    }

    public void btn_easy(View view){
        Intent intent = new Intent(this, Grid3x3BoardActivity.class);
        startActivity(intent);
    }

    public void btn_medium(View view){
        Intent intent = new Intent(this, Grid4x4BoardActivity.class);
        startActivity(intent);
    }

    public void btn_hard(View view){
        Intent intent = new Intent(this, Grid5x5BoardActivity.class);
        startActivity(intent);
    }
}
