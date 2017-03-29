package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.Game.NameSelectionActivity;
import com.uottawa.tictactoe.R;

public class MainActivity extends BaseActivity {

    private String player1;
    private TextView player2;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);

        if(resultCode == 1){
            player1 = data.getStringExtra("player1");
        }

        if(resultCode == 2){
        }

    }

    public void btnSinglePlayer(View view){
        Intent intent = new Intent(this, NameSelectionActivity.class);
        startActivityForResult(intent, 1);
    }

    public void btnMultiPlayer(View view){
        Intent intent = new Intent(this, NameSelectionActivity.class);
        startActivityForResult(intent, 2);
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
