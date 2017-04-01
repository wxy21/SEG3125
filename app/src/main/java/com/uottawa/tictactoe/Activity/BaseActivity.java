package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.uottawa.tictactoe.DataStorage.ApplicationSettings;
import com.uottawa.tictactoe.DataStorage.MatchHistory;
import com.uottawa.tictactoe.R;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    String keySharedPreference = "sharedPreference";

    protected int content;
    protected List<Button> buttons;
    protected List<TextView> textViews;
    protected ApplicationSettings applicationSettings;
    protected MatchHistory matchHistory;

    private AppCompatDelegate mDelegate;

    private MediaPlayer background_music;
    private String background_music_command;
    private int musicVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences(keySharedPreference, MODE_PRIVATE);
        applicationSettings = new ApplicationSettings(settings);
        applicationSettings.loadSettings();

        matchHistory = new MatchHistory(settings);
        matchHistory.loadMatches();

        buttons = new LinkedList<Button>();
        textViews = new LinkedList<TextView>();

        loadView();
        collectThemeElements();
        changeTheme();
        backgroundMusic();
    }

    protected abstract void loadView();


    protected void collectThemeElements(){};

    public void changeTheme() {
        
        int backgroundImage = applicationSettings.getTheme().getBackgroundId();
        int color = applicationSettings.getTheme().getThemeColor();

        // Change the background
        RelativeLayout background = (RelativeLayout) findViewById(content);
        if(background != null) {
            background.setBackground(ContextCompat.getDrawable(getApplicationContext(), backgroundImage));
        }

        // Change the buttons
        for (Button button : buttons) {
            if (button != null) {
                button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                button.setTextColor(Color.WHITE);
                button.invalidate();
            }
        }

        // Change the text
        for (TextView textView : textViews) {
            if (textView != null) {
                textView.setTextColor(color);
            }
        }
    }

   private void backgroundMusic(){
        background_music = MediaPlayer.create(this, R.raw.background_music);
        background_music_command = applicationSettings.getBackgroundMusicCommand();
        musicVolume = applicationSettings.getMusicVolume();

        if(background_music_command == "start"){
            background_music.setVolume(musicVolume, musicVolume);
            //background_music.setLooping(true);
            background_music.start();
        }else if (background_music_command == "stop"){
            background_music.stop();
            background_music.release();
        }
    }

    @Override
    public void onBackPressed() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
