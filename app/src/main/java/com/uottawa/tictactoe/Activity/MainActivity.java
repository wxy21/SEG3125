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


    private MediaPlayer background_music;
    private String background_music_command;
    private int musicVolume;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_main);
        //backgroundMusic();
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

    protected void backgroundMusic(){
        background_music = MediaPlayer.create(this, R.raw.background_music);
        background_music_command = applicationSettings.getBackgroundMusicCommand();
        musicVolume = applicationSettings.getMusicVolume();

        if(background_music_command == "start"){
            background_music.setVolume(musicVolume, musicVolume);
            background_music.setLooping(true);
            background_music.start();
        }else if (background_music_command == "stop"){
            background_music.stop();
            background_music.release();
        }
    }
    public void btnSinglePlayer(View view){
        Intent intent = new Intent(this, SinglePlayerBoardSizeActivity.class);
        startActivity(intent);
    }

    public void btnMultiPlayer(View view){
        Intent intent = new Intent(this, NameSelectionActivity.class);
        startActivity(intent);
    }

    public void btnMatchHistory(View view){
        Intent intent = new Intent(this, MatchHistoryActivity.class);
        startActivity(intent);
    }

    public void btnOption(View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void btnRule(View view){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
    }
}
