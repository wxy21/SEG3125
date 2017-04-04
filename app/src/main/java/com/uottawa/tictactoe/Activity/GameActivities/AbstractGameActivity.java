package com.uottawa.tictactoe.Activity.GameActivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.DataStructures.MatchDetails;
import com.uottawa.tictactoe.GameLogic.GameInterface;
import com.uottawa.tictactoe.R;

import java.util.List;

public abstract class AbstractGameActivity extends BaseActivity {

    GameInterface game;

    boolean player1HasWon = false;
    boolean isATie = false;
    boolean resetScreenWasShown = false;

    private String gameTitle;
    private String gameMessage;

    LinearLayout player1Layout;
    TextView player1Name;
    ImageView player1Avatar;

    LinearLayout player2Layout;
    TextView player2Name;
    ImageView player2Avatar;

    ImageView StarPlayer1;
    ImageView StarPlayer2;
    ProgressBar thinkingBar;

    @Override
    protected void loadView() {}

    @Override
    protected void collectThemeElements() {}

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
                        player1HasWon = false;
                        isATie = false;
                        resetScreenWasShown = false;
                        setGameClickable(true);
                        updateScreen();
                    }
                })
                .setPositiveButton("No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
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

    public void dialogTitle_Msg(String game_result, String opponent_name){
        String name;
        if(opponent_name == player1Name.getText().toString()){
            name = player2Name.getText().toString();
        }else{
            name = player1Name.getText().toString();
        }
        if(game_result == "WIN"){
            player1HasWon = true;
            isATie = false;
            gameTitle = "Congratulations!";
            gameMessage = "Congratulation " + name + ", You Won!";
        }else if(game_result == "LOSS"){
            player1HasWon = false;
            isATie = false;
            gameTitle = "Ooops!";
            gameMessage = "Sorry, " + name + ", You Lost!";
        }else{
            isATie = true;
            gameTitle = "Tie!";
            gameMessage = "Hmm...It's A Tie!";
        }
    }

    public void displayResult(){
        matchHistory.loadMatches();
        List<MatchDetails> details = matchHistory.getMatchDetails();
        MatchDetails currentMatch = details.get(details.size() - 1);
        String gameResult= currentMatch.getResult().print();
        String opponentName = currentMatch.getOpponentName();
        dialogTitle_Msg(gameResult, opponentName);

        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.Theme_Sphinx);
        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(ctw);
        alertDialogbuilder
                .setTitle(gameTitle)
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

    public void hideElementsAtTheEndOfGame() {
        if (game.isGameFinished() && resetScreenWasShown) {
            StarPlayer1.setVisibility(View.INVISIBLE);
            StarPlayer2.setVisibility(View.INVISIBLE);
            thinkingBar.setVisibility(View.INVISIBLE);

            if (isATie) {
                player1Layout.setBackgroundColor(Color.GRAY);
                player2Layout.setBackgroundColor(Color.GRAY);
            } else if (player1HasWon) {
                player1Layout.setBackgroundColor(Color.GREEN);
                player2Layout.setBackgroundColor(Color.RED);
                StarPlayer1.setVisibility(View.VISIBLE);
            } else {
                player1Layout.setBackgroundColor(Color.RED);
                player2Layout.setBackgroundColor(Color.GREEN);
                StarPlayer2.setVisibility(View.VISIBLE);
            }
        }
    }

    public abstract void setGameClickable(boolean value);
    public abstract void updateScreen();

    public void GameOver() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (game.isGameFinished()) {
                    displayResult();
                    resetScreenWasShown = true;
                }
            }
        });
    }
}
