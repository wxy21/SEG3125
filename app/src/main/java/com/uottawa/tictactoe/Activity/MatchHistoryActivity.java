package com.uottawa.tictactoe.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class MatchHistoryActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_match_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
