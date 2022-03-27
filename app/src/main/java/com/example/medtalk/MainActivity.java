package com.example.medtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech TTS;
    private SeekBar SeekBarPitch;
    private SeekBar SeekBarSpeed;

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
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        SeekBarPitch = findViewById(R.id.seek_bar_pitch);
        SeekBarSpeed = findViewById(R.id.seek_bar_speed);

        Button helpButton = findViewById(R.id.button_save);
        Button foodButton = findViewById(R.id.button_food);
        Button needButton = findViewById(R.id.button_need);
        Button painButton = findViewById(R.id.button_pain);
        Button talkButton = findViewById(R.id.button_talk);
        Button typeButton = findViewById(R.id.button_type);
        Button langButton = findViewById(R.id.button_language);
        Button covidButton = findViewById(R.id.button_covid);
        Button routineButton = findViewById(R.id.button_routine);
        Button settingsButton = findViewById(R.id.button_setting);
      //  View mainLogo = findViewById(R.id.image_title);
       //  View alertLogo1 = findViewById(R.id.image_alert);
       // View alertLogo2 = findViewById(R.id.image_alert2);
        String currentLocale = langButton.getText().toString();

      //  Animation helpButton_anim=AnimationUtils.loadAnimation(this, R.anim.bounce);
      //  helpButton.startAnimation(helpButton_anim);

       // Animation alertImage_anim1=AnimationUtils.loadAnimation(this, R.anim.rotate);
       // alertLogo1.startAnimation(alertImage_anim1);

       // Animation alertImage_anim2=AnimationUtils.loadAnimation(this, R.anim.rotate);
       // alertLogo2.startAnimation(alertImage_anim2);

     //   Animation mainImage_anim=AnimationUtils.loadAnimation(this, R.anim.fadein);
      //  mainLogo.startAnimation(mainImage_anim);

        langButton.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                setAppLocale("English");
                Toast.makeText(getApplicationContext(), "Default Lang (EN) Set", Toast.LENGTH_SHORT).show(); // print the value of selected language
            } else if (currentLocale.equals("Chinese")){
                setAppLocale("Chinese");
                Toast.makeText(getApplicationContext(), "Default Lang (EN) Set", Toast.LENGTH_SHORT).show(); // print the value of selected language
            } else if (currentLocale.equals("Korean")){
                setAppLocale("Korean");
                Toast.makeText(getApplicationContext(), "Default Lang (EN) Set", Toast.LENGTH_SHORT).show(); // print the value of selected language
            } else if (currentLocale.equals("Hindi")){
                setAppLocale("Hindi");
                Toast.makeText(getApplicationContext(), "Default Lang (EN) Set", Toast.LENGTH_SHORT).show(); // print the value of selected language
            } else {
                setAppLocale(("English"));
                Toast.makeText(getApplicationContext(), "Default Lang (EN) Set", Toast.LENGTH_SHORT).show(); // print the value of selected language
            }


        });

        TTS = new TextToSpeech(this, i -> {
            if (i == TextToSpeech.SUCCESS) {
                if (currentLocale.equals("English")) {
                    TTS.setLanguage(Locale.US);
                } else if (currentLocale.equals("Chinese")) {
                    TTS.setLanguage(Locale.CHINESE);
                } else if (currentLocale.equals("Korean")) {
                    TTS.setLanguage(Locale.KOREAN);
                } else if (currentLocale.equals("Hindi")) {
                    TTS.setLanguage(new Locale("hi"));
                }
            }
        });

        int  pitchSaved = prefs.getInt("pitch", 1);
        int  speedSaved = prefs.getInt("speed", 1);


        TTS.setPitch(pitchSaved);
        TTS.setSpeechRate(speedSaved);

        helpButton.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I need help", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")) {
                TTS.speak("我需要帮助", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("도움이 필요해", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे मदद की ज़रूरत है", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        foodButton.setOnClickListener(view -> openFoodPage());
        needButton.setOnClickListener(view -> openNeedPage());
        talkButton.setOnClickListener(view -> openTalkPage());
        painButton.setOnClickListener(view -> openPainPage());
        typeButton.setOnClickListener(view -> openTypePage());
        routineButton.setOnClickListener(view -> openRoutinePage());
        covidButton.setOnClickListener(view -> openCovidPage());
        settingsButton.setOnClickListener(view -> openSettingsPage());
    }
    private void speak() {
        float pitch = (float) SeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) SeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;

        TTS.setPitch(pitch);
        TTS.setSpeechRate(speed);
    }

    public void openFoodPage() {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    public void openNeedPage() {
        Intent intent = new Intent(this, NeedActivity.class);
        startActivity(intent);
    }

    public void openTalkPage() {
        Intent intent = new Intent(this, TalkActivity.class);
        startActivity(intent);
    }

    public void openPainPage() {
        Intent intent = new Intent(this, PainActivity.class);
        startActivity(intent);
    }

    public void openTypePage() {
        Intent intent = new Intent(this, TypeActivity.class);
        startActivity(intent);
    }

    public void openRoutinePage() {
        Intent intent = new Intent(this, RoutineActivity.class);
        startActivity(intent);
    }

    public void openCovidPage() {
        Intent intent = new Intent(this, CovidActivity.class);
        startActivity(intent);
    }

    public void openSettingsPage() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
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