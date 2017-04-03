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
import java.util.concurrent.Semaphore;

public abstract class BaseActivity extends AppCompatActivity {

    String keySharedPreference = "sharedPreference";

    protected int content;
    protected List<Button> buttons;
    protected List<TextView> textViews;
    protected ApplicationSettings applicationSettings;
    protected MatchHistory matchHistory;

    private AppCompatDelegate mDelegate;

    protected static MediaPlayer click_sound;
    protected  int soundVolume;
    protected String click_sound_command;
    protected float soundVolumeFloat;

    protected static MediaPlayer background_music;
    protected String background_music_command;
    protected int musicVolume;
    protected float musicVolumeFloat;

    protected Thread updateScreenHandler;
    protected Semaphore gameMutex;

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

        soundVolume = applicationSettings.getSoundVolume();
        click_sound_command = applicationSettings.getClickSoundCommand();
    }

    protected abstract void loadView();
    protected abstract void collectThemeElements();

    public void changeTheme() {

        int backgroundImage = applicationSettings.getTheme().getBackgroundId();
        int color = applicationSettings.getTheme().getThemeColor();

        // Change the background
        RelativeLayout background = (RelativeLayout) findViewById(content);
        if (background != null) {
            background.setBackground(ContextCompat.getDrawable(getApplicationContext(), backgroundImage));
        }

        // Change the buttons
        for (Button button : buttons) {
            if (button != null) {
                button.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                button.setTextColor(Color.WHITE);
                button.setTextSize(30);
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

    @Override
    public void onBackPressed() {
        clickSound();
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    @Override
    public void onStop() {
        if (updateScreenHandler != null) {
            updateScreenHandler.interrupt();
        }
        super.onStop();
    }

    protected void clickSound() {
        if (click_sound == null) {
            click_sound = MediaPlayer.create(this, R.raw.button_sound);
        }

        if (this.getClass() != OptionsActivity.class) {
            soundVolume = applicationSettings.getSoundVolume();
        }
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

    protected void backgroundMusic() {
        if (background_music == null) {
            background_music = MediaPlayer.create(this, R.raw.background_music);
        }

        if (this.getClass() != OptionsActivity.class) {
            musicVolume = applicationSettings.getMusicVolume();
        }
        background_music_command = applicationSettings.getBackgroundMusicCommand();
        musicVolumeFloat = (float) (1 - (Math.log(100 - musicVolume) / Math.log(100)));

        if (background_music_command.equals("start") && !background_music.isPlaying()) {
            background_music.setVolume(musicVolumeFloat, musicVolumeFloat);
            background_music.setLooping(true);
            background_music.start();
        } else if (background_music_command.equals("start") && background_music.isPlaying()) {
            background_music.setVolume(musicVolumeFloat, musicVolumeFloat);
        } else if (background_music_command.equals("stop") && background_music.isPlaying()) {
            background_music.stop();
            background_music.release();
            background_music = null;
        }
    }
}
