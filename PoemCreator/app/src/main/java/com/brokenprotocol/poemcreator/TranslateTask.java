package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.os.AsyncTask;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.InputStream;

public class TranslateTask extends AsyncTask<Void, Void, Void> {

    private Activity activity;

    public TranslateTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            InputStream stream = this.activity.getResources().openRawResource(R.raw.apikey);

            // Instantiates a client
            Translate translate = TranslateOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(stream)).build().getService();

            // The text to translate
            String text = "Hello, world!";

            // Translates some text into Russian
            Translation translation =
                    translate.translate(
                            text,
                            TranslateOption.sourceLanguage("en"),
                            TranslateOption.targetLanguage("ru"));


            System.out.printf("Text: %s%n", text);
            System.out.printf("Translation: %s%n", translation.getTranslatedText());
        } catch (Exception e) {
            System.out.print("Bailed!");
        }

        return null;
    }
}
