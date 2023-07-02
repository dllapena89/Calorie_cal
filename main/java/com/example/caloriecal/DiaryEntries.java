package com.example.caloriecal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class DiaryEntries extends AppCompatActivity {

    private EditText inputEditText;
    private ImageView addButton;
    private ListView listView;
    private ArrayList<String> diaryEntries;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_entries);

        inputEditText = findViewById(R.id.input);
        addButton = findViewById(R.id.add);
        listView = findViewById(R.id.list);

        diaryEntries = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, diaryEntries);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEntry();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editEntry(position);
            }
        });
    }

    private void addEntry() {
        String entry = inputEditText.getText().toString().trim();
        if (!entry.isEmpty()) {
            diaryEntries.add(entry);
            adapter.notifyDataSetChanged();
            inputEditText.setText("");
        }
    }

    private void editEntry(final int position) {
        final EditText editEntryEditText = new EditText(this);
        editEntryEditText.setText(diaryEntries.get(position));

        // Show an AlertDialog with the edit text for editing the selected entry
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Entry");
        builder.setView(editEntryEditText);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String editedEntry = editEntryEditText.getText().toString().trim();
                diaryEntries.set(position, editedEntry);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }
}
