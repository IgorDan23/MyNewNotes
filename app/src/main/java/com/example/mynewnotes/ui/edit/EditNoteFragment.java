package com.example.mynewnotes.ui.edit;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynewnotes.R;
import com.example.mynewnotes.repository.CardNote;
import com.example.mynewnotes.ui.MainActivity;

import java.util.Calendar;

public class EditNoteFragment extends Fragment {

    CardNote cardNote;
    private DatePicker datePicker;

    EditText edit_name;
    EditText edit_description;
    Button button;

    public static EditNoteFragment newInstance(CardNote cardNote) {
        EditNoteFragment editNoteFragment = new EditNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable("CardNote", cardNote);
        editNoteFragment.setArguments(args);
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
        if (getArguments() != null) {
            cardNote = getArguments().getParcelable("CardNote");

            edit_name = view.findViewById(R.id.edit_name);
            edit_description = view.findViewById(R.id.edit_description);
            button = view.findViewById(R.id.button);

            edit_name.setText(cardNote.getName());
            edit_description.setText(cardNote.getDescription());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cardNote.getDate());
            ((DatePicker) view.findViewById(R.id.datePicker)).init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar
                    .get(Calendar.DAY_OF_MONTH), null);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View other) {
                    cardNote.setName(edit_name.getText().toString());
                    cardNote.setDescription(edit_description.getText().toString());

                    DatePicker datePicker = ((DatePicker) view.findViewById(R.id.datePicker));
                    calendar.set(Calendar.YEAR, datePicker.getYear());
                    calendar.set(Calendar.MONTH, datePicker.getMonth());
                    calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

                    cardNote.setDate(calendar.getTime());


                    Toast.makeText(requireContext(), "Изменения приняты.", Toast.LENGTH_LONG).show();
                    ((MainActivity) requireActivity()).getPublisher().sendMessage(cardNote);
                    ((MainActivity) requireActivity()).getSupportFragmentManager().popBackStack();


                }


            });
        }
    }
}
