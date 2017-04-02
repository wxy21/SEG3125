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

    private static MediaPlayer click_sound;
    private  int soundVolume;
    private String click_sound_command;
    private float soundVolumeFloat;

    @Override
    protected void loadView() {
        content = R.id.content_grid_size;
        setContentView(R.layout.activity_grid_size);
        soundVolume = applicationSettings.getSoundVolume();
        click_sound_command = applicationSettings.getClickSoundCommand();
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_grid_size;
        textViews.add((TextView) findViewById(R.id.grid_size_title));
        buttons.add((Button) findViewById(R.id.grid_size_btn_3x3));
        buttons.add((Button) findViewById(R.id.grid_size_btn_4x4));
        buttons.add((Button) findViewById(R.id.grid_size_btn_5x5));
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
}
