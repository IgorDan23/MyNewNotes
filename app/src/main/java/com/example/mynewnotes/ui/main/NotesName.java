package com.example.mynewnotes.ui.main;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewnotes.R;
import com.example.mynewnotes.publisher.Observer;
import com.example.mynewnotes.repository.CardNote;
import com.example.mynewnotes.repository.CardSourse;
import com.example.mynewnotes.repository.LocalRepositoryImpl;
import com.example.mynewnotes.ui.MainActivity;
import com.example.mynewnotes.ui.edit.EditNoteFragment;

import java.util.Calendar;


public class NotesName extends Fragment implements OnItemClickListener {
    NotesNameAdapter notesNameAdapter;
    CardSourse notes;
    RecyclerView recyclerView;


    public static NotesName newInstance() {
        NotesName notesName = new NotesName();
        return notesName;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initRecycler(view);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.notes_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add: {
                notes.addNote(new CardNote("Новый день", "Новые дела", R.color.four, true, Calendar.getInstance().getTime()));
                notesNameAdapter.notifyItemInserted(notes.size() - 1);
                recyclerView.smoothScrollToPosition(notes.size() - 1);
                return true;
            }
            case R.id.clear: {
                notes.clearAll();
                notesNameAdapter.notifyDataSetChanged();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.note_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menuPosition = notesNameAdapter.getMenuPosition();
        switch (item.getItemId()) {
            case R.id.edit: {
                Observer observer = new Observer() {
                    @Override
                    public void receiveMessage(CardNote cardNote) {
                        ((MainActivity) requireActivity()).getPublisher().unsubscribe(this);
                        notes.updateNote(menuPosition, cardNote);
                        notesNameAdapter.notifyItemChanged(menuPosition);

                    }
                };
                ((MainActivity) requireActivity()).getPublisher().subscribe(observer);
                ((MainActivity) requireActivity()).getNavigation().addFragment(EditNoteFragment.newInstance(notes.getCardNote(menuPosition)), true);
                ;

                return true;
            }
            case R.id.clear: {
                notes.clearNote(notesNameAdapter.getMenuPosition());
                notesNameAdapter.notifyItemRemoved(notesNameAdapter.getMenuPosition());
                return true;
            }

        }
        return super.onContextItemSelected(item);
    }

    void initAdapter() {
        notesNameAdapter = new NotesNameAdapter(this);
        notes = new LocalRepositoryImpl(requireContext().getResources()).init();
        notesNameAdapter.setNotes(notes);
        notesNameAdapter.setOnItemClickListener(NotesName.this);

    }

    void initRecycler(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(notesNameAdapter);
        recyclerView.setHasFixedSize(true);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setChangeDuration(1000);
        recyclerView.setItemAnimator(animator);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_name_fragment, container, false);
    }

    @Override
    public void onItemClick() {
        /*requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list, EditNoteFragment.newInstance(car)).addToBackStack("1").commit();
         */
    }


}
