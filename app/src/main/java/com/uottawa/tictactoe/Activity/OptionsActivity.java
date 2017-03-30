package com.uottawa.tictactoe.Activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.SpinnerAdapter;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {
    int avatar_position;
    public AvatarList avatarList;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_option);


        ArrayList<ItemData> avatar_list = AvatarList.getAvatarList();
        //TextView player1 = (TextView) findViewById(R.id.options_Player1Name);
        //player1.setText(AvatarList.getAvatarList().size());
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, AvatarList.getAvatarList());
        Spinner player1Avatar_option = (Spinner) findViewById(R.id.options_Player1Avatar);
        player1Avatar_option.setAdapter(adapter);

        player1Avatar_option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                avatar_position = parent.getSelectedItemPosition();
                applicationSettings.saveAvatar(avatar_position);
                //avatarList.setAvatar(position);
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });

        //applicationSettings.getPlayer1Avatar();
        // From avatar - > show the correct avatar on the screen.
        // int spinnerPosition = adapter.getPosition(compareValue);
        // mSpinner.setSelection(spinnerPosition);

        Spinner applicationTheme = (Spinner) findViewById(R.id.options_ApplicationTheme);
        SeekBar soundVolume = (SeekBar) findViewById(R.id.options_SoundVolume);
        SeekBar soundMusic = (SeekBar) findViewById(R.id.options_MusicVolume);
    }


}
