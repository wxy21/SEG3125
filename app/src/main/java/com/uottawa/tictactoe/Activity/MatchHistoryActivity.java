package com.uottawa.tictactoe.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class MatchHistoryActivity extends BaseActivity {

    @Override
    protected void loadView() {
        content = R.id.content_match_history;
        setContentView(R.layout.activity_match_history);
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_match_history;
        textViews.add((TextView) findViewById(R.id.matchHistory_title));
    }
}
