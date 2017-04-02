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
import com.uottawa.tictactoe.R;

public class LevelDifficultyActivity extends BaseActivity {

    private static MediaPlayer click_sound;
    private  int soundVolume;
    private String click_sound_command;
    private float soundVolumeFloat;

    @Override
    protected void loadView() {
        content = R.id.content_level_difficulty;
        setContentView(R.layout.activity_level_difficulty);
        soundVolume = applicationSettings.getSoundVolume();
        click_sound_command = applicationSettings.getClickSoundCommand();
    }

    private void clickSound() {
        if (click_sound == null)
            click_sound = MediaPlayer.create(this, R.raw.button_sound);

        soundVolumeFloat = (float)(1 - (Math.log(100 - soundVolume)/Math.log(100)));

        if (click_sound_command.equals("start") && !click_sound.isPlaying()) {
            click_sound.setVolume(soundVolumeFloat, soundVolumeFloat);
            click_sound.start();
        } else if (click_sound_command.equals("start") && click_sound.isPlaying()) {
            click_sound.setVolume(soundVolumeFloat, soundVolumeFloat);
        } else if (click_sound_command.equals("stop") && click_sound.isPlaying()) {
            click_sound.stop();
            click_sound.release();
            click_sound = null;
        }
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
}
