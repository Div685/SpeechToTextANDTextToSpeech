package com.smartech.dd.speechtotextandtexttospeech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, ChooseOne.class);
                startActivity(intent);
                SplashScreen.this.finish();

            }
        };
        Timer t = new Timer();
        t.schedule(task, 2000);

        }catch (Exception e){
        Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
        }

}
