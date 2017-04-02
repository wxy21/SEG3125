package com.uottawa.tictactoe.Activity.GameActivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.DataStructures.MatchDetails;
import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.GameInterface;
import com.uottawa.tictactoe.GameLogic.MultiplayerGame;
import com.uottawa.tictactoe.GameLogic.SinglePlayerGame;
import com.uottawa.tictactoe.R;

public class Grid3x3BoardActivity extends BaseActivity implements View.OnClickListener {

    private static MediaPlayer click_sound;
    private  int soundVolume;
    private String click_sound_command;
    private float soundVolumeFloat;

    GameInterface game;
    TextView Grid3x3_board_0_0;
    TextView Grid3x3_board_0_1;
    TextView Grid3x3_board_0_2;
    TextView Grid3x3_board_1_0;
    TextView Grid3x3_board_1_1;
    TextView Grid3x3_board_1_2;
    TextView Grid3x3_board_2_0;
    TextView Grid3x3_board_2_1;
    TextView Grid3x3_board_2_2;

    LinearLayout player1Layout;
    TextView player1Name;
    ImageView player1Avatar;

    LinearLayout player2Layout;
    TextView player2Name;
    ImageView player2Avatar;

    ImageView StarPlayer1;
    ImageView StarPlayer2;
    ProgressBar thinkingBar;

    private String gameResult;
    private String gameMessage;

