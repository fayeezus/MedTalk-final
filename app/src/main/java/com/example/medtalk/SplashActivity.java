package com.example.medtalk;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
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
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {
        Handler h = new Handler();
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


        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();




        String lang = prefs.getString("lang", "en");

        View mainLogo = findViewById(R.id.imageView6);
        Animation mainImage_anim=AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        mainLogo.startAnimation(mainImage_anim);

        View slogan = findViewById(R.id.textView3);
        Animation slogan_anim=AnimationUtils.loadAnimation(this, R.anim.fadein);
        Animation slogan_anim2=AnimationUtils.loadAnimation(this, R.anim.fadeout);
        slogan.startAnimation(slogan_anim);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        slogan.startAnimation(slogan_anim2);

        h.postDelayed(() -> {

            setAppLocale(lang);

            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }, 2500);


    }


    private void setAppLocale(String localeCode) {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
        finish();
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        //startActivity(getIntent());
    }


}
