package com.example.michiel.vaardigheidstoetstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyHighScore extends AppCompatActivity {

    TextView highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_high_score);
        highScore = (TextView) findViewById(R.id.txtView_MyHighScore);
        Intent change = getIntent();
        long highScoreValue = change.getLongExtra("highScore",0);
        highScore.setText("My high score = " + Long.toString(highScoreValue));
    }
}
