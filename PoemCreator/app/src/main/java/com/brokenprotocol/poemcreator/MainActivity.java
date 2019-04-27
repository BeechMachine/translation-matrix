package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity parent = this;

        ArrayList<TranslationItem> items = new ArrayList<TranslationItem>();
        items.add(new TranslationItem("English", "French", 0));
        items.add(new TranslationItem("French", "German", 1));
        items.add(new TranslationItem("German", "English", 2));

        ListView languageListView = findViewById(R.id.language_list_view);
        LanguageAdapter adapter = new LanguageAdapter(this, parent, items);
        languageListView.setAdapter(adapter);

//        Button test = findViewById(R.id.translateButton);
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new TranslateTask(parent).execute();
//            }
//        });
    }
}
