package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    int counter = 0;
    private static int TIME_OUT = 7000;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.animate().alpha(1).setDuration(3000);
        textView = findViewById(R.id.textView);
        textView.setY(1000);
        textView.animate().alpha(1).setDuration(10000);
        textView.animate().translationYBy(-1000).setDuration(2000);

        final View myLayout = findViewById(R.id.id);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, GamePart.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

        prog();
    }

    public void prog(){
        pb = (ProgressBar) findViewById(R.id.pb);
        final Timer t = new Timer ();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if (counter==100){
                    t.cancel();
                    //Intent intent = new Intent(getApplicationContext(),GamePart.class);
                    //startActivity(intent);
                }
            }
        };
        t.schedule(tt,0,70);

    }
}