package com.example.mynewnotes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mynewnotes.R;
import com.example.mynewnotes.publisher.Publisher;
import com.example.mynewnotes.ui.main.NotesName;

public class MainActivity extends AppCompatActivity {
    private Publisher publisher;
    private Navigation navigation;

    public Navigation getNavigation() {
        return navigation;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        publisher=new Publisher();
        navigation= new Navigation(getSupportFragmentManager());
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.list, NotesName.newInstance()).commit();
        }
    }
}