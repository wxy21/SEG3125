package com.uottawa.tictactoe.Activity.GameActivities.Multiplayer;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.ApplicationSettings;
import com.uottawa.tictactoe.AvatarList;
import com.uottawa.tictactoe.ItemData;
import com.uottawa.tictactoe.R;
import com.uottawa.tictactoe.SpinnerAdapter;

import java.util.ArrayList;

public class NameSelectionActivity extends BaseActivity {

    private AvatarList avatarList;

    private int player1_avatar;
    private String player1_name;
    private int player1_position;
    private ApplicationSettings applicationSettings;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_name);

        //Avatar Spinner
        avatarList = new AvatarList();

        ArrayList<ItemData> avatar_list = avatarList.getAvatarList();
        //avatar_id = avatarList.getImageID();
        Spinner player1Avatar_name = (Spinner) findViewById(R.id.name_player1Avatar);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_avatar_layout, avatar_list);
        player1Avatar_name.setAdapter(adapter);


        player1_position = applicationSettings.getPlayer1Avatar();
        player1Avatar_name.setSelection(player1_position);

        player1Avatar_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                player1_position = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });

        Spinner player2Avatar_name = (Spinner) findViewById(R.id.name_Player2Avatar);
    }

    public void btnOK_name(View view){
        Intent intent = new Intent(this, MultiplayerBoardSizeActivity.class);
        startActivityForResult(intent, 4);
    }
}
