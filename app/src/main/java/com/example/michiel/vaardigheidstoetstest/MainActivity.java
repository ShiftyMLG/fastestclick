package com.example.michiel.vaardigheidstoetstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    TextView previousScoreText;
    String lastScore;

    Button toggleCount;

    long currentTime;
    long difference;
    long highScore = 0;

    boolean checkClick = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousScoreText = (TextView) findViewById(R.id.txt_PreviousScore);
        toggleCount = (Button) findViewById(R.id.btn_StartStop);
    }




    public void LeaderboardActivity(View view) {
        Intent change = new Intent(this, Leaderboard.class);
        startActivity(change);
    }

    public void MyHighScoreActivity(View view) {
        Intent change = new Intent(this, MyHighScore.class);
        change.putExtra("highScore", highScore);
        startActivity(change);
    }

    public void Counting(View view) {
        checkClick = !checkClick;
        if(!checkClick){
            currentTime = System.currentTimeMillis();
        }
        else if(checkClick) {
            difference = System.currentTimeMillis() - currentTime;
            lastScore = Long.toString(difference);
            previousScoreText.setText(lastScore + "ms");
            if(highScore==0){
                highScore=difference;
            }else{
                if(compare(difference,highScore) < 0){
                    Log.i("counter", "new high score reached");
                    highScore=difference;
                }
            }

        }
    }

    public static int compare(long X, long Y){
        return Long.valueOf(X).compareTo(Long.valueOf(Y));

    }
}
