package com.uottawa.tictactoe.DataStorage;

import android.content.SharedPreferences;
import android.graphics.Color;

import com.uottawa.tictactoe.DataStructures.Theme.Theme;
import com.uottawa.tictactoe.R;

public class ApplicationSettings {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // Application variables and their default settings
    private String player1Name = "Player 1";
    private int player1Avatar = R.drawable.avatar1;
    private String player2Name = "Player 2";
    private int player2Avatar = R.drawable.avatar1;
    private int themeSampleImageId = R.drawable.background1;
    private int themeBackgroundId = R.drawable.background1;
    private int themeColor = Color.rgb(255, 36, 226);
    private int soundVolume = 50;
    private int musicVolume = 50;
    private String boardSize = "3x3";
    private String levelDifficulty = "Easy";
    private int buttonSound = R.drawable.sound_on;
    private int buttonMusic = R.drawable.sound_on;
    private String backgroundMusicCommand = "start";

    // Variable Keys
    private String keyPlayer1Name = "player1Name";
    private String keyPlayer1Avatar = "player1Avatar";
    private String keyThemeSampleImadId = "themeSampleImageId";
    private String keyThemeBackgroundId = "themeBackgroundId";
    private String keyThemeColor = "themeColor";
    private String keySoundVolume = "soundVolume";
    private String keyMusicVolume = "musicVolume";
    private String keyPlayer2Name = "player2Name";
    private String keyPlayer2Avatar = "player2Avatar";
    private String keyBoardSize = "boardSize";
    private String keyLevelDifficulty = "levelDifficulty";
    private String keyButtonSound = "Sound";
    private String keyButtonMusic = "Music";
    private String keyBackgroundMusicCommand = "backgroundMusic";


    public ApplicationSettings(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
    }



    public void saveSettings(String player1Name, int player1Avatar, int themeSampleImageId, int themeBackgroundId,
                             int themeColor, int soundVolume, int musicVolume, int buttonSound, int buttonMusic,
                             String backgroundMusicCommand) {

        this.player1Name = player1Name;
        this.player1Avatar = player1Avatar;
        this.themeSampleImageId = themeSampleImageId;
        this.themeBackgroundId = themeBackgroundId;
        this.themeColor = themeColor;
        this.soundVolume = soundVolume;
        this.musicVolume = musicVolume;
        this.buttonSound = buttonSound;
        this.buttonMusic = buttonMusic;
        this.backgroundMusicCommand = backgroundMusicCommand;

        editor.putString(keyPlayer1Name, player1Name);
        editor.putInt(keyPlayer1Avatar, player1Avatar);
        editor.putInt(keyThemeSampleImadId, themeSampleImageId);
        editor.putInt(keyThemeBackgroundId, themeBackgroundId);
        editor.putInt(keyThemeColor, themeColor);
        editor.putInt(keySoundVolume, soundVolume);
        editor.putInt(keyMusicVolume, musicVolume);
        editor.putInt(keyButtonSound, buttonSound);
        editor.putInt(keyButtonMusic, buttonMusic);
        editor.putString(keyBackgroundMusicCommand, backgroundMusicCommand);
        editor.commit();
        editor.apply();
    }


    public void savePlayerInformation(String player1Name, int player1Avatar, String player2Name, int player2Avatar) {
        this.player1Name = player1Name;
        this.player1Avatar = player1Avatar;
        this.player2Name = player2Name;
        this.player2Avatar = player2Avatar;

        editor.putString(keyPlayer1Name, player1Name);
        editor.putInt(keyPlayer1Avatar, player1Avatar);
        editor.putString(keyPlayer2Name, player2Name);
        editor.putInt(keyPlayer2Avatar, player2Avatar);
        editor.commit();
        editor.apply();
    }

    public void loadSettings() {
        player1Name = sharedPreferences.getString(keyPlayer1Name, player1Name);
        player1Avatar = sharedPreferences.getInt(keyPlayer1Avatar, player1Avatar);

        player2Name = sharedPreferences.getString(keyPlayer2Name, player2Name);
        player2Avatar = sharedPreferences.getInt(keyPlayer2Avatar, player2Avatar);

        themeSampleImageId = sharedPreferences.getInt(keyThemeSampleImadId, themeSampleImageId);
        themeBackgroundId = sharedPreferences.getInt(keyThemeBackgroundId, themeBackgroundId);
        themeColor = sharedPreferences.getInt(keyThemeColor, themeColor);

        boardSize = sharedPreferences.getString(keyBoardSize, boardSize);
        levelDifficulty = sharedPreferences.getString(keyLevelDifficulty, levelDifficulty);

        soundVolume = sharedPreferences.getInt(keySoundVolume, soundVolume);
        musicVolume = sharedPreferences.getInt(keyMusicVolume, musicVolume);
        buttonSound = sharedPreferences.getInt(keyButtonSound, buttonSound);
        buttonMusic = sharedPreferences.getInt(keyButtonMusic, buttonMusic);
        backgroundMusicCommand = sharedPreferences.getString(keyBackgroundMusicCommand, backgroundMusicCommand);
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public int getPlayer1Avatar() { return player1Avatar; }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getPlayer2Avatar() {
        return player2Avatar;
    }

    public Theme getTheme() {
        return new Theme(themeSampleImageId, themeBackgroundId, themeColor);
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public int getMusicVolume() {
        return musicVolume;
    }

    public int getButtonSound(){
        return buttonSound;
    }

    public int getButtonMusic(){
        return buttonMusic;
    }

    public String getBackgroundMusicCommand(){
        return backgroundMusicCommand;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public String getLevelDifficulty() {
        return levelDifficulty;
    }

}

