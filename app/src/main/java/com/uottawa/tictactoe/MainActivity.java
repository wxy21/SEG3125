package com.uottawa.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String player1;
    private TextView player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Intent intent = new Intent(this, name.class);
        startActivityForResult(intent, 1);
    }

    public void btnMultiPlayer(View view){
        Intent intent = new Intent(this, name.class);
        startActivityForResult(intent, 2);
    }

    public void btnMatchHistory(View view){
        Intent intent = new Intent(this, match_history.class);
        startActivity(intent);
    }

    public void btnOption(View view){
        Intent intent = new Intent(this, option.class);
        startActivity(intent);
    }

    public void btnRule(View view){

        Intent intent = new Intent(this, rules.class);
        startActivity(intent);
    }
}
