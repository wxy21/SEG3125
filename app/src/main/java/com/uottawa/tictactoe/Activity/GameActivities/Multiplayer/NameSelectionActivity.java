package com.uottawa.tictactoe.Activity.GameActivities.Multiplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.uottawa.tictactoe.Activity.BaseActivity;
import com.uottawa.tictactoe.DataStructures.Avatar.AvatarList;
import com.uottawa.tictactoe.DataStructures.Avatar.Avatar;
import com.uottawa.tictactoe.R;
import com.uottawa.tictactoe.DataStructures.Avatar.AvatarSpinnerAdapter;

import java.util.ArrayList;

public class NameSelectionActivity extends BaseActivity {

    private AvatarList avatarList;

    private TextView player1_name;
    private int avatarPosition1;

    private TextView player2_name;
    private int avatarPosition2;

    @Override
    protected void loadView() {
        content = R.id.content_name;
        setContentView(R.layout.activity_name);

        //Player1 Name
        player1_name = (TextView) findViewById(R.id.name_Player1Name);
        player1_name.setText(applicationSettings.getPlayer1Name());
        player1_name.setGravity(Gravity.CENTER);

        //Avatar Spinner
        avatarList = new AvatarList();
        ArrayList<Avatar> avatar_list = avatarList.getAvatarList();
        AvatarSpinnerAdapter adapter = new AvatarSpinnerAdapter(this, R.layout.spinner_avatar_layout, avatar_list);

        //Player 1 Avatar
        Spinner player1_avatar = (Spinner) findViewById(R.id.name_player1Avatar);
        player1_avatar.setAdapter(adapter);

        // Set Avatar spinner based on previous application settings
        int selectedPlayer1AvatarId = applicationSettings.getPlayer1Avatar();
        avatarPosition1 = adapter.getPosition(new Avatar(selectedPlayer1AvatarId));
        player1_avatar.setSelection(avatarPosition1);

        player1_avatar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                avatarPosition1 = parent.getSelectedItemPosition();
                clickSound();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });

        //Player 2 Name
        player2_name = (TextView) findViewById(R.id.name_Player2Name);
        player2_name.setText(applicationSettings.getPlayer2Name());
        player2_name.setGravity(Gravity.CENTER);

        //Player 2 Avatar
        Spinner player2_avatar = (Spinner) findViewById(R.id.name_Player2Avatar);
        player2_avatar.setAdapter(adapter);

        // Set Avatar spinner based on previous application settings
        int selectedPlayer2AvatarId = applicationSettings.getPlayer2Avatar();
        avatarPosition2 = adapter.getPosition(new Avatar(selectedPlayer2AvatarId));
        player2_avatar.setSelection(avatarPosition2);

        player2_avatar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                avatarPosition2 = parent.getSelectedItemPosition();
                clickSound();
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){
                //do nothing
            }
        });
    }

    @Override
    protected void collectThemeElements() {
        content = R.id.content_name;
        textViews.add((TextView) findViewById(R.id.name_title));
        textViews.add((TextView) findViewById(R.id.name_player1Title));
        textViews.add((TextView) findViewById(R.id.name_player2Title));
        buttons.add((Button) findViewById(R.id.name_btnOK));
    }

    public void btnOK_name(View view){
        clickSound();

        String player1Name = player1_name.getText().toString();
        int player1AvatarID = avatarList.getAvatarList().get(avatarPosition1).getImageId();
        String player2Name = player2_name.getText().toString();
        int player2AvatarID = avatarList.getAvatarList().get(avatarPosition2).getImageId();
        applicationSettings.savePlayerInformation(player1Name, player1AvatarID, player2Name, player2AvatarID);

        // The game is multiplayer
        applicationSettings.saveBotDiffuculty(-1);

        Intent intent = new Intent(this, MultiplayerBoardSizeActivity.class);
        startActivity(intent);
    }
}
