package com.uottawa.tictactoe.Activity.GameActivities.Multiplayer;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer.LevelDifficultyActivity;
import com.uottawa.tictactoe.R;

public class NameSelectionActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void btnOK_name(View view){
        Intent intent = new Intent(this, MultiplayerBoardSizeActivity.class);
        startActivityForResult(intent, 4);
    }
}
