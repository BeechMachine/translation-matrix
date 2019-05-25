package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private ArrayList<TranslationItem> items = new ArrayList<>();

    private Activity parentActivity;

    private AdapterView.OnItemSelectedListener sourceClickListener;
    private AdapterView.OnItemSelectedListener targetClickListener;

    LanguageAdapter(Context context, Activity parentActivity, ArrayList<TranslationItem> items, AdapterView.OnItemSelectedListener sourceClickListener, AdapterView.OnItemSelectedListener targetClickListener) {
        inflater = LayoutInflater.from(context);
        this.parentActivity = parentActivity;
        this.items = items;
        this.sourceClickListener = sourceClickListener;
        this.targetClickListener = targetClickListener;
        updateData(this.items);
    }

    public void updateData(ArrayList<TranslationItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {

        View view;

        final TranslationItem item = (TranslationItem) getItem(position);

        if (convertView == null) {
            view = inflater.inflate(R.layout.translation_item_cell, null);
        } else {
            view = convertView;
        }

        String[] languageArray = parentActivity.getResources().getStringArray(R.array.languages_list);
        final List<String> languageList = Arrays.asList(languageArray);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(parentActivity,
                android.R.layout.simple_spinner_dropdown_item,
                languageList);

        final Spinner sourceSpinner = view.findViewById(R.id.sourceSpinner);
        sourceSpinner.setAdapter(spinnerArrayAdapter);
        sourceSpinner.setOnItemSelectedListener(sourceClickListener);
        sourceSpinner.setTag(position);
        sourceSpinner.setSelection(languageList.indexOf(item.getSourceLanguage()));

        final Spinner targetSpinner = view.findViewById(R.id.targetSpinner);
        targetSpinner.setAdapter(spinnerArrayAdapter);
        targetSpinner.setOnItemSelectedListener(targetClickListener);
        targetSpinner.setTag(position);
        targetSpinner.setSelection(languageList.indexOf(item.getTargetLanguage()));

        return view;
    }

    public static String translateSubs (String language) {
        switch (language) {
            case "English":
                return "en";
            case "Arabic":
                return "ar";
            case "German":
                return "de";
            case "Italian":
                return "it";
            case "French":
                return "fr";
            case "Spanish":
                return "es";
            case "Afrikaans":
                return "af";
            case "Albanian":
                return "sq";
            case "Azerbaijani":
                return "az";
            case "Basque":
                return "eu";
            case "Bengali":
                return "bn";
            case "Belarusian":
                return "be";
            case "Bulgarian":
                return "bg";
            case "Catalan":
                return "ca";
            case "Chinese Simplified":
                return "zh-CN";
            case "Chinese Traditional":
                return "zh-TW";
            case "Croatian":
                return "hr";
            case "Czech":
                return "cs";
            case "Danish":
                return "da";
            case "Dutch":
                return "nl";
            case "Esperanto":
                return "eo";
            case "Estonian":
                return "et";
            case "Filipino":
                return "tl";
            case "Finnish":
                return "fi";
            case "Galician":
                return "gl";
            case "Georgian":
                return "ka";
            case "Greek":
                return "el";
            case "Gujarati":
                return "gu";
            case "Haitian Creole":
                return "ht";
            case "Hebrew":
                return "iw";
            case "Hindi":
                return "hi";
            case "Hungarian":
                return "hu";
            case "Icelandic":
                return "is";
            case "Indonesian":
                return "id";
            case "Irish":
                return "ga";
            case "Japanese":
                return "ja";
            case "Kannada":
                return "kn";
            case "Korean":
                return "ko";
            case "Latin":
                return "la";
            case "Latvian":
                return "lv";
            case "Lithuanian":
                return "lt";
            case "Macedonian":
                return "mk";
            case "Malay":
                return "ms";
            case "Maltese":
                return "mt";
            case "Norwegian":
                return "no";
            case "Persian":
                return "fa";
            case "Polish":
                return "pl";
            case "Portuguese":
                return "pt";
            case "Romanian":
                return "ro";
            case "Russian":
                return "ru";
            case "Serbian":
                return "sr";
            case "Slovak":
                return "sk";
            case "Slovenian":
                return "sl";
            case "Swahili":
                return "sw";
            case "Swedish":
                return "sv";
            case "Tamil":
                return "ta";
            case "Telugu":
                return "te";
            case "Thai":
                return "th";
            case "Turkish":
                return "tr";
            case "Ukrainian":
                return "uk";
            case "Urdu":
                return "ur";
            case "Vietnamese":
                return "vi";
            case "Welsh":
                return "cy";
            case "Yiddish":
                return "yi";
        }
        return "";
    }
}