    private MatchDetails matchDetails;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_3x3_grid);

        soundVolume = applicationSettings.getSoundVolume();
        click_sound_command = applicationSettings.getClickSoundCommand();

        Grid3x3_board_0_0 = (TextView) findViewById(R.id.Grid3x3_board_0_0);
        Grid3x3_board_0_1 = (TextView) findViewById(R.id.Grid3x3_board_0_1);
        Grid3x3_board_0_2 = (TextView) findViewById(R.id.Grid3x3_board_0_2);
        Grid3x3_board_1_0 = (TextView) findViewById(R.id.Grid3x3_board_1_0);
        Grid3x3_board_1_1 = (TextView) findViewById(R.id.Grid3x3_board_1_1);
        Grid3x3_board_1_2 = (TextView) findViewById(R.id.Grid3x3_board_1_2);
        Grid3x3_board_2_0 = (TextView) findViewById(R.id.Grid3x3_board_2_0);
        Grid3x3_board_2_1 = (TextView) findViewById(R.id.Grid3x3_board_2_1);
        Grid3x3_board_2_2 = (TextView) findViewById(R.id.Grid3x3_board_2_2);

        Grid3x3_board_0_0.setOnClickListener(this);
        Grid3x3_board_0_1.setOnClickListener(this);
        Grid3x3_board_0_2.setOnClickListener(this);
        Grid3x3_board_1_0.setOnClickListener(this);
        Grid3x3_board_1_1.setOnClickListener(this);
        Grid3x3_board_1_2.setOnClickListener(this);
        Grid3x3_board_2_0.setOnClickListener(this);
        Grid3x3_board_2_1.setOnClickListener(this);
        Grid3x3_board_2_2.setOnClickListener(this);

        player1Layout = (LinearLayout) findViewById(R.id.Grid3x3_Player1);
        player1Name = (TextView) findViewById(R.id.Grid3x3_Player1Name);
        player1Name.setText(applicationSettings.getPlayer1Name());

        player1Avatar = (ImageView) findViewById(R.id.Grid3x3_Player1Avatar);
        player1Avatar.setImageResource(applicationSettings.getPlayer1Avatar());

        player2Layout = (LinearLayout) findViewById(R.id.Grid3x3_Player2);
        if (applicationSettings.getBotDifficulty() > 0) {
            game = new SinglePlayerGame(3, applicationSettings.getBotDifficulty());

            player2Name = (TextView) findViewById(R.id.Grid3x3_Player2Name);
            if (applicationSettings.getBotDifficulty() <= 1)
                player2Name.setText("Easy Bot");
            else if (applicationSettings.getBotDifficulty() == 2)
                player2Name.setText("Medium Bot");
            else if (applicationSettings.getBotDifficulty() >= 3)
                player2Name.setText("Hard Bot");

            player2Avatar = (ImageView) findViewById(R.id.Grid3x3_Player2Avatar);
            player2Avatar.setImageResource(R.drawable.avatar_bot);
        }
        else {
            game = new MultiplayerGame(3);

            player2Name = (TextView) findViewById(R.id.Grid3x3_Player2Name);
            player2Name.setText(applicationSettings.getPlayer2Name());

            player2Avatar = (ImageView) findViewById(R.id.Grid3x3_Player2Avatar);
            player2Avatar.setImageResource(applicationSettings.getPlayer2Avatar());
        }

        StarPlayer1 = (ImageView) findViewById(R.id.Grid3x3_Star_Player1);
        StarPlayer2 = (ImageView) findViewById(R.id.Grid3x3_Star_Player2);
        thinkingBar = (ProgressBar) findViewById(R.id.Grid3x3_loading);
        updateScreen();
    }

    public void onClick(View v) {
        clickSound();
        switch (v.getId()) {
            case R.id.Grid3x3_board_0_0:
                game.markBoard(0, 0);
                break;
            case R.id.Grid3x3_board_0_1:
                game.markBoard(0, 1);
                break;
            case R.id.Grid3x3_board_0_2:
                game.markBoard(0, 2);
                break;
            case R.id.Grid3x3_board_1_0:
                game.markBoard(1, 0);
                break;
            case R.id.Grid3x3_board_1_1:
                game.markBoard(1, 1);
                break;
            case R.id.Grid3x3_board_1_2:
                game.markBoard(1, 2);
                break;
            case R.id.Grid3x3_board_2_0:
                game.markBoard(2, 0);
                break;
            case R.id.Grid3x3_board_2_1:
                game.markBoard(2, 1);
                break;
            case R.id.Grid3x3_board_2_2:
                game.markBoard(2, 2);
                break;
        }
        updateScreen();
        if (game.isGameFinished()) {
            matchHistory.saveMatch(game.getMatchDetails((String) player2Name.getText()));
        }
    }

    public void Grid3x3_ResetButton(View view) {
        clickSound();
        displayResetAlert();
        game.resetGame();
        updateScreen();
    }

    public void updateScreen() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GameBoard.Mark[][] board = game.getGameBoard();

                if (game.isPlayer1Turn()) {
                    player1Layout.setBackgroundColor(Color.YELLOW);
                    player2Layout.setBackgroundColor(Color.WHITE);
                    StarPlayer1.setVisibility(View.VISIBLE);
                    StarPlayer2.setVisibility(View.INVISIBLE);
                    thinkingBar.setVisibility(View.INVISIBLE);
                } else if (!game.isPlayer1Turn()) {
                    player1Layout.setBackgroundColor(Color.WHITE);
                    player2Layout.setBackgroundColor(Color.YELLOW);
                    StarPlayer1.setVisibility(View.INVISIBLE);
                    StarPlayer2.setVisibility(View.VISIBLE);
                    thinkingBar.setVisibility(View.VISIBLE);
                }

                if (applicationSettings.getBotDifficulty() <= 0)
                    thinkingBar.setVisibility(View.INVISIBLE);

                Grid3x3_board_0_0.setText(board[0][0].toString());
                Grid3x3_board_0_1.setText(board[0][1].toString());
                Grid3x3_board_0_2.setText(board[0][2].toString());
                Grid3x3_board_1_0.setText(board[1][0].toString());
                Grid3x3_board_1_1.setText(board[1][1].toString());
                Grid3x3_board_1_2.setText(board[1][2].toString());
                Grid3x3_board_2_0.setText(board[2][0].toString());
                Grid3x3_board_2_1.setText(board[2][1].toString());
                Grid3x3_board_2_2.setText(board[2][2].toString());
            }
        });
    }

    private void clickSound() {
        if (click_sound == null)
            click_sound = MediaPlayer.create(this, R.raw.button_sound);

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

    public void displayResetAlert(){
        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.Theme_Sphinx);
        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(ctw);
        alertDialogbuilder
                .setTitle("Confirm Restart")
                .setMessage("Do You Want to Play Again?")
                .setCancelable(false)
                .setNegativeButton("Yes", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        game.resetGame();
                        updateScreen();
                    }
                })
                .setPositiveButton("No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {

                        Grid3x3BoardActivity.this.finish();
                        dialog.cancel();
                    }
                });

        AlertDialog alert = alertDialogbuilder.create();
        alert.show();

        int titleDividerId = getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = alert.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
    }

    public void displayResult(){
        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.Theme_Sphinx);
        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(ctw);
        alertDialogbuilder
                .setTitle(gameResult)
                .setMessage(gameMessage)
                .setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        displayResetAlert();
                    }
                });

        AlertDialog alert = alertDialogbuilder.create();
        alert.show();

        int titleDividerId = getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = alert.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
    }

    @Override
    public void collectThemeElements() {
        buttons.add((Button) findViewById(R.id.Grid3x3_board_0_0));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_0_1));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_0_2));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_1_0));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_1_1));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_1_2));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_2_0));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_2_1));
        buttons.add((Button) findViewById(R.id.Grid3x3_board_2_2));
    }

}
