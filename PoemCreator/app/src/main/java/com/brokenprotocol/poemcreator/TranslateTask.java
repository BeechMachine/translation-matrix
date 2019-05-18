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
    private String phrase;

    public TranslateTask(Activity activity, String phrase) {
        this.activity = activity;
        this.phrase = phrase;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            InputStream stream = this.activity.getResources().openRawResource(R.raw.apikey);

            // Instantiates a client
            Translate translate = TranslateOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(stream)).build().getService();

            // Translates some text into Russian
            Translation translation =
                    translate.translate(
                            phrase,
                            TranslateOption.sourceLanguage("en"),
                            TranslateOption.targetLanguage("ru"));


            System.out.printf("Text: %s%n", phrase);
            System.out.printf("Translation: %s%n", translation.getTranslatedText());
        } catch (Exception e) {
            System.out.print("Bailed!");
        }

        return null;
    }
}
