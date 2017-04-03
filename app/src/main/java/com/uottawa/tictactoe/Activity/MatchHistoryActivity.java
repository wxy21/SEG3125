package com.uottawa.tictactoe.Activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
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

        int matchesCount = 0;
        int winsCount = 0;
        for(MatchDetails detail : matchHistory.getMatchDetails()) {
            createMatchEntry(detail);
            matchesCount++;
            if (detail.getResult().print().contains("WIN"))
                winsCount++;
        }

        if (matchHistory.getMatchDetails().size() <= 0) {
            TextView notPlayedAGameEntry = new TextView(this);
            notPlayedAGameEntry.setText("You have not played a game yet!");
            notPlayedAGameEntry.setLayoutParams(new TableRow.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            notPlayedAGameEntry.setTextSize(20);
            notPlayedAGameEntry.setAllCaps(true);
            notPlayedAGameEntry.setPadding(10,10,10,10);
            opponent.addView(notPlayedAGameEntry);
        }

        TextView totalMatches = (TextView) findViewById(R.id.matchHistory_total);
        totalMatches.setText("Total: " + matchesCount);

        TextView wins = (TextView) findViewById(R.id.matchHistory_wins);
        wins.setText("Wins: " + winsCount);
        wins.setGravity(Gravity.RIGHT);
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_match_history;
        textViews.add((TextView) findViewById(R.id.matchHistory_title));
    }

    public void createMatchEntry(MatchDetails details) {

        int textSize = 20;
//        ShapeDrawable sd = new ShapeDrawable();
//        sd.setShape(new RectShape());
//        sd.getPaint().setColor(applicationSettings.getTheme().getThemeColor());
//        sd.getPaint().setStrokeWidth(10f);
//        sd.getPaint().setStyle(Paint.Style.STROKE);

        TextView dateEntry = new TextView(this);
        dateEntry.setText(details.getDateAsString());
        dateEntry.setLayoutParams(new TableRow.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        dateEntry.setTextSize(textSize);
        dateEntry.setAllCaps(true);
        dateEntry.setPadding(10,10,10,10);
//        dateEntry.setBackground(sd);


        TextView opponentEntry = new TextView(this);
        opponentEntry.setText(details.getOpponentName());
        opponentEntry.setLayoutParams(new TableRow.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        opponentEntry.setTextSize(textSize);
        opponentEntry.setAllCaps(true);
        opponentEntry.setPadding(10,10,10,10);
//        opponentEntry.setBackground(sd);


        TextView resultEntry = new TextView(this);
        resultEntry.setText(details.getResult().print());
        resultEntry.setLayoutParams(new TableRow.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        resultEntry.setTextSize(textSize);
        resultEntry.setAllCaps(true);
        resultEntry.setPadding(0,10,0,10);
//        resultEntry.setBackground(sd);

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
            dateEntry.setTextColor(Color.BLACK);
            opponentEntry.setTextColor(Color.BLACK);
            resultEntry.setTextColor(Color.BLACK);
        }

        date.addView(dateEntry);
        opponent.addView(opponentEntry);
        result.addView(resultEntry);


        //System.out.println(date.g);
    }
}
