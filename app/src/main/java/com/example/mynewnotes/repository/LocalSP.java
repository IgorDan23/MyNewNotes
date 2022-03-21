package com.example.mynewnotes.repository;

import java.util.List;

public class LocalSP implements CardSourse{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<CardNote> getAllNote() {
        return null;
    }

    @Override
    public CardNote getCardNote(int position) {
        return null;
    }

    @Override
    public void clearAll() {

    }

    @Override
    public void addNote(CardNote cardNote) {

    }

    @Override
    public void clearNote(int position) {

    }

    @Override
    public void updateNote(int position, CardNote newCardNote) {

    }
}
