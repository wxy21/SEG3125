package com.uottawa.tictactoe.Activity.GameActivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.List;
import java.util.concurrent.Semaphore;

public class Grid3x3BoardActivity extends AbstractGameActivity implements View.OnClickListener {

    TextView Grid3x3_board_0_0;
    TextView Grid3x3_board_0_1;
    TextView Grid3x3_board_0_2;
    TextView Grid3x3_board_1_0;
    TextView Grid3x3_board_1_1;
    TextView Grid3x3_board_1_2;
    TextView Grid3x3_board_2_0;
    TextView Grid3x3_board_2_1;
    TextView Grid3x3_board_2_2;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_3x3_grid);

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
                player2Name.setText("EasyBot");
            else if (applicationSettings.getBotDifficulty() == 2)
                player2Name.setText("MedBot");
            else if (applicationSettings.getBotDifficulty() >= 3)
                player2Name.setText("HardBot");

            player2Avatar = (ImageView) findViewById(R.id.Grid3x3_Player2Avatar);
            player2Avatar.setImageResource(R.drawable.avatar_bot);
        } else {
            game = new MultiplayerGame(3);

            player2Name = (TextView) findViewById(R.id.Grid3x3_Player2Name);
            player2Name.setText(applicationSettings.getPlayer2Name());

            player2Avatar = (ImageView) findViewById(R.id.Grid3x3_Player2Avatar);
            player2Avatar.setImageResource(applicationSettings.getPlayer2Avatar());
        }

        StarPlayer1 = (ImageView) findViewById(R.id.Grid3x3_Star_Player1);
        StarPlayer2 = (ImageView) findViewById(R.id.Grid3x3_Star_Player2);
        thinkingBar = (ProgressBar) findViewById(R.id.Grid3x3_loading);

        gameMutex = new Semaphore(1);
        updateScreenHandler = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("Recycling thread");
                    }
                    updateScreen();
                }
            }
        });

        updateScreenHandler.start();
    }

    public void onClick(final View v) {

        final Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                // Lock the game
                boolean acquired = gameMutex.tryAcquire();
                if (!acquired) {
                    return;
                }
                setGameClickable(false);
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
                gameMutex.release();

                if (game instanceof SinglePlayerGame && !game.isPlayer1Turn()) {
                    ((SinglePlayerGame) game).markBoardAI();
                }

                if (game.isGameFinished()) {
                    matchHistory.saveMatch(game.getMatchDetails((String) player2Name.getText()));
                    GameOver();
                    return;
                }

                // Unlock
                setGameClickable(true);
            }
        });
        backgroundThread.start();
    }

    public void Grid3x3_ResetButton(View view) {
        clickSound();
        displayResetAlert();
    }

    public void updateScreen() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                boolean acquired = gameMutex.tryAcquire();
                if (!acquired) return;

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

                hideElementsAtTheEndOfGame();

                Grid3x3_board_0_0.setText(board[0][0].toString());
                Grid3x3_board_0_1.setText(board[0][1].toString());
                Grid3x3_board_0_2.setText(board[0][2].toString());
                Grid3x3_board_1_0.setText(board[1][0].toString());
                Grid3x3_board_1_1.setText(board[1][1].toString());
                Grid3x3_board_1_2.setText(board[1][2].toString());
                Grid3x3_board_2_0.setText(board[2][0].toString());
                Grid3x3_board_2_1.setText(board[2][1].toString());
                Grid3x3_board_2_2.setText(board[2][2].toString());

                gameMutex.release();

            }
        });

    }

    @Override
    public void collectThemeElements() {
        content = R.id.content_3x3_grid;
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

    public void setGameClickable(final boolean clickable) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((Button) findViewById(R.id.Grid3x3_board_0_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_0_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_0_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_1_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_1_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_1_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_2_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_2_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid3x3_board_2_2)).setEnabled(clickable);
            }
        });
    }

}
