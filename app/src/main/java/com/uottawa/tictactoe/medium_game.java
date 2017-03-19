package com.uottawa.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class medium_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void btnReset_mgame(View view){
        String test = "test";
        Button btn1 = (Button) findViewById(R.id.button_m1);
        btn1.setText("");
        Button btn2 = (Button) findViewById(R.id.button_m2);
        btn2.setText("");
        Button btn3 = (Button) findViewById(R.id.button_m3);
        btn3.setText("");
        Button btn4 = (Button) findViewById(R.id.button_m4);
        btn4.setText("");
        Button btn5 = (Button) findViewById(R.id.button_m5);
        btn5.setText("");
        Button btn6 = (Button) findViewById(R.id.button_m6);
        btn6.setText("");
        Button btn7 = (Button) findViewById(R.id.button_m7);
        btn7.setText("");
        Button btn8 = (Button) findViewById(R.id.button_m8);
        btn8.setText("");
        Button btn9 = (Button) findViewById(R.id.button_m9);
        btn9.setText("");
        Button btn10 = (Button) findViewById(R.id.button_m10);
        btn10.setText("");
        Button btn11 = (Button) findViewById(R.id.button_m11);
        btn11.setText("");
        Button btn12 = (Button) findViewById(R.id.button_m12);
        btn12.setText("");
        Button btn13 = (Button) findViewById(R.id.button_m13);
        btn13.setText("");
        Button btn14 = (Button) findViewById(R.id.button_m14);
        btn14.setText("");
        Button btn15 = (Button) findViewById(R.id.button_m15);
        btn15.setText("");
        Button btn16 = (Button) findViewById(R.id.button_m16);
        btn16.setText("");
    }

    public void btnHome_mgame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnExit_mgame(View view){
        System.exit(0);
    }
}
