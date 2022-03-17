package com.example.mynewnotes.repository;

import android.graphics.drawable.Drawable;

public class CardNote {
    private String name;
    private String description;
    private int fon;
    private boolean like;

    public void setLike(boolean like) {
        this.like = like;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFon() {
        return fon;
    }

    public boolean isLike() {
        return like;
    }

    public CardNote(String name, String description, int fon, boolean like) {
        this.name = name;
        this.description = description;
        this.fon = fon;
        this.like = like;
    }
}
