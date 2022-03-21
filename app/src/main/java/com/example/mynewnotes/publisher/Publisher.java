package com.example.mynewnotes.publisher;

import com.example.mynewnotes.repository.CardNote;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Observer> observers;

    public Publisher(){
        observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void sendMessage(CardNote cardNote){
        for (Observer observer:observers) {
            observer.receiveMessage(cardNote);
        }
    }
}
