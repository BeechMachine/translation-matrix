package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;

public class TransmutilationEngine implements TransmutilatorProtocol {

    private ArrayList<TranslationItem> items = new ArrayList<TranslationItem>();

    private boolean isMutilating = true;
    private boolean fullMutilationComplete = false;

    private int currentItemPointer = 0;

    private ArrayList<String> mutilatedResults = new ArrayList<>();

    private TextView output;

    private int limit = 100;

    private Activity activity;

    public TransmutilationEngine(Activity activity, ArrayList<TranslationItem> items, TextView output) {
        this.activity = activity;
        this.items = items;
        this.output = output;

        TranslationItem first = this.items.get(0);
        TranslationItem last = this.items.get(this.items.size()-1);

        if (!(first.getSourceLanguage().equals(last.getTargetLanguage()))) {
            this.items.add(new TranslationItem(last.getTargetLanguage(), first.getSourceLanguage()));
        }
    }

    public void transmutilate(String phrase) {

        phrase = phrase.toLowerCase();

        if (isMutilating) {

            if (output.getText().equals("")) {
                output.setText(phrase);
            }

            TranslationItem currentItem = items.get(currentItemPointer);

            TranslateTask task = new TranslateTask(activity, phrase, currentItem.getSourceLanguage(), currentItem.getTargetLanguage(), this);
            task.execute();
        }
    }

    @Override
    public void mutilationFinished(String phrase, String source, String target) {

        phrase = phrase.toLowerCase();

        String update = output.getText() + "\n\n" + phrase + " (" + source + " -> " + target + ")";
        output.setText(update);

        if (fullMutilationComplete) {
            for (String existingResult : mutilatedResults) {
                if (phrase.equals(existingResult)) {
                    isMutilating = false;
                    return;
                }
            }
        }

        mutilatedResults.add(phrase);

        if (mutilatedResults.size() >= limit) {
            isMutilating = false;
            return;
        }

        if (currentItemPointer >= items.size()-1) {
            currentItemPointer = 0;
            fullMutilationComplete = true;
        } else {
            currentItemPointer++;
        }

        transmutilate(phrase);
    }
}
