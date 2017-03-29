package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.uottawa.tictactoe.ApplicationSettings;
import com.uottawa.tictactoe.R;

/**
 * A {@link android.preference.PreferenceActivity} which implements and proxies the necessary calls
 * to be used with AppCompat.
 */
public abstract class BaseActivity extends AppCompatActivity {

    String keySharedPreference = "sharedPreference";

    private ApplicationSettings applicationSettings;
    private AppCompatDelegate mDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences(keySharedPreference, MODE_PRIVATE);
        applicationSettings = new ApplicationSettings(settings);
        applicationSettings.loadSettings();

        loadView();
    }

    protected abstract void loadView();

    @Override
    public void onBackPressed(){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
