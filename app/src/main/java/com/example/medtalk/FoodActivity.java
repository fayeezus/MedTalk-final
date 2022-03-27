package com.example.medtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class FoodActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_food);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button backButton = findViewById(R.id.button_back);
        Button langButton = findViewById(R.id.button_language);
        Button FoodButton1 = findViewById(R.id.button_food_1);
        Button FoodButton2 = findViewById(R.id.button_food_2);
        Button FoodButton3 = findViewById(R.id.button_food_3);
        Button FoodButton4 = findViewById(R.id.button_food_4);
        Button FoodButton5 = findViewById(R.id.button_food_5);
        Button FoodButton6 = findViewById(R.id.button_food_6);
        Button FoodButton7 = findViewById(R.id.button_food_7);
        Button FoodButton8 = findViewById(R.id.button_food_8);
        Button FoodButton9 = findViewById(R.id.button_food_9);
        Button FoodButton10 = findViewById(R.id.button_food_10);

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

        FoodButton1.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I need a glass of water, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("请给我一杯水", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("물 한잔 주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("कृपया मुझे एक गिलास पानी चाहिए", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton2.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I am vegetarian", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我是素食主义者", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("나는 채식주의 자이다", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मैं शाकाहारी हूं", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton3.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want a cup of tea, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我要一杯茶，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("차 한잔 주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे एक कप चाय चाहिए, प्लीज", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton4.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I eat halal only", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我只吃清真食品", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("할랄만 먹음", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मैं हलाल ही खाता हूँ", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton5.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want a cup of coffee, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我要一杯咖啡，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("커피 한잔 주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे एक कप कॉफी चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton6.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I eat kosher only", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我只吃犹太洁食", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("나는 코셔만 먹는다", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मैं कोषेर ही खाता हूँ", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton7.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want a cup of orange juice, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("请给我一杯橙汁", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("오렌지 주스 한 잔 주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे एक कप संतरे का जूस चाहिए, प्लीज", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton8.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want some fruit to eat, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我想吃点水果，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("과일 좀 먹게 해주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे कुछ फल खाने चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton9.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I would like a sandwich, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我想要一个三明治，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("샌드위치 주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे एक सैंडविच चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        FoodButton10.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I would like some soup, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我想喝点汤，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("수프 좀 주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे कुछ सूप चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        backButton.setOnClickListener(view -> openMainPage());
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