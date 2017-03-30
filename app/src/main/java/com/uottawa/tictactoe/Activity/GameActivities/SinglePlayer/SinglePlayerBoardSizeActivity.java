package com.uottawa.tictactoe.Activity.GameActivities.SinglePlayer;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.Activity.RulesActivity;
import com.uottawa.tictactoe.R;

public class SinglePlayerBoardSizeActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_grid_size);

    }

    public void btn_grid(View view){

        Intent intent = new Intent(this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

}
