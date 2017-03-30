package com.uottawa.tictactoe.Activity;

import android.view.View;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.SpinnerAdapter;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {
    private AvatarList avatarList;
    private int avatar_position;
    private int avatar_id;

    private ThemeList themeList;
    private int theme_position;
    private int theme_id;

    private TextView player1;
    private String player1_name;

    int sound;
    int music;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_option);

        //Player 1 Name
        player1 = (TextView) findViewById(R.id.options_Player1Name);
        player1_name = player1.getText().toString();

        //Avatar Spinner
        avatarList = new AvatarList();

        ArrayList<ItemData> avatar_list = avatarList.getAvatarList();
        avatar_id = avatarList.getImageID();

        Spinner player1Avatar_option = (Spinner) findViewById(R.id.options_Player1Avatar);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_avatar_layout, avatar_list);
        player1Avatar_option.setAdapter(adapter);

        player1Avatar_option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                avatar_position = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });


        //Theme Spinner
        themeList = new ThemeList();
        ArrayList<ItemData> theme_list = themeList.getThemeList();
        theme_id = themeList.getImageID();

        Spinner applicationTheme = (Spinner) findViewById(R.id.options_ApplicationTheme);
        SpinnerAdapter theme_adapter = new SpinnerAdapter(this, R.layout.spinner_theme_layout, theme_list);
        applicationTheme.setAdapter(theme_adapter);

        applicationTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                theme_position = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });

        //Sound Volume
        SeekBar soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        sound = soundVolume.getProgress();

        soundVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    sound = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Music Volume
        SeekBar musicVolume = (SeekBar) findViewById(R.id.options_MusicVolume);
        music = musicVolume.getProgress();

        musicVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                music = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String getPlayer1_Name(){
        //TextView player1 = (TextView) findViewById(R.id.options_Player1Name);
        player1_name = player1.getText().toString();
        return player1_name;
    }

    private int getImageID(){
        avatarList.setAvatar(avatar_position);
        avatar_id = avatarList.getImageID();
        return avatar_id;
    }

    private int getThemeID(){
        themeList.setTheme(theme_position);
        theme_id = themeList.getImageID();
        return theme_id;
    }

    public void btnSound(View view){
        ImageButton button = (ImageButton) findViewById(R.id.options_SoundMute);
        button.setImageResource(R.drawable.sound_off);

        SeekBar soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        soundVolume.setProgress(0);
        sound = 0;
    }

    public void btnMusic(View view){
        ImageButton button = (ImageButton) findViewById(R.id.options_MusicMute);
        button.setImageResource(R.drawable.sound_off);

        SeekBar musicVolume = (SeekBar) findViewById(R.id.options_MusicVolume);
        musicVolume.setProgress(0);
        music = 0;
    }

    public void btnApply(View view){
        player1_name = getPlayer1_Name();
        applicationSettings.saveSettings(player1_name, avatar_id, theme_id, Integer.toString(sound), Integer.toString(music));
        super.onBackPressed();
    }
}
