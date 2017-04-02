package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid3x3BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid5x5BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Grid4x4BoardActivity;
import com.uottawa.tictactoe.Activity.GameActivities.Multiplayer.NameSelectionActivity;
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
        clickSound();
        applicationSettings.saveBotDiffuculty(1);
        moveToNextActivity();
    }

    public void btn_medium(View view){
        clickSound();
        applicationSettings.saveBotDiffuculty(2);
        moveToNextActivity();
    }

    public void btn_hard(View view){
        clickSound();
        applicationSettings.saveBotDiffuculty(3);
        moveToNextActivity();
    }

    public void moveToNextActivity() {
        Intent intent = new Intent(this, Grid3x3BoardActivity.class); // Filler
        if (applicationSettings.getBoardSize() <= 3) intent = new Intent(this, Grid3x3BoardActivity.class);
        else if (applicationSettings.getBoardSize() == 4) intent = new Intent(this, Grid4x4BoardActivity.class);
        else if (applicationSettings.getBoardSize() >= 5) intent = new Intent(this, Grid5x5BoardActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        clickSound();
        Intent intent = new Intent(this, SinglePlayerBoardSizeActivity.class);
        startActivity(intent);
    }
}
