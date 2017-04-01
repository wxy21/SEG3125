package com.uottawa.tictactoe.Activity.GameActivities.Multiplayer;

import android.support.v7.widget.Toolbar;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.R;

public class MultiplayerBoardSizeActivity extends BaseActivity {

    @Override
    protected void loadView() {
        content = R.id.content_grid_size;
        setContentView(R.layout.activity_grid_size);
    }
}
