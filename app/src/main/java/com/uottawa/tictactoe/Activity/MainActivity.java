package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.GameActivities.Multiplayer.NameSelectionActivity;
import com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer.SinglePlayerBoardSizeActivity;
import com.uottawa.tictactoe.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_main);
    }

    public void btnSinglePlayer(View view){
        Intent intent = new Intent(this, SinglePlayerBoardSizeActivity.class);
        startActivityForResult(intent, 1);
    }

    public void btnMultiPlayer(View view){
        Intent intent = new Intent(this, NameSelectionActivity.class);
        startActivity(intent);
    }

    public void btnMatchHistory(View view){
        Intent intent = new Intent(this, MatchHistoryActivity.class);
        startActivity(intent);
    }

    public void btnOption(View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void btnRule(View view){

        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
    }
}
