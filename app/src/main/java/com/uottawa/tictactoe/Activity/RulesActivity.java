package com.uottawa.tictactoe.Activity;

import android.widget.TextView;

import com.uottawa.tictactoe.R;

public class RulesActivity extends BaseActivity {

    @Override
    protected void loadView() {
        content = R.id.content_rules;
        setContentView(R.layout.activity_instructions);
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_rules;
        textViews.add((TextView) findViewById(R.id.rules_text));
        textViews.add((TextView) findViewById(R.id.rules_title));
    }

}
