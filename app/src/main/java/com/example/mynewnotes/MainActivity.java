package com.example.mynewnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotesName notesName=NotesName.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.list,notesName).commit();
    }
}