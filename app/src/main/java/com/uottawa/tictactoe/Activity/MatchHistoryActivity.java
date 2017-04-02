package com.uottawa.tictactoe.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.DataStructures.MatchDetails;
import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.R;

public class MatchHistoryActivity extends BaseActivity {

    LinearLayout date;
    LinearLayout opponent;
    LinearLayout result;

    @Override
    protected void loadView() {
        content = R.id.content_match_history;
        setContentView(R.layout.activity_match_history);
        date = (LinearLayout) findViewById(R.id.matchHistory_date);
        opponent = (LinearLayout) findViewById(R.id.matchHistory_Opponent);
        result = (LinearLayout) findViewById(R.id.matchHistory_result);

        for(MatchDetails detail : matchHistory.getMatchDetails()) {
            createMatchEntry(detail);
        }
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_match_history;
        textViews.add((TextView) findViewById(R.id.matchHistory_title));
    }

    public void createMatchEntry(MatchDetails details) {

        int textSize = 20;

        TextView dateEntry = new TextView(this);
        dateEntry.setText(details.getDateAsString());
        dateEntry.setLayoutParams(new Toolbar.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
//        dateEntry.setGravity(Gravity.CENTER_HORIZONTAL);
        dateEntry.setTextSize(textSize);


        TextView opponentEntry = new TextView(this);
        opponentEntry.setText(details.getOpponentName());
        opponentEntry.setLayoutParams(new Toolbar.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
//        opponentEntry.setGravity(Gravity.CENTER_HORIZONTAL);
        opponentEntry.setTextSize(textSize);


        TextView resultEntry = new TextView(this);
        resultEntry.setText(details.getResult().print());
        resultEntry.setLayoutParams(new Toolbar.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
//        resultEntry.setGravity(Gravity.CENTER_HORIZONTAL);
        resultEntry.setTextSize(textSize);

        if (details.getResult().equals(GameBoard.GameState.XWIN)) {
            // Dark green
            dateEntry.setTextColor(Color.rgb(34,139,34));
            opponentEntry.setTextColor(Color.rgb(34,139,34));
            resultEntry.setTextColor(Color.rgb(34,139,34));
        } else if (details.getResult().equals(GameBoard.GameState.OWIN)) {
            dateEntry.setTextColor(Color.RED);
            opponentEntry.setTextColor(Color.RED);
            resultEntry.setTextColor(Color.RED);
        } else {
            dateEntry.setTextColor(Color.GRAY);
            opponentEntry.setTextColor(Color.GRAY);
            resultEntry.setTextColor(Color.GRAY);
        }

        date.addView(dateEntry);
        opponent.addView(opponentEntry);
        result.addView(resultEntry);
    }
}
