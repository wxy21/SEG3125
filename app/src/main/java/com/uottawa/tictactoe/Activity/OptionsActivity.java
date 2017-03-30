package com.uottawa.tictactoe.Activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.SpinnerAdapter;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {
    private int avatar_position;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_option);


        ArrayList<ItemData> avatar_list = AvatarList.getAvatarList();

        Spinner player1Avatar_option = (Spinner) findViewById(R.id.options_Player1Avatar);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, avatar_list);
        player1Avatar_option.setAdapter(adapter);

        player1Avatar_option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                avatar_position = parent.getSelectedItemPosition();
                //applicationSettings.saveAvatar(avatar_position);
                //AvatarList.setAvatar(avatar_position);
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });

        //applicationSettings.saveAvatar(avatar_position);
        //applicationSettings.getPlayer1Avatar();
        // From avatar - > show the correct avatar on the screen.
        // int spinnerPosition = adapter.getPosition(compareValue);
        // mSpinner.setSelection(spinnerPosition);

        Spinner applicationTheme = (Spinner) findViewById(R.id.options_ApplicationTheme);
        SeekBar soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        SeekBar soundMusic = (SeekBar) findViewById(R.id.options_MusicVolume);
    }

    public void btnApply(View view){
        AvatarList.setAvatar(avatar_position);
        super.onBackPressed();
    }
}
