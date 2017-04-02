package com.uottawa.tictactoe.Activity;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.DataStructures.Avatar.AvatarList;
import com.uottawa.tictactoe.DataStructures.Avatar.Avatar;
import com.uottawa.tictactoe.DataStructures.Avatar.AvatarSpinnerAdapter;
import com.uottawa.tictactoe.DataStructures.Theme.Theme;
import com.uottawa.tictactoe.DataStructures.Theme.ThemeList;
import com.uottawa.tictactoe.DataStructures.Theme.ThemeSpinnerAdapter;

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

    private String background_music_command;
    private String click_sound_command;

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

        ArrayList<Avatar> avatar_list = avatarList.getAvatarList();
        Spinner player1Avatar_option = (Spinner) findViewById(R.id.options_Player1Avatar);
        AvatarSpinnerAdapter adapter = new AvatarSpinnerAdapter(this, R.layout.spinner_avatar_layout, avatar_list);
        player1Avatar_option.setAdapter(adapter);

        // Set Avatar spinner based on previous application settings
        int selectedPlayer1AvatarId = applicationSettings.getPlayer1Avatar();
        int avatarPosition = adapter.getPosition(new Avatar(selectedPlayer1AvatarId));
        player1Avatar_option.setSelection(avatarPosition);

        player1Avatar_option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                clickSound();
                avatar_position = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });


        //Theme Spinner
        themeList = new ThemeList();
        ArrayList<Theme> theme_list = themeList.getThemeList();

        Spinner applicationTheme = (Spinner) findViewById(R.id.options_ApplicationTheme);
        ThemeSpinnerAdapter theme_adapter = new ThemeSpinnerAdapter(this, R.layout.spinner_theme_layout, theme_list);
        applicationTheme.setAdapter(theme_adapter);

        //Set Theme from ApplicationSetting
        Theme selectedTheme = applicationSettings.getTheme();
        int themePosition = theme_adapter.getPosition(selectedTheme);
        applicationTheme.setSelection(themePosition);

        applicationTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                clickSound();
                theme_position = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
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

        //Background Music
        background_music_command = applicationSettings.getBackgroundMusicCommand();

        //Sound
        click_sound_command = applicationSettings.getClickSoundCommand();

        //Sound Volume
        soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        sound = applicationSettings.getSoundVolume();
        soundVolume.setProgress(sound);

        changeSoundPicture();

        soundVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sound = seekBar.getProgress();
                clickSound();
                changeSoundPicture();
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

        changeMusicPicture();

        musicVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                music = seekBar.getProgress();
                clickSound();
                changeMusicPicture();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void changeSoundPicture(){
        if(soundVolume.getProgress() == 0){
            buttonSoundID = R.drawable.sound_off;
            buttonSound.setImageResource(buttonSoundID);
            click_sound_command = "stop";
        }else{
            buttonSoundID = R.drawable.sound_on;
            buttonSound.setImageResource(buttonSoundID);
            click_sound_command = "start";
        }
    }

    private void changeMusicPicture(){
        if(musicVolume.getProgress() == 0){
            buttonMusicID = R.drawable.sound_off;
            buttonMusic.setImageResource(buttonMusicID);
            background_music_command = "stop";
        }else{
            buttonMusicID = R.drawable.sound_on;
            buttonMusic.setImageResource(buttonMusicID);
            background_music_command = "start";
        }
    }

    public void btnSound(View view){
        if(buttonSoundID == R.drawable.sound_on ){
            buttonSoundID = R.drawable.sound_off;
            buttonSound.setImageResource(buttonSoundID);
            sound = 0;
            soundVolume.setProgress(sound);
            click_sound_command = "stop";
        }else if(buttonSoundID == R.drawable.sound_off){
            buttonSoundID = R.drawable.sound_on;
            buttonSound.setImageResource(buttonSoundID);
            sound = 50;
            soundVolume.setProgress(sound);
            click_sound_command = "start";
        }
        clickSound();

    }

    public void btnMusic(View view){
        if(buttonMusicID == R.drawable.sound_on ){
            buttonMusicID = R.drawable.sound_off;
            buttonMusic.setImageResource(buttonMusicID);
            music = 0;
            musicVolume.setProgress(music);
            background_music_command = "stop";
        }else if(buttonMusicID == R.drawable.sound_off){
            buttonMusicID = R.drawable.sound_on;
            buttonMusic.setImageResource(buttonMusicID);
            music = 50;
            musicVolume.setProgress(music);
            background_music_command = "start";
        }
        clickSound();
    }

    public void btnApply(View view){

        String player1NameStr = player1Name.getText().toString();
        int avatarId = avatarList.getAvatarList().get(avatar_position).getImageId();
        int themeSampleImageId = themeList.getThemeList().get(theme_position).getSampleImageId();
        int themeBackgroundId = themeList.getThemeList().get(theme_position).getBackgroundId();
        int themeColor = themeList.getThemeList().get(theme_position).getThemeColor();

        clickSound();

        applicationSettings.saveSettings(player1NameStr, avatarId, themeSampleImageId, themeBackgroundId, themeColor,
                sound, music, buttonSoundID, buttonMusicID, background_music_command, click_sound_command);
        changeTheme();
        Toast.makeText(this, "Your Settings Have Been Applied!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_option;
        textViews.add((TextView) findViewById(R.id.options_title));
        textViews.add((TextView) findViewById(R.id.options_name_text));
        textViews.add((TextView) findViewById(R.id.options_avatar_text));
        textViews.add((TextView) findViewById(R.id.options_theme_text));
        textViews.add((TextView) findViewById(R.id.options_sound_text));
        textViews.add((TextView) findViewById(R.id.options_music_text));
        buttons.add((Button) findViewById(R.id.options_apply));
    }
}
