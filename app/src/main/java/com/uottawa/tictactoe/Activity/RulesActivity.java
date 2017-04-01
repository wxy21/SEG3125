package com.uottawa.tictactoe.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class RulesActivity extends BaseActivity {

    @Override
    protected void loadView() {
        content = R.id.content_rules;
        setContentView(R.layout.activity_rules);
    }

}
