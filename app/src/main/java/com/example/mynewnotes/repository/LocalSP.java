package com.example.mynewnotes.repository;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.mynewnotes.R;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LocalSP implements CardSourse {

    private List<CardNote> notesSourse;
    private SharedPreferences sharedPreferences;

    static final String KEY_CELL_1 = "CELL_1";
    public static final String KEY_SP_2 = "CELL_3";


    public LocalSP(SharedPreferences sharedPreferences) {
        notesSourse = new ArrayList<CardNote>();
        this.sharedPreferences = sharedPreferences;
    }

    public LocalSP init() {
        String cardNote = sharedPreferences.getString(KEY_CELL_1, null);

        if (cardNote != null) {
            Type type = new TypeToken<ArrayList<CardNote>>(){}.getType();

            notesSourse=(new GsonBuilder().create().fromJson(cardNote, type));

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
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(KEY_CELL_1,new GsonBuilder().create().toJson(notesSourse));
        editor.apply();

    }

    @Override
    public void addNote(CardNote cardNote) {
        notesSourse.add(cardNote);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(KEY_CELL_1,new GsonBuilder().create().toJson(notesSourse));
        editor.apply();

    }

    @Override
    public void clearNote(int position) {
        notesSourse.remove(position);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(KEY_CELL_1,new GsonBuilder().create().toJson(notesSourse));
        editor.apply();

    }

    @Override
    public void updateNote(int position, CardNote newCardNote) {
        notesSourse.set(position, newCardNote);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(KEY_CELL_1,new GsonBuilder().create().toJson(notesSourse));
        editor.apply();
    }

}
