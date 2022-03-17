package com.example.mynewnotes.repository;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.mynewnotes.R;

import java.util.ArrayList;
import java.util.List;

public class LocalRepositoryImpl implements CardSourse {

    private List<CardNote> notesSourse;
    private Resources resources;

    public LocalRepositoryImpl(Resources resources) {
        notesSourse = new ArrayList<CardNote>();
        this.resources = resources;
    }

    public LocalRepositoryImpl init() {
        String[] name = resources.getStringArray(R.array.Name);
        String[] descriptions = resources.getStringArray(R.array.Description);
        TypedArray fon = resources.obtainTypedArray(R.array.Fon);

        for (int i = 0; i < name.length; i++) {
            notesSourse.add(new CardNote(name[i], descriptions[i], fon.getColor(i,i), false));
        }
        return this;
    }

    @Override
    public int size() {
        return notesSourse.size();
    }

    @Override
    public List<CardNote> getAllNote() {
        return notesSourse;
    }

    @Override
    public CardNote getCardNote(int position) {
        return notesSourse.get(position);
    }

    @Override
    public void clearAll() {
        notesSourse.clear();

    }

    @Override
    public void addNote(CardNote cardNote) {
        notesSourse.add(cardNote);

    }

    @Override
    public void clearNote(int position) {
        notesSourse.remove(position);

    }

    @Override
    public void updateNote(int position, CardNote newCardNote) {
        notesSourse.set(position, newCardNote);
    }


}
