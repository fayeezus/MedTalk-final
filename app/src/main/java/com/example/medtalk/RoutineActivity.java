package com.example.medtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class RoutineActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_routine);
        getSupportActionBar().hide();

        Button backButton = findViewById(R.id.button_back);
        Button resetButton = findViewById(R.id.button_reset);

        ToggleButton Routine2 = (ToggleButton) findViewById(R.id.routine_2);
        ToggleButton Routine3 = (ToggleButton) findViewById(R.id.routine_3);
        ToggleButton Routine4 = (ToggleButton) findViewById(R.id.routine_4);

        SeekBar Routine1Slide = findViewById(R.id.routine_1_slide);
        SeekBar Routine5Slide = findViewById(R.id.routine_5_slide);

        TextView Routine1 = findViewById(R.id.routine_1_text);
        TextView Routine5 = findViewById(R.id.routine_5_text);

        Routine2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Routine2.setBackgroundColor(Color.parseColor("#CCFF0000"));
                } else {
                    Routine2.setBackgroundColor(Color.parseColor("#CC00C832"));
                }
            }
        });

        Routine3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Routine3.setBackgroundColor(Color.parseColor("#CCFF0000"));
                } else {
                    Routine3.setBackgroundColor(Color.parseColor("#CC00C832"));
                }
            }
        });

        Routine4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Routine4.setBackgroundColor(Color.parseColor("#CCFF0000"));
                } else {
                    Routine4.setBackgroundColor(Color.parseColor("#CC00C832"));
                }
            }
        });

        Routine1Slide.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        Routine1.setBackgroundColor(Color.parseColor("#CC00C832"));
                        break;
                    case 1:
                        Routine1.setBackgroundColor(Color.parseColor("#79E338"));
                        break;
                    case 2:
                        Routine1.setBackgroundColor(Color.parseColor("#FFFFEB3B"));
                        break;
                    case 3:
                        Routine1.setBackgroundColor(Color.parseColor("#FFFF9800"));
                        break;
                    default:
                        Routine1.setBackgroundColor(Color.parseColor("#CCFF0000"));
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

        Routine5Slide.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        Routine5.setBackgroundColor(Color.parseColor("#CC00C832"));
                        break;
                    case 1:
                        Routine5.setBackgroundColor(Color.parseColor("#79E338"));
                        break;
                    case 2:
                        Routine5.setBackgroundColor(Color.parseColor("#FFFFEB3B"));
                        break;
                    case 3:
                        Routine5.setBackgroundColor(Color.parseColor("#FFFF9800"));
                        break;
                    default:
                        Routine5.setBackgroundColor(Color.parseColor("#CCFF0000"));
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

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Routine2.setBackgroundColor(Color.parseColor("#DDDDDD"));
                Routine3.setBackgroundColor(Color.parseColor("#DDDDDD"));
                Routine4.setBackgroundColor(Color.parseColor("#DDDDDD"));

                Routine1.setBackgroundColor(Color.parseColor("#DDDDDD"));
                Routine5.setBackgroundColor(Color.parseColor("#DDDDDD"));

                Routine1Slide.setProgress(2);
                Routine5Slide.setProgress(2);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });
    }

    public void openMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}