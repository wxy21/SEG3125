package com.uottawa.tictactoe.Activity.Game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class LevelDifficultyActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_level_difficulty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void btn_easy(View view){
        Intent intent = new Intent(this, EasyGameActivity.class);
        startActivity(intent);
    }

    public void btn_medium(View view){
        Intent intent = new Intent(this, MediumGameActivity.class);
        startActivity(intent);
    }

    public void btn_hard(View view){
        Intent intent = new Intent(this, HardGameActivity.class);
        startActivity(intent);
    }
}
