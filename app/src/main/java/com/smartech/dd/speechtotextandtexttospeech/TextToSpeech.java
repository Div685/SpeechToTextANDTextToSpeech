package com.smartech.dd.speechtotextandtexttospeech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class TextToSpeech extends AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {

    private android.speech.tts.TextToSpeech tts;
    private Button btnSpeak;
    private EditText getTextToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        tts = new android.speech.tts.TextToSpeech(this, this);
        getTextToSpeech = (EditText)findViewById(R.id.editText);
        btnSpeak = (Button)findViewById(R.id.speakOut);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speckOutNow();
            }
        });
    }

    public void speckOutNow(){
        String text = getTextToSpeech.getText().toString();
        tts.speak(text, android.speech.tts.TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {
        if(status == android.speech.tts.TextToSpeech.SUCCESS) {
            int language = tts.setLanguage(Locale.US);
            if(language == android.speech.tts.TextToSpeech.LANG_MISSING_DATA || language == android.speech.tts.TextToSpeech.LANG_NOT_SUPPORTED){
                btnSpeak.setEnabled(true);
            } else {
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }

        } else {

        }
    }

    @Override
    protected void onDestroy() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

}
