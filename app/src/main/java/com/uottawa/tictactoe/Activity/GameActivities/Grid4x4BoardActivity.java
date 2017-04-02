package com.uottawa.tictactoe.Activity.GameActivities;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.MainActivity;
import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.GameInterface;
import com.uottawa.tictactoe.GameLogic.MultiplayerGame;
import com.uottawa.tictactoe.GameLogic.SinglePlayerGame;
import com.uottawa.tictactoe.R;

public class Grid4x4BoardActivity extends BaseActivity implements View.OnClickListener{

    GameInterface game;
    TextView Grid4x4_board_0_0;
    TextView Grid4x4_board_0_1;
    TextView Grid4x4_board_0_2;
    TextView Grid4x4_board_0_3;
    TextView Grid4x4_board_1_0;
    TextView Grid4x4_board_1_1;
    TextView Grid4x4_board_1_2;
    TextView Grid4x4_board_1_3;
    TextView Grid4x4_board_2_0;
    TextView Grid4x4_board_2_1;
    TextView Grid4x4_board_2_2;
    TextView Grid4x4_board_2_3;
    TextView Grid4x4_board_3_0;
    TextView Grid4x4_board_3_1;
    TextView Grid4x4_board_3_2;
    TextView Grid4x4_board_3_3;

    TextView player1Name;
    ImageView player1Avatar;

    TextView player2Name;
    ImageView player2Avatar;


