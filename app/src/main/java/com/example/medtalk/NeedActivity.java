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

public class NeedActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_need);
        Objects.requireNonNull(getSupportActionBar()).hide();





        Button backButton = findViewById(R.id.button_back);
        Button langButton = findViewById(R.id.button_language);
        Button NeedButton1 = findViewById(R.id.button_need_1);
        Button NeedButton2 = findViewById(R.id.button_need_2);
        Button NeedButton3 = findViewById(R.id.button_need_3);
        Button NeedButton4 = findViewById(R.id.button_need_4);
        Button NeedButton5 = findViewById(R.id.button_need_5);
        Button NeedButton6 = findViewById(R.id.button_need_6);

        String currentLocale = langButton.getText().toString();

        langButton.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                setAppLocale("English");
            } else if (currentLocale.equals("Chinese")){
                setAppLocale("Chinese");
            } else if (currentLocale.equals("Korean")){
                setAppLocale("Korean");
            } else if (currentLocale.equals("Japanese")){
                setAppLocale("Japanese");
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
                }
                else if (currentLocale.equals("Hindi")) {
                    TTS.setLanguage(new Locale("hi"));
                }
            }
        });

        int  pitchSaved = prefs.getInt("pitch", 1);
        int  speedSaved = prefs.getInt("speed", 1);


        TTS.setPitch(pitchSaved);
        TTS.setSpeechRate(speedSaved);

        NeedButton1.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I need to use the toilet", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我需要上厕所", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("화장실을 이용해야 해요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे शौचालय का उपयोग करने की आवश्यकता है", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        NeedButton2.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I need my medicine, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我需要我的药，请", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("내 약이 필요해, 제발", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("कृपया मुझे मेरी दवा चाहिए", TextToSpeech.QUEUE_FLUSH, null, null);
            }

        });

        NeedButton3.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want the TV on, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我想打开电视，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("TV를 켜주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे टीवी चालू चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        NeedButton4.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want the TV off, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我想关掉电视，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("TV를 꺼주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे टीवी बंद चाहिए, प्लीज", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        NeedButton5.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want the lights on, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我要开灯，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("불을 켜주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे रोशनी चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        NeedButton6.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want the lights off, please", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")){
                TTS.speak("我想关灯，请", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("불을 끄고 싶어요, 제발", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे लाइट बंद चाहिए, कृपया", TextToSpeech.QUEUE_FLUSH, null, null);
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