package com.example.weathernow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.VideoView;

import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        playVideo();
        playMusic();
        fiveSecondDelay();


    }
    
    private void playVideo(){
        //loads and play video
        VideoView videoView = findViewById(R.id.splashVideo);
        String uri = "android.resource://"+getPackageName()+"/"+R.raw.clouds;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();
    }
    private void playMusic(){
        //loads and plays music
        MediaPlayer jingle = MediaPlayer.create(SplashScreen.this, R.raw.openscreenjingle);
        jingle.start();

        //after 5 seconds track is released
        new CountDownTimer(5000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                jingle.release();

            }
        }.start();


    }
    private void fiveSecondDelay(){
        //5 second delay, then opens to main screen
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        };

        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
    
}