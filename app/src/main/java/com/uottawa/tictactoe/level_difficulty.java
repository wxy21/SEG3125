package com.uottawa.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class level_difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_difficulty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void btn_easy(View view){
        Intent intent = new Intent(this, easy_game.class);
        startActivity(intent);
    }

    public void btn_medium(View view){
        Intent intent = new Intent(this, medium_game.class);
        startActivity(intent);
    }

    public void btn_hard(View view){
        Intent intent = new Intent(this, hard_game.class);
        startActivity(intent);
    }
}
