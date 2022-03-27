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

public class CovidActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_covid);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button backButton = findViewById(R.id.button_back);
        Button langButton = findViewById(R.id.button_language);
        Button CovidButton1 = findViewById(R.id.button_covid_1);
        Button CovidButton2 = findViewById(R.id.button_covid_2);
        Button CovidButton3 = findViewById(R.id.button_covid_3);
        Button CovidButton4 = findViewById(R.id.button_covid_4);

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

        CovidButton1.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("Can you show me Covid test sites", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("你能告诉我 Covid 测试站点吗", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("코비드 테스트 사이트를 보여주실 수 있나요?", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("क्या आप मुझे कोविड परीक्षण स्थल दिखा सकते हैं", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        CovidButton2.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I want to get my vaccine", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我想接种疫苗", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("백신을 맞고 싶어요", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे अपना टीका लगवाना है", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        CovidButton3.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("When will I get my test results", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我什么时候可以得到我的测试结果", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("테스트 결과는 언제 받을 수 있나요?", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मुझे अपना परीक्षा परिणाम कब मिलेगा", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        CovidButton4.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("I am feeling sick, I want to take Covid test", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("我感觉不舒服，我想参加 Covid 测试", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("몸이 좋지 않아 코로나 검사를 받고 싶다", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("मैं बीमार महसूस कर रहा हूं, मैं कोविड टेस्ट कराना चाहता हूं", TextToSpeech.QUEUE_FLUSH, null, null);
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