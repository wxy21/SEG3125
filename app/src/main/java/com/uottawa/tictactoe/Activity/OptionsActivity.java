package com.uottawa.tictactoe.Activity;

import android.view.View;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.SpinnerAdapter;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {
    private AvatarList avatarList;
    int avatar_position = 0;

    private ThemeList themeList;
    private int theme_position;
    private int theme_id;

    private TextView player1Name;
    private SeekBar soundVolume;
    private SeekBar musicVolume;
    int sound;
    int music;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_option);

        /**************************************
         *  Load GUI components with application setting variables
         */
        // Player's Name
        player1Name = (TextView) findViewById(R.id.options_Player1Name);
        player1Name.setText(applicationSettings.getPlayer1Name());

        //Avatar Spinner
        avatarList = new AvatarList();

        ArrayList<ItemData> avatar_list = avatarList.getAvatarList();
        Spinner player1Avatar_option = (Spinner) findViewById(R.id.options_Player1Avatar);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_avatar_layout, avatar_list);
        player1Avatar_option.setAdapter(adapter);

        // Set Avatar spinner based on previous application settings
        int selectedPlayer1AvatarId = applicationSettings.getPlayer1Avatar();
        int avatarPosition = adapter.getPosition(new ItemData(selectedPlayer1AvatarId));
        player1Avatar_option.setSelection(avatarPosition);

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
        soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        soundVolume.setProgress(applicationSettings.getSoundVolume());

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
        musicVolume = (SeekBar) findViewById(R.id.options_MusicVolume);
        musicVolume.setProgress(applicationSettings.getMusicVolume());

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

        int avatarId = avatarList.getAvatarList().get(avatar_position).getImageId();

        applicationSettings.saveSettings(player1Name.getText().toString(), avatarId, themeList.getImageID(), soundVolume.getProgress(), musicVolume.getProgress());
        super.onBackPressed();
    }
}
