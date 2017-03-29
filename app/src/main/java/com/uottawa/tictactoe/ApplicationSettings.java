package com.uottawa.tictactoe;

import android.content.SharedPreferences;

/**
 * Created by alanr on 2017-03-29.
 */

public class ApplicationSettings {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // Application variables and their default settings
    String player1Name = "Player 1";
    String player1Avatar = "Avatar1";
    String player2Name = "Player 2";
    String player2Avatar = "Avatar1";
    String applicationTheme = "Theme1";
    String soundVolume = "50";
    String musicVolume = "50";
    String boardSize = "3x3";
    String levelDifficulty = "Easy";

    // Variable Keys
    String keyPlayer1Name = "player1Name";
    String keyPlayer1Avatar = "player1Avatar";
    String keyApplicationTheme = "applicationTheme";
    String keySoundVolume = "soundVolume";
    String keyMusicVolume = "musicVolume";
    String keyPlayer2Name = "player2Name";
    String keyPlayer2Avatar = "player2Avatar";
    String keyBoardSize = "boardSize";
    String keyLevelDifficulty = "levelDifficulty";

    public ApplicationSettings(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public void saveSettings(String player1Name, String player1Avatar, String applicationTheme, String soundVolume, String musicVolume) {
        this.player1Name = player1Name;
        this.player1Avatar = player1Avatar;
        this.applicationTheme = applicationTheme;
        this.soundVolume = soundVolume;
        this.musicVolume = musicVolume;

        editor.putString(keyPlayer1Name, player1Name);
        editor.putString(keyPlayer1Avatar, player1Avatar);
        editor.putString(keyApplicationTheme, applicationTheme);
        editor.putString(keySoundVolume, soundVolume);
        editor.putString(keyMusicVolume, musicVolume);
        editor.commit();
        editor.apply();
    }

    public void savePlayerInformation(String player1Name, String player1Avatar, String player2Name, String player2Avatar) {
        this.player1Name = player1Name;
        this.player1Avatar = player1Avatar;
        this.player2Name = player2Name;
        this.player2Avatar = player2Avatar;

        editor.putString(keyPlayer1Name, player1Name);
        editor.putString(keyPlayer1Avatar, player1Avatar);
        editor.putString(keyPlayer2Name, player2Name);
        editor.putString(keyPlayer2Avatar, player2Avatar);
    }

    public void loadSettings() {
        player1Name = sharedPreferences.getString(keyPlayer1Name, player1Name);
        player1Avatar = sharedPreferences.getString(keyPlayer1Avatar, player1Avatar);

        player2Name = sharedPreferences.getString(keyPlayer2Name, player2Name);
        player2Avatar = sharedPreferences.getString(keyPlayer2Avatar, player2Avatar);

        applicationTheme = sharedPreferences.getString(keyApplicationTheme, applicationTheme);
        boardSize = sharedPreferences.getString(keyBoardSize, boardSize);
        levelDifficulty = sharedPreferences.getString(keyLevelDifficulty, levelDifficulty);
        soundVolume = sharedPreferences.getString(keySoundVolume, soundVolume);
        musicVolume = sharedPreferences.getString(keyMusicVolume, musicVolume);

        System.out.println(player1Name);
        System.out.println(player1Avatar);
        System.out.println(player2Name);
        System.out.println(player2Avatar);
        System.out.println(applicationTheme);
        System.out.println(boardSize);
        System.out.println(levelDifficulty);
        System.out.println(soundVolume);
        System.out.println(musicVolume);
        System.out.println("----------------");
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer1Avatar() {
        return player1Avatar;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public String getPlayer2Avatar() {
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

