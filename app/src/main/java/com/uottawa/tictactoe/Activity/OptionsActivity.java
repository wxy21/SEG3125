package com.uottawa.tictactoe.Activity;

import android.support.v7.widget.Toolbar;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.SpinnerAdapter;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_option);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText player1 = (EditText) findViewById(R.id.options_Player1Name);
        player1.setText(applicationSettings.getPlayer1Name());

        ArrayList<ItemData> avatar_list = new ArrayList<>();
        avatar_list.add(new ItemData(R.drawable.avatar1));
        avatar_list.add(new ItemData(R.drawable.avatar2));
        avatar_list.add(new ItemData(R.drawable.avatar3));
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, avatar_list);
        Spinner player1Avatar = (Spinner) findViewById(R.id.options_Player1Avatar);
        player1Avatar.setAdapter(adapter);

        Spinner applicationTheme = (Spinner) findViewById(R.id.options_ApplicationTheme);
        SeekBar soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        SeekBar soundMusic = (SeekBar) findViewById(R.id.options_MusicVolume);
    }


}
