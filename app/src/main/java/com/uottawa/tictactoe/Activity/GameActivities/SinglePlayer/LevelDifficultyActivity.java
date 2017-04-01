package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.EasyGameActivity;
import com.uottawa.tictactoe.Activity.GameActivities.HardGameActivity;
import com.uottawa.tictactoe.Activity.GameActivities.MediumGameActivity;
import com.uottawa.tictactoe.R;

public class LevelDifficultyActivity extends BaseActivity {

    @Override
    protected void loadView() {
        content = R.id.content_level_difficulty;
        setContentView(R.layout.activity_level_difficulty);
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_level_difficulty;
        textViews.add((TextView) findViewById(R.id.levelDifficulty_title));
        buttons.add((Button) findViewById(R.id.levelDifficulty_btnEasy));
        buttons.add((Button) findViewById(R.id.levelDifficulty_btnMedium));
        buttons.add((Button) findViewById(R.id.levelDifficulty_btnHard));
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
