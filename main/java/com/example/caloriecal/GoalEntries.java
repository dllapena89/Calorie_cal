package com.example.caloriecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class GoalEntries extends AppCompatActivity {

    private EditText inputEditText;
    private ImageView addButton;
    private ListView listView;
    private ArrayList<String> goalEntries;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_entries);

        inputEditText = findViewById(R.id.input);
        addButton = findViewById(R.id.add);
        listView = findViewById(R.id.list);

        goalEntries = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, goalEntries);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGoal();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deleteGoal(position);
            }
        });
    }

    private void addGoal() {
        String goal = inputEditText.getText().toString().trim();
        if (!goal.isEmpty()) {
            goalEntries.add(goal);
            adapter.notifyDataSetChanged();
            inputEditText.setText("");
        }
    }

    private void deleteGoal(int position) {
        goalEntries.remove(position);
        adapter.notifyDataSetChanged();
    }
}
