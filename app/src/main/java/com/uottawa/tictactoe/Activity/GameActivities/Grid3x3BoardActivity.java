package com.uottawa.tictactoe.Activity.GameActivities;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.MainActivity;
import com.uottawa.tictactoe.R;

public class Grid3x3BoardActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_3x3_grid);
    }



    public void Grid3x3_ResetButton(View view){
        TextView Grid3x3_board_0_0 = (TextView) findViewById(R.id.Grid3x3_board_0_0);
        Grid3x3_board_0_0.setText("");
        TextView Grid3x3_board_0_1 = (TextView) findViewById(R.id.Grid3x3_board_0_1);
        Grid3x3_board_0_1.setText("");
        TextView Grid3x3_board_0_2 = (TextView) findViewById(R.id.Grid3x3_board_0_2);
        Grid3x3_board_0_2.setText("");

        TextView Grid3x3_board_1_0 = (TextView) findViewById(R.id.Grid3x3_board_1_0);
        Grid3x3_board_1_0.setText("");
        TextView Grid3x3_board_1_1 = (TextView) findViewById(R.id.Grid3x3_board_1_1);
        Grid3x3_board_1_1.setText("");
        TextView Grid3x3_board_1_2 = (TextView) findViewById(R.id.Grid3x3_board_1_2);
        Grid3x3_board_1_2.setText("");

        TextView Grid3x3_board_2_0 = (TextView) findViewById(R.id.Grid3x3_board_2_0);
        Grid3x3_board_2_0.setText("");
        TextView Grid3x3_board_2_1 = (TextView) findViewById(R.id.Grid3x3_board_2_1);
        Grid3x3_board_2_1.setText("");
        TextView Grid3x3_board_2_2 = (TextView) findViewById(R.id.Grid3x3_board_2_2);
        Grid3x3_board_2_2.setText("");

    }


}
