package com.uottawa.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String player1;
    private TextView player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Setting.class);
            //startActivityForResult(intent, 2);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);

        if(resultCode == 1){
            player1 = data.getStringExtra("player1");
        }

        if(resultCode == 2){
            player2 = (TextView) findViewById(R.id.textName);
        }

    }

    public void btnSinglePlayer(View view){
        Intent intent = new Intent(this, name.class);
        startActivityForResult(intent, 1);
    }

    public void btnMultiPlayer(View view){
        Intent intent = new Intent(this, name.class);
        startActivityForResult(intent, 2);
    }

    public void btnMatchHistory(View view){
        Intent intent = new Intent(this, match_history.class);
        startActivity(intent);
    }

    public void btnHelp(View view){
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

    public void btnExit(View view){
        System.exit(0);
    }
}
