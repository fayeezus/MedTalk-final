package com.example.medtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
    private TextToSpeech TTS;
    private SeekBar SeekBarPitch;
    private SeekBar SeekBarSpeed;

    RadioButton language_english, language_chinese, language_korean, language_hindi;

    RadioButton backgroundselector1,backgroundselector2,backgroundselector3;
    String selectedLanguage;
    Button saveSettings;

    @Override
    protected void onDestroy() {
        if (TTS != null) {
            TTS.stop();
            TTS.shutdown();
        }
        super.onDestroy();
    }

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

        setContentView(R.layout.activity_settings);
        Objects.requireNonNull(getSupportActionBar()).hide();


        //Init
        backgroundselector1 = findViewById(R.id.backgroundselector1);
        backgroundselector2 = findViewById(R.id.backgroundselector2);
        backgroundselector3 = findViewById(R.id.backgroundselector3);



        language_english = findViewById(R.id.language_english);
        language_chinese = findViewById(R.id.language_chinese);
        language_korean = findViewById(R.id.language_korean);
        language_hindi = findViewById(R.id.language_hindi);
        SeekBarPitch = findViewById(R.id.seek_bar_pitch);
        SeekBarSpeed = findViewById(R.id.seek_bar_speed);
        saveSettings = findViewById(R.id.button_save);
        //======

        //GETVALUR FROM SHARED PREFFERENDE

        String lang = prefs.getString("lang", "en");
        int pitchSaved = prefs.getInt("pitch", 1);
        int speedSaved = prefs.getInt("speed", 1);

        TTS = new TextToSpeech(this, i -> {
            if (i == TextToSpeech.SUCCESS) {
                if (lang.equals("English")) {
                    TTS.setLanguage(Locale.US);
                } else if (lang.equals("Chinese")) {
                    TTS.setLanguage(Locale.CHINESE);
                } else if (lang.equals("Korean")) {
                    TTS.setLanguage(Locale.KOREAN);
                } else if (lang.equals("Hindi")) {
                    TTS.setLanguage(new Locale("hi"));
                }
            }
        });

        if (themeSaved.equals("1")) {
            backgroundselector1.setChecked(true);

        } else if (themeSaved.equals("2")) {

            backgroundselector2.setChecked(true);
        } else if (themeSaved.equals("3")) {
            backgroundselector3.setChecked(true);
        }
        //theme

        if (lang.equals("en")) {
            language_english.setChecked(true);

        } else if (lang.equals("zh")) {

            language_chinese.setChecked(true);
        } else if (lang.equals("kr")) {
            language_korean.setChecked(true);
        } else if (lang.equals("hi")) {
            language_hindi.setChecked(true);
        }
















        SharedPreferences.Editor editor = getSharedPreferences("SETTINGS", MODE_PRIVATE).edit();




        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language_english.isChecked()) {
                    setAppLocale("en");

                    editor.putString("lang", "en");

                    editor.commit();

                    Toast.makeText(getApplicationContext(), "English (US)", Toast.LENGTH_SHORT).show(); // print the value of selected language
                } else if (language_chinese.isChecked()) {
                    setAppLocale("zh");
                    editor.putString("lang", "zh");

                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Chinese", Toast.LENGTH_SHORT).show(); // print the value of selected language
                } else if (language_korean.isChecked()) {
                    setAppLocale("kr");
                    editor.putString("lang", "kr");

                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Korean", Toast.LENGTH_SHORT).show(); // print the value of selected language
                } else if (language_hindi.isChecked()) {
                    setAppLocale("hi");

                    editor.putString("lang", "hi");

                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Hindi", Toast.LENGTH_SHORT).show(); // print the value of selected language
                }





                //theme

                if (backgroundselector1.isChecked()) {



                    //setTheme(android.R.style.Theme);


                    editor.putString("theme", "1");

                    editor.commit();

                } else if (backgroundselector2.isChecked()) {

                    editor.putString("theme", "2");

                    editor.commit();
                } else if (backgroundselector3.isChecked()) {

                    editor.putString("theme", "3");

                    editor.commit();

                }

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();



                //save here





            }

         //   Toast.makeText(getApplicationContext(), "Settings Saved!", Toast.LENGTH_LONG).show(); // print the value of selected language
        });

        Animation saveButton_anim= AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        saveSettings.startAnimation(saveButton_anim);


        Button backButton = findViewById(R.id.button_back);

        SeekBar pitchSeekBar = findViewById(R.id.seek_bar_pitch);
        SeekBar speedSeekBar = findViewById(R.id.seek_bar_speed);

        pitchSeekBar.setProgress(pitchSaved);
        speedSeekBar.setProgress(speedSaved);


        pitchSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               // speak();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //speak();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                speak();
                editor.putInt("pitch", seekBar.getProgress());
                editor.commit();
            }

        });

        speedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //speak();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               // speak();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                speak();
                editor.putInt("speed", seekBar.getProgress());
                editor.commit();
            }

        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });

    }
    public void speak() {
        float pitch = (float) SeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) SeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;

        TTS.setPitch(pitch);
        TTS.setSpeechRate(speed);
    }

    public void openMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void setAppLocale(String localeCode) {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
        finish();
        startActivity(getIntent());
    }


}