package com.uottawa.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class hard_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void btnReset_hgame(View view){
        Button btn1 = (Button) findViewById(R.id.button_h1);
        btn1.setText("");
        Button btn2 = (Button) findViewById(R.id.button_h2);
        btn2.setText("");
        Button btn3 = (Button) findViewById(R.id.button_h3);
        btn3.setText("");
        Button btn4 = (Button) findViewById(R.id.button_h4);
        btn4.setText("");
        Button btn5 = (Button) findViewById(R.id.button_h5);
        btn5.setText("");
        Button btn6 = (Button) findViewById(R.id.button_h6);
        btn6.setText("");
        Button btn7 = (Button) findViewById(R.id.button_h7);
        btn7.setText("");
        Button btn8 = (Button) findViewById(R.id.button_h8);
        btn8.setText("");
        Button btn9 = (Button) findViewById(R.id.button_h9);
        btn9.setText("");
        Button btn10 = (Button) findViewById(R.id.button_h10);
        btn10.setText("");
        Button btn11 = (Button) findViewById(R.id.button_h11);
        btn11.setText("");
        Button btn12 = (Button) findViewById(R.id.button_h12);
        btn12.setText("");
        Button btn13 = (Button) findViewById(R.id.button_h13);
        btn13.setText("");
        Button btn14 = (Button) findViewById(R.id.button_h14);
        btn14.setText("");
        Button btn15 = (Button) findViewById(R.id.button_h15);
        btn15.setText("");
        Button btn16 = (Button) findViewById(R.id.button_h16);
        btn16.setText("");
        Button btn17 = (Button) findViewById(R.id.button_h17);
        btn17.setText("");
        Button btn18 = (Button) findViewById(R.id.button_h18);
        btn18.setText("");
        Button btn19 = (Button) findViewById(R.id.button_h19);
        btn19.setText("");
        Button btn20 = (Button) findViewById(R.id.button_h20);
        btn20.setText("");
    }

    public void btnHome_hgame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnExit_hgame(View view){
        System.exit(0);
    }
}
