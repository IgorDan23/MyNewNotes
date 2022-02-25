package com.example.mynewnotes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewnotes.R;
import com.example.mynewnotes.repository.CardNote;
import com.example.mynewnotes.repository.LocalRepositoryImpl;


public class NotesName extends Fragment implements OnItemClickListener {
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
        LocalRepositoryImpl localRepository = new LocalRepositoryImpl(requireContext().getResources());
        notesNameAdapter.setNotes(localRepository.init());
        notesNameAdapter.setOnItemClickListener(NotesName.this);

    }

    void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(notesNameAdapter);
        recyclerView.setHasFixedSize(true);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_name_fragment, container, false);
    }

    @Override
    public void onItemClick() {
        Toast.makeText(requireContext(),"привет",Toast.LENGTH_LONG).show();

    }
}
