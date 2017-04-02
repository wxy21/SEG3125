package com.uottawa.tictactoe.Activity.GameActivities;

import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.SinglePlayerGame;
import com.uottawa.tictactoe.R;

public class Grid3x3BoardActivity extends BaseActivity implements View.OnClickListener {

    SinglePlayerGame singlePlayerGame;
    TextView Grid3x3_board_0_0;
    TextView Grid3x3_board_0_1;
    TextView Grid3x3_board_0_2;
    TextView Grid3x3_board_1_0;
    TextView Grid3x3_board_1_1;
    TextView Grid3x3_board_1_2;
    TextView Grid3x3_board_2_0;
    TextView Grid3x3_board_2_1;
    TextView Grid3x3_board_2_2;

    TextView player1Name;
    ImageView player1Avatar;
    TextView player1Mark;

    ImageView StarPlayer1;
    ImageView StarPlayer2;
    ProgressBar thinkingBar;

    @Override
    protected void loadView() {
        singlePlayerGame = new SinglePlayerGame(3, 2);
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

        player1Name = (TextView) findViewById(R.id.Grid3x3_Player1Name);
        player1Name.setText(applicationSettings.getPlayer1Name());

        player1Avatar = (ImageView) findViewById(R.id.Grid3x3_Player1Avatar);
        player1Avatar.setImageResource(applicationSettings.getPlayer1Avatar());
      //  player1Mark = (TextView) findViewById(R.id.Grid3x3_Player1Name);

        StarPlayer1 = (ImageView) findViewById(R.id.Grid3x3_Star_Player1);
        StarPlayer2 = (ImageView) findViewById(R.id.Grid3x3_Star_Player2);
        thinkingBar = (ProgressBar) findViewById(R.id.Grid3x3_loading);
        updateScreen();
    }

    public void onClick(View v) {

        if (singlePlayerGame.isPlayer1Turn() && !singlePlayerGame.isGameFinished()) {
            switch (v.getId()) {
                case R.id.Grid3x3_board_0_0:
                    singlePlayerGame.markBoardPlayer(0, 0);
                    break;
                case R.id.Grid3x3_board_0_1:
                    singlePlayerGame.markBoardPlayer(0, 1);
                    break;
                case R.id.Grid3x3_board_0_2:
                    singlePlayerGame.markBoardPlayer(0, 2);
                    break;
                case R.id.Grid3x3_board_1_0:
                    singlePlayerGame.markBoardPlayer(1, 0);
                    break;
                case R.id.Grid3x3_board_1_1:
                    singlePlayerGame.markBoardPlayer(1, 1);
                    break;
                case R.id.Grid3x3_board_1_2:
                    singlePlayerGame.markBoardPlayer(1, 2);
                    break;
                case R.id.Grid3x3_board_2_0:
                    singlePlayerGame.markBoardPlayer(2, 0);
                    break;
                case R.id.Grid3x3_board_2_1:
                    singlePlayerGame.markBoardPlayer(2, 1);
                    break;
                case R.id.Grid3x3_board_2_2:
                    singlePlayerGame.markBoardPlayer(2, 2);
                    break;
            }
            updateScreen();
        }
        if (!singlePlayerGame.isPlayer1Turn() && !singlePlayerGame.isGameFinished()) {
            singlePlayerGame.markBoardAI();
            updateScreen();
        }
    }

    public void Grid3x3_ResetButton(View view) {
        singlePlayerGame.resetGame();
        updateScreen();
    }

    public void updateScreen() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GameBoard.Mark[][] board = singlePlayerGame.getGameBoard();

                if (singlePlayerGame.isPlayer1Turn()) {
                    StarPlayer1.setVisibility(View.VISIBLE);
                    StarPlayer2.setVisibility(View.INVISIBLE);
                    thinkingBar.setVisibility(View.INVISIBLE);
                } else if (!singlePlayerGame.isPlayer1Turn()) {
                    StarPlayer1.setVisibility(View.INVISIBLE);
                    StarPlayer2.setVisibility(View.VISIBLE);
                    thinkingBar.setVisibility(View.VISIBLE);
                }

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



}
