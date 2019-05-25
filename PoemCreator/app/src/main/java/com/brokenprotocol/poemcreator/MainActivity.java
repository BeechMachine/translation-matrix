package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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

        String[] languageArray = this.getResources().getStringArray(R.array.languages_list);
        final List<String> languageList = Arrays.asList(languageArray);

        if (items.size() == 0) {
            items.add(new TranslationItem("English", "English"));
        }

        AdapterView.OnItemSelectedListener sourceSelectionListener = new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if ((int)adapterView.getTag() >= items.size()) {
                    return;
                }

                String source = languageList.get(i);

                TranslationItem item = items.get((int)adapterView.getTag());

                if (item == null || item.getSourceLanguage().equals(source)) {
                    return;
                }

                item.setSourceLanguage(source);

                adapter.updateData(items);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        AdapterView.OnItemSelectedListener targetSelectionListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if ((int)adapterView.getTag() >= items.size()) {
                    return;
                }

                String target = languageList.get(i);

                TranslationItem item = items.get((int)adapterView.getTag());

                if (item == null || item.getTargetLanguage().equals(target)) {
                    return;
                }

                item.setTargetLanguage(target);

                adapter.updateData(items);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        final ListView languageListView = findViewById(R.id.language_list_view);
        adapter = new LanguageAdapter(this, this, items, sourceSelectionListener, targetSelectionListener);
        languageListView.setAdapter(adapter);

        ImageButton addButton = findViewById(R.id.translate_toolbar_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TranslationItem mostRecentItem = items.get(items.size()-1);

                items.add(new TranslationItem(mostRecentItem.getTargetLanguage(), "English"));
                adapter.updateData(items);
            }
        });

        final Activity anchorActivity = this;

        Button transmutilateButton = findViewById(R.id.translateButton);
        transmutilateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText phraseEditText = findViewById(R.id.phraseEditText);
                if (phraseEditText.getText().toString().equals("")) {
                    return;
                }

                TextView output = findViewById(R.id.outputTextView);
                output.setVisibility(View.VISIBLE);

                output.setMovementMethod(new ScrollingMovementMethod());

                phraseEditText.setVisibility(View.GONE);
                languageListView.setVisibility(View.GONE);

                TransmutilationEngine engine = new TransmutilationEngine(anchorActivity, items, output);
                engine.transmutilate(phraseEditText.getText().toString());

            }
        });
    }
}
