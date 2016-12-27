package com.blkxltng.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //For HighScore
    SharedPreferences prefs;
    String dataName = "MyData";
    String intName = "MyInt";
    int defaultInt = 0;
    public static int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        highScore = prefs.getInt(intName, defaultInt);
        TextView textHighScore = (TextView) findViewById(R.id.textHighScore);
        textHighScore.setText("High Score: " + highScore);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button) {
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);
        }
    }
}
