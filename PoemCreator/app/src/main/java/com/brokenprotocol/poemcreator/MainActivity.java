package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<TranslationItem> items = new ArrayList<TranslationItem>();
    LanguageAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity parent = this;

        items.add(new TranslationItem("English", "French", 0));

        String[] languageArray = this.getResources().getStringArray(R.array.languages_list);
        List<String> languageList = Arrays.asList(languageArray);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                languageList);

        AdapterView.OnItemClickListener sourceClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String language =
            }
        };

        AdapterView.OnItemClickListener targetClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String language =
            }
        };

        ListView languageListView = findViewById(R.id.language_list_view);
        adapter = new LanguageAdapter(this, this, items, sourceClickListener, targetClickListener);
        languageListView.setAdapter(adapter);

        ImageButton addButton = findViewById(R.id.translate_toolbar_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(new TranslationItem("German", "English", items.size()));
                adapter.updateData(items);
            }
        });
    }
}
