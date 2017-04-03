package com.uottawa.tictactoe.Activity.GameActivities;

import android.media.MediaPlayer;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.GameInterface;
import com.uottawa.tictactoe.GameLogic.MultiplayerGame;
import com.uottawa.tictactoe.GameLogic.SinglePlayerGame;
import com.uottawa.tictactoe.R;

import java.util.concurrent.Semaphore;

public class Grid5x5BoardActivity extends AbstractGameActivity implements View.OnClickListener {

    TextView Grid5x5_board_0_0;
    TextView Grid5x5_board_0_1;
    TextView Grid5x5_board_0_2;
    TextView Grid5x5_board_0_3;
    TextView Grid5x5_board_0_4;
    TextView Grid5x5_board_1_0;
    TextView Grid5x5_board_1_1;
    TextView Grid5x5_board_1_2;
    TextView Grid5x5_board_1_3;
    TextView Grid5x5_board_1_4;
    TextView Grid5x5_board_2_0;
    TextView Grid5x5_board_2_1;
    TextView Grid5x5_board_2_2;
    TextView Grid5x5_board_2_3;
    TextView Grid5x5_board_2_4;
    TextView Grid5x5_board_3_0;
    TextView Grid5x5_board_3_1;
    TextView Grid5x5_board_3_2;
    TextView Grid5x5_board_3_3;
    TextView Grid5x5_board_3_4;
    TextView Grid5x5_board_4_0;
    TextView Grid5x5_board_4_1;
    TextView Grid5x5_board_4_2;
    TextView Grid5x5_board_4_3;
    TextView Grid5x5_board_4_4;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_5x5_grid);

        Grid5x5_board_0_0 = (TextView) findViewById(R.id.Grid5x5_board_0_0);
        Grid5x5_board_0_1 = (TextView) findViewById(R.id.Grid5x5_board_0_1);
        Grid5x5_board_0_2 = (TextView) findViewById(R.id.Grid5x5_board_0_2);
        Grid5x5_board_0_3 = (TextView) findViewById(R.id.Grid5x5_board_0_3);
        Grid5x5_board_0_4 = (TextView) findViewById(R.id.Grid5x5_board_0_4);
        Grid5x5_board_1_0 = (TextView) findViewById(R.id.Grid5x5_board_1_0);
        Grid5x5_board_1_1 = (TextView) findViewById(R.id.Grid5x5_board_1_1);
        Grid5x5_board_1_2 = (TextView) findViewById(R.id.Grid5x5_board_1_2);
        Grid5x5_board_1_3 = (TextView) findViewById(R.id.Grid5x5_board_1_3);
        Grid5x5_board_1_4 = (TextView) findViewById(R.id.Grid5x5_board_1_4);
        Grid5x5_board_2_0 = (TextView) findViewById(R.id.Grid5x5_board_2_0);
        Grid5x5_board_2_1 = (TextView) findViewById(R.id.Grid5x5_board_2_1);
        Grid5x5_board_2_2 = (TextView) findViewById(R.id.Grid5x5_board_2_2);
        Grid5x5_board_2_3 = (TextView) findViewById(R.id.Grid5x5_board_2_3);
        Grid5x5_board_2_4 = (TextView) findViewById(R.id.Grid5x5_board_2_4);
        Grid5x5_board_3_0 = (TextView) findViewById(R.id.Grid5x5_board_3_0);
        Grid5x5_board_3_1 = (TextView) findViewById(R.id.Grid5x5_board_3_1);
        Grid5x5_board_3_2 = (TextView) findViewById(R.id.Grid5x5_board_3_2);
        Grid5x5_board_3_3 = (TextView) findViewById(R.id.Grid5x5_board_3_3);
        Grid5x5_board_3_4 = (TextView) findViewById(R.id.Grid5x5_board_3_4);
        Grid5x5_board_4_0 = (TextView) findViewById(R.id.Grid5x5_board_4_0);
        Grid5x5_board_4_1 = (TextView) findViewById(R.id.Grid5x5_board_4_1);
        Grid5x5_board_4_2 = (TextView) findViewById(R.id.Grid5x5_board_4_2);
        Grid5x5_board_4_3 = (TextView) findViewById(R.id.Grid5x5_board_4_3);
        Grid5x5_board_4_4 = (TextView) findViewById(R.id.Grid5x5_board_4_4);

        Grid5x5_board_0_0.setOnClickListener(this);
        Grid5x5_board_0_1.setOnClickListener(this);
        Grid5x5_board_0_2.setOnClickListener(this);
        Grid5x5_board_0_3.setOnClickListener(this);
        Grid5x5_board_0_4.setOnClickListener(this);
        Grid5x5_board_1_0.setOnClickListener(this);
        Grid5x5_board_1_1.setOnClickListener(this);
        Grid5x5_board_1_2.setOnClickListener(this);
        Grid5x5_board_1_3.setOnClickListener(this);
        Grid5x5_board_1_4.setOnClickListener(this);
        Grid5x5_board_2_0.setOnClickListener(this);
        Grid5x5_board_2_1.setOnClickListener(this);
        Grid5x5_board_2_2.setOnClickListener(this);
        Grid5x5_board_2_3.setOnClickListener(this);
        Grid5x5_board_2_4.setOnClickListener(this);
        Grid5x5_board_3_0.setOnClickListener(this);
        Grid5x5_board_3_1.setOnClickListener(this);
        Grid5x5_board_3_2.setOnClickListener(this);
        Grid5x5_board_3_3.setOnClickListener(this);
        Grid5x5_board_3_4.setOnClickListener(this);
        Grid5x5_board_4_0.setOnClickListener(this);
        Grid5x5_board_4_1.setOnClickListener(this);
        Grid5x5_board_4_2.setOnClickListener(this);
        Grid5x5_board_4_3.setOnClickListener(this);
        Grid5x5_board_4_4.setOnClickListener(this);

        //Player 1
        player1Layout = (LinearLayout) findViewById(R.id.Grid5x5_Player1);
        player1Name = (TextView) findViewById(R.id.Grid5x5_Player1Name);
        player1Name.setText(applicationSettings.getPlayer1Name());

        player1Avatar = (ImageView) findViewById(R.id.Grid5x5_Player1Avatar);
        player1Avatar.setImageResource(applicationSettings.getPlayer1Avatar());

        //Player 2
        player2Layout = (LinearLayout) findViewById(R.id.Grid5x5_Player2);
        if (applicationSettings.getBotDifficulty() > 0) {
            game = new SinglePlayerGame(5, applicationSettings.getBotDifficulty());

            player2Name = (TextView) findViewById(R.id.Grid5x5_Player2Name);
            if (applicationSettings.getBotDifficulty() <= 1)
                player2Name.setText("Easy Bot");
            else if (applicationSettings.getBotDifficulty() == 2)
                player2Name.setText("Medium Bot");
            else if (applicationSettings.getBotDifficulty() >= 3)
                player2Name.setText("Hard Bot");

            player2Avatar = (ImageView) findViewById(R.id.Grid5x5_Player2Avatar);
            player2Avatar.setImageResource(R.drawable.avatar_bot);
        } else {
            game = new MultiplayerGame(5);

            player2Name = (TextView) findViewById(R.id.Grid5x5_Player2Name);
            player2Name.setText(applicationSettings.getPlayer2Name());

            player2Avatar = (ImageView) findViewById(R.id.Grid5x5_Player2Avatar);
            player2Avatar.setImageResource(applicationSettings.getPlayer2Avatar());
        }

        StarPlayer1 = (ImageView) findViewById(R.id.Grid5x5_Star_Player1);
        StarPlayer2 = (ImageView) findViewById(R.id.Grid5x5_Star_Player2);
        thinkingBar = (ProgressBar) findViewById(R.id.Grid5x5_loading);

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

    @Override
    public void onClick(final View v) {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                // Lock the game
                boolean acquired = gameMutex.tryAcquire();
                if (!acquired) {
                    gameMutex.release();
                    return;
                }
                setGameClickable(false);
                clickSound();

                switch (v.getId()) {
                    case R.id.Grid5x5_board_0_0:
                        game.markBoard(0, 0);
                        break;
                    case R.id.Grid5x5_board_0_1:
                        game.markBoard(0, 1);
                        break;
                    case R.id.Grid5x5_board_0_2:
                        game.markBoard(0, 2);
                        break;
                    case R.id.Grid5x5_board_0_3:
                        game.markBoard(0, 3);
                        break;
                    case R.id.Grid5x5_board_0_4:
                        game.markBoard(0, 4);
                        break;
                    case R.id.Grid5x5_board_1_0:
                        game.markBoard(1, 0);
                        break;
                    case R.id.Grid5x5_board_1_1:
                        game.markBoard(1, 1);
                        break;
                    case R.id.Grid5x5_board_1_2:
                        game.markBoard(1, 2);
                        break;
                    case R.id.Grid5x5_board_1_3:
                        game.markBoard(1, 3);
                        break;
                    case R.id.Grid5x5_board_1_4:
                        game.markBoard(1, 4);
                        break;
                    case R.id.Grid5x5_board_2_0:
                        game.markBoard(2, 0);
                        break;
                    case R.id.Grid5x5_board_2_1:
                        game.markBoard(2, 1);
                        break;
                    case R.id.Grid5x5_board_2_2:
                        game.markBoard(2, 2);
                        break;
                    case R.id.Grid5x5_board_2_3:
                        game.markBoard(2, 3);
                        break;
                    case R.id.Grid5x5_board_2_4:
                        game.markBoard(2, 4);
                        break;
                    case R.id.Grid5x5_board_3_0:
                        game.markBoard(3, 0);
                        break;
                    case R.id.Grid5x5_board_3_1:
                        game.markBoard(3, 1);
                        break;
                    case R.id.Grid5x5_board_3_2:
                        game.markBoard(3, 2);
                        break;
                    case R.id.Grid5x5_board_3_3:
                        game.markBoard(3, 3);
                        break;
                    case R.id.Grid5x5_board_3_4:
                        game.markBoard(3, 4);
                        break;
                    case R.id.Grid5x5_board_4_0:
                        game.markBoard(4, 0);
                        break;
                    case R.id.Grid5x5_board_4_1:
                        game.markBoard(4, 1);
                        break;
                    case R.id.Grid5x5_board_4_2:
                        game.markBoard(4, 2);
                        break;
                    case R.id.Grid5x5_board_4_3:
                        game.markBoard(4, 3);
                        break;
                    case R.id.Grid5x5_board_4_4:
                        game.markBoard(4, 4);
                        break;
                }
                gameMutex.release();

                if (game instanceof SinglePlayerGame) {
                    ((SinglePlayerGame) game).markBoardAI();
                }

                if (game.isGameFinished()) {
                    matchHistory.saveMatch(game.getMatchDetails((String) player2Name.getText()));
                    GameOver();
                }

                // Unlock
                setGameClickable(true);
            }
        });
        backgroundThread.start();
    }

    @Override
    public void collectThemeElements() {
        content = R.id.content_5x5_grid;
        buttons.add((Button) findViewById(R.id.Grid5x5_board_0_0));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_0_1));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_0_2));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_0_3));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_0_4));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_1_0));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_1_1));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_1_2));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_1_3));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_1_4));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_2_0));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_2_1));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_2_2));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_2_3));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_2_4));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_3_0));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_3_1));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_3_2));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_3_3));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_3_4));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_4_0));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_4_1));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_4_2));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_4_3));
        buttons.add((Button) findViewById(R.id.Grid5x5_board_4_4));
    }

    public void Grid5x5_ResetButton(View view) {
        clickSound();
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

                hideElementsAtTheEndOfGame();

                Grid5x5_board_0_0.setText(board[0][0].toString());
                Grid5x5_board_0_1.setText(board[0][1].toString());
                Grid5x5_board_0_2.setText(board[0][2].toString());
                Grid5x5_board_0_3.setText(board[0][3].toString());
                Grid5x5_board_0_4.setText(board[0][4].toString());
                Grid5x5_board_1_0.setText(board[1][0].toString());
                Grid5x5_board_1_1.setText(board[1][1].toString());
                Grid5x5_board_1_2.setText(board[1][2].toString());
                Grid5x5_board_1_3.setText(board[1][3].toString());
                Grid5x5_board_1_4.setText(board[1][4].toString());
                Grid5x5_board_2_0.setText(board[2][0].toString());
                Grid5x5_board_2_1.setText(board[2][1].toString());
                Grid5x5_board_2_2.setText(board[2][2].toString());
                Grid5x5_board_2_3.setText(board[2][3].toString());
                Grid5x5_board_2_4.setText(board[2][4].toString());
                Grid5x5_board_3_0.setText(board[3][0].toString());
                Grid5x5_board_3_1.setText(board[3][1].toString());
                Grid5x5_board_3_2.setText(board[3][2].toString());
                Grid5x5_board_3_3.setText(board[3][3].toString());
                Grid5x5_board_3_4.setText(board[3][4].toString());
                Grid5x5_board_4_0.setText(board[4][0].toString());
                Grid5x5_board_4_1.setText(board[4][1].toString());
                Grid5x5_board_4_2.setText(board[4][2].toString());
                Grid5x5_board_4_3.setText(board[4][3].toString());
                Grid5x5_board_4_4.setText(board[4][4].toString());
            }
        });
    }

    public void setGameClickable(final boolean clickable) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((Button) findViewById(R.id.Grid5x5_board_0_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_0_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_0_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_0_3)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_0_4)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_1_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_1_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_1_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_1_3)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_1_4)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_2_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_2_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_2_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_2_3)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_2_4)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_3_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_3_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_3_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_3_3)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_3_4)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_4_0)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_4_1)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_4_2)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_4_3)).setEnabled(clickable);
                ((Button) findViewById(R.id.Grid5x5_board_4_4)).setEnabled(clickable);

            }
        });
    }
}
