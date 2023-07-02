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

public class ListEntries extends AppCompatActivity {

    private EditText inputEditText;
    private ImageView addButton;
    private ListView listView;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_entries);

        inputEditText = findViewById(R.id.input);
        addButton = findViewById(R.id.add);
        listView = findViewById(R.id.list);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deleteItem(position);
            }
        });
    }

    private void addItem() {
        String item = inputEditText.getText().toString().trim();
        if (!item.isEmpty()) {
            itemList.add(item);
            adapter.notifyDataSetChanged();
            inputEditText.setText("");
        }
    }

    private void deleteItem(int position) {
        itemList.remove(position);
        adapter.notifyDataSetChanged();
    }
}
