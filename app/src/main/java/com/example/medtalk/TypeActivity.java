package com.example.medtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TypeActivity extends AppCompatActivity {
    private TextToSpeech TTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("SETTINGS", MODE_PRIVATE);
        String themeSaved = prefs.getString("theme", "1");


        if (themeSaved.equals("1")) {
            setTheme(R.style.Theme_Medtalk);
        } else if (themeSaved.equals("2")) {
            setTheme(R.style.Theme_Medtalk2);
        } else if (themeSaved.equals("3")) {
            setTheme(R.style.Theme_Medtalk3);
        }

        setContentView(R.layout.activity_type);
        getSupportActionBar().hide();

        Button backButton = findViewById(R.id.button_back);
        Button SpeakButton = findViewById(R.id.button_type_speak);
        EditText TextInput = findViewById(R.id.input_type);

        TTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    TTS.setLanguage(Locale.US);
                }
            }
        });


        int  pitchSaved = prefs.getInt("pitch", 1);
        int  speedSaved = prefs.getInt("speed", 1);


        TTS.setPitch(pitchSaved);
        TTS.setSpeechRate(speedSaved);

        SpeakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextInput.getText().toString().length() > 0) {
                    String numStr = TextInput.getText().toString();
                    TTS.speak(numStr, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });
    }

    public void openMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}