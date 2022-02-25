package com.example.mynewnotes.repository;

import java.util.List;

public interface CardSourse {
    int size();

    List<CardNote> getAllNote();

    CardNote getCardNote(int position);
}