    ImageView StarPlayer1;
    ImageView StarPlayer2;
    ProgressBar thinkingBar;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_4x4_grid);

        Grid4x4_board_0_0 = (TextView) findViewById(R.id.Grid4x4_board_0_0);
        Grid4x4_board_0_1 = (TextView) findViewById(R.id.Grid4x4_board_0_1);
        Grid4x4_board_0_2 = (TextView) findViewById(R.id.Grid4x4_board_0_2);
        Grid4x4_board_0_3 = (TextView) findViewById(R.id.Grid4x4_board_0_3);
        Grid4x4_board_1_0 = (TextView) findViewById(R.id.Grid4x4_board_1_0);
        Grid4x4_board_1_1 = (TextView) findViewById(R.id.Grid4x4_board_1_1);
        Grid4x4_board_1_2 = (TextView) findViewById(R.id.Grid4x4_board_1_2);
        Grid4x4_board_1_3 = (TextView) findViewById(R.id.Grid4x4_board_1_3);
        Grid4x4_board_2_0 = (TextView) findViewById(R.id.Grid4x4_board_2_0);
        Grid4x4_board_2_1 = (TextView) findViewById(R.id.Grid4x4_board_2_1);
        Grid4x4_board_2_2 = (TextView) findViewById(R.id.Grid4x4_board_2_2);
        Grid4x4_board_2_3 = (TextView) findViewById(R.id.Grid4x4_board_2_3);
        Grid4x4_board_3_0 = (TextView) findViewById(R.id.Grid4x4_board_3_0);
        Grid4x4_board_3_1 = (TextView) findViewById(R.id.Grid4x4_board_3_1);
        Grid4x4_board_3_2 = (TextView) findViewById(R.id.Grid4x4_board_3_2);
        Grid4x4_board_3_3 = (TextView) findViewById(R.id.Grid4x4_board_3_3);

        Grid4x4_board_0_0.setOnClickListener(this);
        Grid4x4_board_0_1.setOnClickListener(this);
        Grid4x4_board_0_2.setOnClickListener(this);
        Grid4x4_board_0_3.setOnClickListener(this);
        Grid4x4_board_1_0.setOnClickListener(this);
        Grid4x4_board_1_1.setOnClickListener(this);
        Grid4x4_board_1_2.setOnClickListener(this);
        Grid4x4_board_1_3.setOnClickListener(this);
        Grid4x4_board_2_0.setOnClickListener(this);
        Grid4x4_board_2_1.setOnClickListener(this);
        Grid4x4_board_2_2.setOnClickListener(this);
        Grid4x4_board_2_3.setOnClickListener(this);
        Grid4x4_board_3_0.setOnClickListener(this);
        Grid4x4_board_3_1.setOnClickListener(this);
        Grid4x4_board_3_2.setOnClickListener(this);
        Grid4x4_board_3_3.setOnClickListener(this);

        //Player 1
        player1Name = (TextView) findViewById(R.id.Grid4x4_Player1Name);
        player1Name.setText(applicationSettings.getPlayer1Name());

        player1Avatar = (ImageView) findViewById(R.id.Grid4x4_Player1Avatar);
        player1Avatar.setImageResource(applicationSettings.getPlayer1Avatar());

        //Player 2
        if (applicationSettings.getBotDifficulty() > 0) {
            game = new SinglePlayerGame(4, applicationSettings.getBotDifficulty());

            player2Name = (TextView) findViewById(R.id.Grid4x4_Player2Name);
            if (applicationSettings.getBotDifficulty() <= 1)
                player2Name.setText("Easy Bot");
            else if (applicationSettings.getBotDifficulty() == 2)
                player2Name.setText("Medium Bot");
            else if (applicationSettings.getBotDifficulty() >= 3)
                player2Name.setText("Hard Bot");

            player2Avatar = (ImageView) findViewById(R.id.Grid4x4_Player2Avatar);
            player2Avatar.setImageResource(R.drawable.avatar_bot);
        }
        else {
            game = new MultiplayerGame(4);

            player2Name = (TextView) findViewById(R.id.Grid4x4_Player2Name);
            player2Name.setText(applicationSettings.getPlayer2Name());

            player2Avatar = (ImageView) findViewById(R.id.Grid4x4_Player2Avatar);
            player2Avatar.setImageResource(applicationSettings.getPlayer2Avatar());
        }

        StarPlayer1 = (ImageView) findViewById(R.id.Grid4x4_Star_Player1);
        StarPlayer2 = (ImageView) findViewById(R.id.Grid4x4_Star_Player2);
        thinkingBar = (ProgressBar) findViewById(R.id.Grid4x4_loading);
        updateScreen();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Grid4x4_board_0_0:
                game.markBoard(0, 0);
                break;
            case R.id.Grid4x4_board_0_1:
                game.markBoard(0, 1);
                break;
            case R.id.Grid4x4_board_0_2:
                game.markBoard(0, 2);
                break;
            case R.id.Grid4x4_board_0_3:
                game.markBoard(0, 3);
                break;
            case R.id.Grid4x4_board_1_0:
                game.markBoard(1, 0);
                break;
            case R.id.Grid4x4_board_1_1:
                game.markBoard(1, 1);
                break;
            case R.id.Grid4x4_board_1_2:
                game.markBoard(1, 2);
                break;
            case R.id.Grid4x4_board_1_3:
                game.markBoard(1, 3);
                break;
            case R.id.Grid4x4_board_2_0:
                game.markBoard(2, 0);
                break;
            case R.id.Grid4x4_board_2_1:
                game.markBoard(2, 1);
                break;
            case R.id.Grid4x4_board_2_2:
                game.markBoard(2, 2);
                break;
            case R.id.Grid4x4_board_2_3:
                game.markBoard(2, 3);
                break;
            case R.id.Grid4x4_board_3_0:
                game.markBoard(3, 0);
                break;
            case R.id.Grid4x4_board_3_1:
                game.markBoard(3, 1);
                break;
            case R.id.Grid4x4_board_3_2:
                game.markBoard(3, 2);
                break;
            case R.id.Grid4x4_board_3_3:
                game.markBoard(3, 3);
                break;
        }
        updateScreen();
        if (game.isGameFinished()) {
            matchHistory.saveMatch(game.getMatchDetails((String) player2Name.getText()));
        }
    }

    @Override
    public void collectThemeElements() {
        //content = R.id.content_4x4_grid;
        buttons.add((Button) findViewById(R.id.Grid4x4_board_0_0));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_0_1));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_0_2));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_0_3));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_1_0));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_1_1));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_1_2));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_1_3));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_2_0));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_2_1));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_2_2));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_2_3));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_3_0));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_3_1));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_3_2));
        buttons.add((Button) findViewById(R.id.Grid4x4_board_3_3));
    }

    public void Grid4x4_ResetButton(View view) {
        game.resetGame();
        updateScreen();
    }

    public void updateScreen() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GameBoard.Mark[][] board = game.getGameBoard();

                if (game.isPlayer1Turn()) {
                    StarPlayer1.setVisibility(View.VISIBLE);
                    StarPlayer2.setVisibility(View.INVISIBLE);
                    thinkingBar.setVisibility(View.INVISIBLE);
                } else if (!game.isPlayer1Turn()) {
                    StarPlayer1.setVisibility(View.INVISIBLE);
                    StarPlayer2.setVisibility(View.VISIBLE);
                    thinkingBar.setVisibility(View.VISIBLE);
                }

                if (applicationSettings.getBotDifficulty() <= 0)
                    thinkingBar.setVisibility(View.INVISIBLE);

                Grid4x4_board_0_0.setText(board[0][0].toString());
                Grid4x4_board_0_1.setText(board[0][1].toString());
                Grid4x4_board_0_2.setText(board[0][2].toString());
                Grid4x4_board_0_3.setText(board[0][3].toString());
                Grid4x4_board_1_0.setText(board[1][0].toString());
                Grid4x4_board_1_1.setText(board[1][1].toString());
                Grid4x4_board_1_2.setText(board[1][2].toString());
                Grid4x4_board_1_3.setText(board[1][3].toString());
                Grid4x4_board_2_0.setText(board[2][0].toString());
                Grid4x4_board_2_1.setText(board[2][1].toString());
                Grid4x4_board_2_2.setText(board[2][2].toString());
                Grid4x4_board_2_3.setText(board[2][3].toString());
                Grid4x4_board_3_0.setText(board[3][0].toString());
                Grid4x4_board_3_1.setText(board[3][1].toString());
                Grid4x4_board_3_2.setText(board[3][2].toString());
                Grid4x4_board_3_3.setText(board[3][3].toString());
            }
        });
    }
}
