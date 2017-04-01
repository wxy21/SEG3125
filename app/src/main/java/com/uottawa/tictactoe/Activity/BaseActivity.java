package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.uottawa.tictactoe.DataStorage.ApplicationSettings;
import com.uottawa.tictactoe.DataStorage.MatchHistory;
import com.uottawa.tictactoe.R;

public abstract class BaseActivity extends AppCompatActivity {

    String keySharedPreference = "sharedPreference";

    protected int content;
    protected Button buttons;
    protected ApplicationSettings applicationSettings;
    protected MatchHistory matchHistory;

    private AppCompatDelegate mDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences(keySharedPreference, MODE_PRIVATE);
        applicationSettings = new ApplicationSettings(settings);
        applicationSettings.loadSettings();

        matchHistory = new MatchHistory(settings);
        matchHistory.loadMatches();

        loadView();
        changeBackground();
    }

    protected abstract void loadView();

    public void changeBackground() {
        RelativeLayout background = (RelativeLayout) findViewById(content);
        background.setBackground(ContextCompat.getDrawable(getApplicationContext(), applicationSettings.getApplicationTheme()));
    }

    @Override
    public void onBackPressed(){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
