package com.uottawa.tictactoe.Activity;

import android.view.View;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.DataStructures.AvatarList;
import com.uottawa.tictactoe.DataStructures.ItemData;
import com.uottawa.tictactoe.DataStructures.SpinnerAdapter;
import com.uottawa.tictactoe.DataStructures.ThemeList;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {
    private AvatarList avatarList;
    private int avatar_position;

    private ThemeList themeList;
    private int theme_position;

    private TextView player1Name;
    private SeekBar soundVolume;
    private SeekBar musicVolume;

    private ImageButton buttonSound;
    private int buttonSoundID;
    private ImageButton buttonMusic;
    private int buttonMusicID;

    private int sound;
    private int music;

    @Override
    protected void loadView() {
        content = R.id.content_option;
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

        Spinner applicationTheme = (Spinner) findViewById(R.id.options_ApplicationTheme);
        SpinnerAdapter theme_adapter = new SpinnerAdapter(this, R.layout.spinner_theme_layout, theme_list);
        applicationTheme.setAdapter(theme_adapter);

        //Set Theme from ApplicationSetting
        int selectedPlayer1ThemeId = applicationSettings.getApplicationTheme();
        int themePosition = theme_adapter.getPosition(new ItemData(selectedPlayer1ThemeId));
        applicationTheme.setSelection(themePosition);

        applicationTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                theme_position = parent.getSelectedItemPosition();
                //theme_position = position;
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });

        //Sound Volume
        soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        sound = applicationSettings.getSoundVolume();
        soundVolume.setProgress(sound);

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
        music = applicationSettings.getMusicVolume();
        musicVolume.setProgress(music);

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

        //Button Sound
        buttonSound = (ImageButton) findViewById(R.id.options_SoundMute);
        buttonSoundID = applicationSettings.getButtonSound();
        buttonSound.setImageResource(buttonSoundID);

        //Button Music
        buttonMusic = (ImageButton) findViewById(R.id.options_MusicMute);
        buttonMusicID = applicationSettings.getButtonMusic();
        buttonMusic.setImageResource(buttonMusicID);
    }

    public void btnSound(View view){
        if(buttonSoundID == R.drawable.sound_on ){
            buttonSoundID = R.drawable.sound_off;
            buttonSound.setImageResource(buttonSoundID);
            sound = 0;
            soundVolume.setProgress(sound);
        }else{
            buttonSoundID = R.drawable.sound_on;
            buttonSound.setImageResource(buttonSoundID);
            sound = 50;
            soundVolume.setProgress(sound);
        }

    }

    public void btnMusic(View view){
        if(buttonMusicID == R.drawable.sound_on ){
            buttonMusicID = R.drawable.sound_off;
            buttonMusic.setImageResource(buttonMusicID);
            music = 0;
            musicVolume.setProgress(music);
        }else{
            buttonMusicID = R.drawable.sound_on;
            buttonMusic.setImageResource(buttonMusicID);
            music = 50;
            musicVolume.setProgress(music);
        }
    }

    public void btnApply(View view){

        String player1NameStr = player1Name.getText().toString();
        int avatarId = avatarList.getAvatarList().get(avatar_position).getImageId();
        int themeID = themeList.getThemeList().get(theme_position).getImageId();

        applicationSettings.saveSettings(player1NameStr, avatarId, themeID, sound, music, buttonSoundID, buttonMusicID);
        super.onBackPressed();
    }
}
