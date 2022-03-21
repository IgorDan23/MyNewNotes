package com.example.mynewnotes.publisher;

import com.example.mynewnotes.repository.CardNote;

public interface Observer {
    void receiveMessage(CardNote cardNote);
}
