package com.uottawa.tictactoe;

import android.content.SharedPreferences;
import com.uottawa.tictactoe.R;

public class ApplicationSettings {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // Application variables and their default settings
    private String player1Name = "Player 1";
    private int player1Avatar = R.drawable.avatar1;
    private String player2Name = "Player 2";
    private int player2Avatar = R.drawable.avatar1;
    private String applicationTheme = "Theme1";
    private String soundVolume = "50";
    private String musicVolume = "50";
    private String boardSize = "3x3";
    private String levelDifficulty = "Easy";

    // Variable Keys
    private String keyPlayer1Name = "player1Name";
    private String keyPlayer1Avatar = "player1Avatar";
    private String keyApplicationTheme = "applicationTheme";
    private String keySoundVolume = "soundVolume";
    private String keyMusicVolume = "musicVolume";
    private String keyPlayer2Name = "player2Name";
    private String keyPlayer2Avatar = "player2Avatar";
    private String keyBoardSize = "boardSize";
    private String keyLevelDifficulty = "levelDifficulty";

    private int selectedAvatar = 0;

    public ApplicationSettings(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public void saveSettings(String player1Name, int player1Avatar, String applicationTheme, String soundVolume, String musicVolume) {
        this.player1Name = player1Name;
        this.player1Avatar = player1Avatar;
        this.applicationTheme = applicationTheme;
        this.soundVolume = soundVolume;
        this.musicVolume = musicVolume;

        editor.putString(keyPlayer1Name, player1Name);
        editor.putInt(keyPlayer1Avatar, player1Avatar);
        editor.putString(keyApplicationTheme, applicationTheme);
        editor.putString(keySoundVolume, soundVolume);
        editor.putString(keyMusicVolume, musicVolume);
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
    }

    public void saveAvatar(int selectedAvatar){
        this.selectedAvatar = selectedAvatar;

        editor.putInt("selectedAvatar", selectedAvatar);
    }

    public void loadSettings() {
        player1Name = sharedPreferences.getString(keyPlayer1Name, player1Name);
        player1Avatar = sharedPreferences.getInt(keyPlayer1Avatar, player1Avatar);

        player2Name = sharedPreferences.getString(keyPlayer2Name, player2Name);
        player2Avatar = sharedPreferences.getInt(keyPlayer2Avatar, player2Avatar);

        applicationTheme = sharedPreferences.getString(keyApplicationTheme, applicationTheme);
        boardSize = sharedPreferences.getString(keyBoardSize, boardSize);
        levelDifficulty = sharedPreferences.getString(keyLevelDifficulty, levelDifficulty);
        soundVolume = sharedPreferences.getString(keySoundVolume, soundVolume);
        musicVolume = sharedPreferences.getString(keyMusicVolume, musicVolume);
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public int getPlayer1Avatar() {
        return player1Avatar;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getPlayer2Avatar() {
        return player2Avatar;
    }

    public String getApplicationTheme() {
        return applicationTheme;
    }

    public String getSoundVolume() {
        return soundVolume;
    }

    public String getMusicVolume() {
        return musicVolume;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public String getLevelDifficulty() {
        return levelDifficulty;
    }

}

