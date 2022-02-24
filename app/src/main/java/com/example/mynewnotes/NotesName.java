package com.example.mynewnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


public class NotesName extends Fragment {
    NotesNameAdapter notesNameAdapter;


    public static NotesName newInstance() {
        NotesName notesName = new NotesName();
        return notesName;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initRecycler(view);


    }

    void initAdapter() {
        notesNameAdapter = new NotesNameAdapter();
        notesNameAdapter.setName(getName());

    }

    void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(notesNameAdapter);
        recyclerView.setHasFixedSize(true);

    }

    String[] getName() {
        String[] name = getResources().getStringArray(R.array.Name);
        return name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_name_fragment, container, false);
    }
}
