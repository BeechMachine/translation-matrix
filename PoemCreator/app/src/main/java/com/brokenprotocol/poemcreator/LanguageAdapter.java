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

    private AdapterView.OnItemClickListener sourceClickListener;
    private AdapterView.OnItemClickListener targetClickListener;

    LanguageAdapter(Context context, Activity parentActivity, ArrayList<TranslationItem> items, AdapterView.OnItemClickListener sourceClickListener, AdapterView.OnItemClickListener targetClickListener) {
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

        TranslationItem item = (TranslationItem) getItem(position);

        if (convertView == null) {
            view = inflater.inflate(R.layout.translation_item_cell, null);
        } else {
            view = convertView;
        }

        String[] languageArray = parentActivity.getResources().getStringArray(R.array.languages_list);
        List<String> languageList = Arrays.asList(languageArray);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(parentActivity,
                android.R.layout.simple_spinner_dropdown_item,
                languageList);

        Spinner sourceSpinner = view.findViewById(R.id.sourceSpinner);
        sourceSpinner.setAdapter(spinnerArrayAdapter);
        sourceSpinner.setSelection(spinnerArrayAdapter.getPosition(item.getSourceLanguage()));

        sourceSpinner.setOnItemClickListener(sourceClickListener);

        Spinner targetSpinner = view.findViewById(R.id.targetSpinner);
        targetSpinner.setAdapter(spinnerArrayAdapter);
        targetSpinner.setSelection(spinnerArrayAdapter.getPosition(item.getTargetLanguage()));

        targetSpinner.setOnItemClickListener(targetClickListener);

        return view;
    }
}