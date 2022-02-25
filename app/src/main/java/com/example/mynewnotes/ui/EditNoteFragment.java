package com.example.mynewnotes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynewnotes.R;

public class EditNoteFragment extends Fragment {


    EditText edit_name;
    EditText edit_description;
    Button button;

    public static EditNoteFragment newInstance() {
        EditNoteFragment editNoteFragment = new EditNoteFragment();
        return editNoteFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_note_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_name = view.findViewById(R.id.title);
        edit_description = view.findViewById(R.id.edit_description);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Изменения приняты.", Toast.LENGTH_LONG).show();
                requireActivity().getSupportFragmentManager().popBackStack();

            }
        });


    }
}
