package com.uottawa.tictactoe.Activity.Game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.Game.LevelDifficultyActivity;
import com.uottawa.tictactoe.R;

public class NameSelectionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void btnOK_name(View view){
        Intent intent = new Intent(this, LevelDifficultyActivity.class);

        startActivityForResult(intent, 4);
    }
}
