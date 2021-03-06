package com.example.medtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class PainActivity extends AppCompatActivity {
    private TextToSpeech TTS;

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
        setContentView(R.layout.activity_pain);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button backButton = findViewById(R.id.button_back);
        Button timeButton = findViewById(R.id.button_time);
        Button bodyButton = findViewById(R.id.button_body);
        Button langButton = findViewById(R.id.button_language);
        Button painButton1 = findViewById(R.id.button_pain_1);
        Button painButton2 = findViewById(R.id.button_pain_2);
        Button painButton3 = findViewById(R.id.button_pain_3);
        Button painButton4 = findViewById(R.id.button_pain_4);
        Button painButton5 = findViewById(R.id.button_pain_5);
        Button painButton6 = findViewById(R.id.button_pain_6);
        SeekBar painSlider = findViewById(R.id.slide_scale);

        String currentLocale = langButton.getText().toString();

        langButton.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                setAppLocale("English");
            } else if (currentLocale.equals("Chinese")){
                setAppLocale("Chinese");
            } else if (currentLocale.equals("Korean")){
                setAppLocale("Korean");
            } else if (currentLocale.equals("Hindi")){
                setAppLocale("Hindi");
            } else {setAppLocale(("English"));}
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

        painButton1.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I have chest pain", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")){
                TTS.speak("????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")){
                TTS.speak("????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")){
                TTS.speak("???????????? ???????????? ????????? ???????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        painButton2.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I have back pain", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")){
                TTS.speak("????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")){
                TTS.speak("????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")){
                TTS.speak("???????????? ????????? ????????? ???????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        painButton3.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I have a headache", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")){
                TTS.speak("????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")){
                TTS.speak("???????????? ????????? ???????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        painButton4.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I have stomach pain", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")) {
                TTS.speak("????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")){
                TTS.speak("?????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")){
                TTS.speak("???????????? ????????? ????????? ???????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        painButton5.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I have a broken bone", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")){
                TTS.speak("?????? ???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")){
                TTS.speak("???????????? ??????????????? ????????? ?????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        painButton6.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I have a fever", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Chinese")) {
                TTS.speak("????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")){
                TTS.speak("?????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")){
                TTS.speak("???????????? ??????????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        painSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        if (currentLocale.equals("English")) {
                            TTS.speak("I feel great", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        else if (currentLocale.equals("Chinese")) {
                            TTS.speak("??????????????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Korean")){
                        TTS.speak("????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Hindi")){
                        TTS.speak("???????????? ???????????? ??????????????? ?????? ????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        break;
                    case 1:
                        if (currentLocale.equals("English")) {
                            TTS.speak("I feel good", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        else if (currentLocale.equals("Chinese")) {
                            TTS.speak("???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Korean")){
                        TTS.speak("?????? ????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Hindi")){
                        TTS.speak("???????????? ??????????????? ???????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        break;
                    case 2:
                        if (currentLocale.equals("English")) {
                            TTS.speak("I feel ok", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        else if (currentLocale.equals("Chinese")) {
                            TTS.speak("??????????????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Korean")){
                        TTS.speak("??? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Hindi")){
                        TTS.speak("????????? ????????? ?????? ????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        break;
                    case 3:
                        if (currentLocale.equals("English")) {
                            TTS.speak("I feel bad", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        else if (currentLocale.equals("Chinese")) {
                            TTS.speak("???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Korean")){
                        TTS.speak("????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Hindi")){
                        TTS.speak("???????????? ???????????? ???????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                        break;
                    default:
                        if (currentLocale.equals("English")) {
                            TTS.speak("I feel horrible", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        else if (currentLocale.equals("Chinese")) {
                            TTS.speak("???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Korean")){
                        TTS.speak("????????? ????????????", TextToSpeech.QUEUE_FLUSH, null, null);
                        } else if (currentLocale.equals("Hindi")){
                        TTS.speak("???????????? ???????????? ???????????? ??????????????? ?????? ????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        backButton.setOnClickListener(view -> openMainPage());
        bodyButton.setOnClickListener(view -> openBodyPage());
        timeButton.setOnClickListener(view -> openTimePage());
    }

    public void openMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openBodyPage() {
        Intent intent = new Intent(this, BodyActivity.class);
        startActivity(intent);
    }

    public void openTimePage() {
        Intent intent = new Intent(this, TimeActivity.class);
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