package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.uottawa.tictactoe.Activity.GameActivities.Multiplayer.NameSelectionActivity;
import com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer.SinglePlayerBoardSizeActivity;
import com.uottawa.tictactoe.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_main;
        buttons.add((Button) findViewById(R.id.main_single_player));
        buttons.add((Button) findViewById(R.id.main_multiplayer));
        buttons.add((Button) findViewById(R.id.main_match_history));
        buttons.add((Button) findViewById(R.id.main_rules));
        buttons.add((Button) findViewById(R.id.main_options));
    }

    public void btnSinglePlayer(View view){
        Intent intent = new Intent(this, SinglePlayerBoardSizeActivity.class);
        startActivity(intent);
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
