package com.uottawa.tictactoe.Activity.GameActivities;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.MainActivity;
import com.uottawa.tictactoe.R;

public class EasyGameActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_game_easy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    public void btnReset_egame(View view){
        Button btn = (Button) findViewById(R.id.button);
        btn.setText("");
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setText("");
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setText("");
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setText("");
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setText("");
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setText("");
        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setText("");
        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setText("");
        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setText("");
        
    }

    public void btnHome_egame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnExit_egame(View view){
        System.exit(0);
    }
}
