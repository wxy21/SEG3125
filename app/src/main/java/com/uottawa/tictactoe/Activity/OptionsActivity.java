package com.uottawa.tictactoe.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.*;
import android.widget.SpinnerAdapter;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.uottawa.tictactoe.*;
import com.uottawa.tictactoe.Activity.BaseActivity;

import java.util.ArrayList;

public class OptionsActivity extends BaseActivity {

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_option);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<ItemData> avatar_list = new ArrayList<>();
        avatar_list.add(new ItemData(R.drawable.mini1));
        avatar_list.add(new ItemData(R.drawable.avatar2));
        avatar_list.add(new ItemData(R.drawable.avatar3));
        Spinner avatar_sp = (Spinner) findViewById(R.id.spinner_avatar);
        com.uottawa.tictactoe.SpinnerAdapter adapter = new com.uottawa.tictactoe.SpinnerAdapter(this, R.layout.spinner_layout, avatar_list);
        avatar_sp.setAdapter(adapter);
    }


}
