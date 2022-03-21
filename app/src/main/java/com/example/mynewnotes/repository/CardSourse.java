package com.example.mynewnotes.repository;

import java.util.List;

public interface CardSourse {
    int size();

    List<CardNote> getAllNote();

    CardNote getCardNote(int position);

    void clearAll();

    void addNote(CardNote cardNote);

    void clearNote(int position);

    void updateNote(int position, CardNote newCardNote);

}
