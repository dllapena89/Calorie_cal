package com.example.caloriecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Launch Diary Entries within oun app
       Button buttonDiaries = (Button) findViewById(R.id.buttonDiaries);
        buttonDiaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntentDiary = new Intent(getApplicationContext(), DiaryEntries.class);
                startActivity(startIntentDiary);

            }
        });

// Launch List Entries
        Button buttonList = (Button) findViewById(R.id.buttonList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntentList = new Intent(getApplicationContext(), ListEntries.class);
                startActivity(startIntentList);

            }
        });

// Launch List Entries
        Button buttonGoal = (Button) findViewById(R.id.buttonGoal);
        buttonGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntentList = new Intent(getApplicationContext(), GoalEntries.class);
                startActivity(startIntentList);

            }
        });

    }
}