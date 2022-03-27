package com.example.medtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.Objects;

public class TalkActivity extends AppCompatActivity {
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

        setContentView(R.layout.activity_talk);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button backButton = findViewById(R.id.button_back);
        Button langButton = findViewById(R.id.button_language);
        Button TalkButton1 = findViewById(R.id.button_talk_1);
        Button TalkButton2 = findViewById(R.id.button_talk_2);
        Button TalkButton3 = findViewById(R.id.button_talk_3);
        Button TalkButton4 = findViewById(R.id.button_talk_4);
        Button TalkButton5 = findViewById(R.id.button_talk_5);

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

        TalkButton1.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("Hello", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("你好", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("안녕하세요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("नमस्ते", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        TalkButton2.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("Thank you", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("谢谢", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("감사 해요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("शुक्रिया", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        TalkButton3.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("Can I speak with the doctor", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我可以和医生谈谈吗", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("의사와 이야기 할 수 있습니까?", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("क्या मैं डॉक्टर से बात कर सकता हूँ", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        TalkButton4.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("When will I be discharged", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我什么时候出院", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("나는 언제 퇴원할 것인가", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे कब छुट्टी दी जाएगी", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        TalkButton5.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I don't have insurance", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我没有保险", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("나는 보험이 없다", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मेरे पास बीमा नहीं है", TextToSpeech.QUEUE_FLUSH, null, null);
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