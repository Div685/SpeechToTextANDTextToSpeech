package com.smartech.dd.speechtotextandtexttospeech;

import android.content.Intent;
import android.speech.tts.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChooseOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_one);
    }

    public void onClickTTS(View v){
        try {
            Intent intent = new Intent(this, TextToSpeech.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSTT(View v){
        try{
            Intent intent = new Intent(this, SpeechToText.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
