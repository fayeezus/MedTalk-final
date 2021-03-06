package com.example.medtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.widget.Button;

import java.util.Locale;
import java.util.Objects;

public class BodyActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_body);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button backButton = findViewById(R.id.button_back);
        Button langButton = findViewById(R.id.button_language);
        Button BodyPelvis = findViewById(R.id.button_pelvis);
        Button BodyHandL = findViewById(R.id.button_hand_l);
        Button BodyHandR = findViewById(R.id.button_hand_r);
        Button BodyForeArmL = findViewById(R.id.button_forearm_l);
        Button BodyForeArmR = findViewById(R.id.button_forearm_r);
        Button BodyUpperArmL = findViewById(R.id.button_upperarm_l);
        Button BodyUpperArmR = findViewById(R.id.button_upperarm_r);
        Button BodyShoulderL = findViewById(R.id.button_shoulder_l);
        Button BodyShoulderR = findViewById(R.id.button_shoulder_r);
        Button BodyThighL = findViewById(R.id.button_thigh_l);
        Button BodyThighR = findViewById(R.id.button_thigh_r);
        Button BodyShinL = findViewById(R.id.button_shin_l);
        Button BodyShinR = findViewById(R.id.button_shin_r);
        Button BodyKneeL = findViewById(R.id.button_knee_l);
        Button BodyKneeR = findViewById(R.id.button_knee_r);
        Button BodyFeetL = findViewById(R.id.button_feet_l);
        Button BodyFeetR = findViewById(R.id.button_feet_r);
        Button BodyBelly = findViewById(R.id.button_belly);
        Button BodyChest = findViewById(R.id.button_chest);
        Button BodyNeck = findViewById(R.id.button_neck);
        Button BodyHead = findViewById(R.id.button_head);

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
        BodyPelvis.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("pelvis", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyHandL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left hand", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyHandR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right hand", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
            TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
            TTS.speak("??????????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
        }
        });

        BodyForeArmL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left forearm", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ?????????????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyForeArmR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right forearm", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????????????? ?????????????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyUpperArmL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left upper-arm", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ???????????? ????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyUpperArmR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right upper-arm", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????????????? ???????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyShoulderL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left shoulder", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyShoulderR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right shoulder", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyThighL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left Thigh", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyThighR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right Thigh", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Korean")) {
                TTS.speak("????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????????????? ????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyKneeL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left Knee", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyKneeR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right Knee", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("????????? ??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????????????? ???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyShinL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left shin", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("??????????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyShinR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right shin", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyFeetL.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("left foot", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("???????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyFeetR.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("right foot", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????????????? ?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyHead.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("head", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("???", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyNeck.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("neck", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("???", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("???????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyChest.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("chest", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("????????????", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        BodyBelly.setOnClickListener(view -> {
            if (currentLocale.equals("English")) {
                TTS.speak("belly", TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else if (currentLocale.equals("Chinese")) {
                TTS.speak("??????", TextToSpeech.QUEUE_FLUSH, null, null);
            }  else if (currentLocale.equals("Korean")) {
                TTS.speak("???", TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (currentLocale.equals("Hindi")) {
                TTS.speak("?????????", TextToSpeech.QUEUE_FLUSH, null, null);
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