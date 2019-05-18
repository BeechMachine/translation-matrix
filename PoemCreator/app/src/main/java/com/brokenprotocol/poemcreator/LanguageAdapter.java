package com.brokenprotocol.poemcreator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class LanguageAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private ArrayList<TranslationItem> items = new ArrayList<>();

    private Activity parentActivity;

    LanguageAdapter(Context context, Activity parentActivity, ArrayList<TranslationItem> items) {
        inflater = LayoutInflater.from(context);
        this.parentActivity = parentActivity;
        this.items = items;
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

        return view;
    }
}
