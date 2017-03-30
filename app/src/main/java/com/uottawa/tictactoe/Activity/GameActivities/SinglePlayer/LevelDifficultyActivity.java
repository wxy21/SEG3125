package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.EasyGameActivity;
import com.uottawa.tictactoe.Activity.GameActivities.HardGameActivity;
import com.uottawa.tictactoe.Activity.GameActivities.MediumGameActivity;
import com.uottawa.tictactoe.R;

public class LevelDifficultyActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_level_difficulty);

    }

    public void btn_easy(View view){
        Intent intent = new Intent(this, EasyGameActivity.class);
        startActivity(intent);
    }

    public void btn_medium(View view){
        Intent intent = new Intent(this, MediumGameActivity.class);
        startActivity(intent);
    }

    public void btn_hard(View view){
        Intent intent = new Intent(this, HardGameActivity.class);
        startActivity(intent);
    }
}
