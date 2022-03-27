package com.example.medtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class TimeActivity extends AppCompatActivity {
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

        setContentView(R.layout.activity_time);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button backButton = findViewById(R.id.button_back);
        Button langButton = findViewById(R.id.button_language);
        Button TimeHour = findViewById(R.id.button_time_hour);
        Button TimeDay = findViewById(R.id.button_time_day);
        Button TimeMonth = findViewById(R.id.button_time_month);
        Button TimeYear = findViewById(R.id.button_time_year);

        EditText NumInput = findViewById(R.id.number_input_time);

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

        TimeHour.setOnClickListener(view -> {
            if(NumInput.getText().toString().length() > 0) {
                String numStr = NumInput.getText().toString();
                if (Integer.parseInt(numStr) == 1) {
                    if (currentLocale.equals("English")) {
                        TTS.speak("One Hour", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")){
                        TTS.speak("一小时", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak("一한 시간", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak("一एक घंटा", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
                else {
                    if (currentLocale.equals("English")) {
                        TTS.speak(String.format("%s Hours", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")){
                        TTS.speak(String.format("%s 小时", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak(String.format("%s 시간", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak(String.format("%s घंटे", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            }
            else {
                if (currentLocale.equals("English")) {
                    TTS.speak("Hours", TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else if (currentLocale.equals("Chinese")){
                    TTS.speak("小时", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Korean")){
                    TTS.speak("시간", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Hindi")){
                    TTS.speak("घंटे", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });

        TimeDay.setOnClickListener(view -> {
            if(NumInput.getText().toString().length() > 0) {
                String numStr = NumInput.getText().toString();
                if (Integer.parseInt(numStr) == 1) {
                    if (currentLocale.equals("English")) {
                        TTS.speak("One Day", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")){
                        TTS.speak("一天", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak("一언젠가", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak("一एक दिन", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
                else {
                    if (currentLocale.equals("English")) {
                        TTS.speak(String.format("%s Days", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")){
                        TTS.speak(String.format("%s 天", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak(String.format("%s 날", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak(String.format("%s दिन", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            }
            else {
                if (currentLocale.equals("English")) {
                    TTS.speak("Days", TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else if (currentLocale.equals("Chinese")) {
                    TTS.speak("天", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Korean")){
                    TTS.speak("날", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Hindi")){
                    TTS.speak("दिन", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });

        TimeMonth.setOnClickListener(view -> {
            if(NumInput.getText().toString().length() > 0) {
                String numStr = NumInput.getText().toString();
                if (Integer.parseInt(numStr) == 1) {
                    if (currentLocale.equals("English")) {
                        TTS.speak("One Month", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")) {
                        TTS.speak("一个月", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak("一한달", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak("一एक माह", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
                else {
                    if (currentLocale.equals("English")) {
                        TTS.speak(String.format("%s Months", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")) {
                        TTS.speak(String.format("%s 个月", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak(String.format("%s 개월", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak(String.format("%s महीने", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            }
            else {
                if (currentLocale.equals("English")) {
                    TTS.speak("Months", TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else if (currentLocale.equals("Chinese")) {
                    TTS.speak("月", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Korean")){
                    TTS.speak("개월", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Hindi")){
                    TTS.speak("महीने", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });

        TimeYear.setOnClickListener(view -> {
            if(NumInput.getText().toString().length() > 0) {
                String numStr = NumInput.getText().toString();
                if (Integer.parseInt(numStr) == 1) {
                    if (currentLocale.equals("English")) {
                        TTS.speak("One Year", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")) {
                        TTS.speak("一年", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak("一년", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak("一एक साल", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
                else {
                    if (currentLocale.equals("English")) {
                        TTS.speak(String.format("%s Years", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else if (currentLocale.equals("Chinese")) {
                        TTS.speak(String.format("%s 年", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Korean")){
                        TTS.speak(String.format("%s 연령", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    } else if (currentLocale.equals("Hindi")){
                        TTS.speak(String.format("%s वर्षों", numStr), TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            }
            else {
                if (currentLocale.equals("English")) {
                    TTS.speak("Years", TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else if (currentLocale.equals("Chinese")) {
                    TTS.speak("年", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Korean")){
                    TTS.speak("연령", TextToSpeech.QUEUE_FLUSH, null, null);
                } else if (currentLocale.equals("Hindi")){
                    TTS.speak("वर्षों", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });

        backButton.setOnClickListener(view -> openPainPage());
    }

    public void openPainPage() {
        Intent intent = new Intent(this, PainActivity.class);
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