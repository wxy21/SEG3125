package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.uottawa.tictactoe.Activity.GameActivities.Multiplayer.NameSelectionActivity;
import com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer.SinglePlayerBoardSizeActivity;
import com.uottawa.tictactoe.R;

public class MainActivity extends BaseActivity {

    private static MediaPlayer click_sound;
    private  int soundVolume;
    private String click_sound_command;
    private float soundVolumeFloat;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_main);
        soundVolume = applicationSettings.getSoundVolume();
        click_sound_command = applicationSettings.getClickSoundCommand();

    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_main;
        buttons.add((Button) findViewById(R.id.main_single_player));
        buttons.add((Button) findViewById(R.id.main_multiplayer));
        buttons.add((Button) findViewById(R.id.main_match_history));
        buttons.add((Button) findViewById(R.id.main_rules));
        buttons.add((Button) findViewById(R.id.main_options));
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

    public void btnSinglePlayer(View view){
        clickSound();
        Intent intent = new Intent(this, SinglePlayerBoardSizeActivity.class);
        startActivity(intent);
    }

    public void btnMultiPlayer(View view){
        clickSound();
        Intent intent = new Intent(this, NameSelectionActivity.class);
        startActivity(intent);
    }

    public void btnMatchHistory(View view){
        clickSound();
        Intent intent = new Intent(this, MatchHistoryActivity.class);
        startActivity(intent);
    }

    public void btnOption(View view){
        clickSound();
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void btnRule(View view){
        clickSound();
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
    }
}
