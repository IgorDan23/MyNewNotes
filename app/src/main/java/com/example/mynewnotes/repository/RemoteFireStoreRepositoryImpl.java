package com.example.mynewnotes.repository;

import android.content.res.Resources;
import android.content.res.TypedArray;

import androidx.annotation.NonNull;

import com.example.mynewnotes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class RemoteFireStoreRepositoryImpl implements CardSourse {
    private static final String NOTES_COLLECTION = "notes";

    private List<CardNote> notesSourse;

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    CollectionReference collectionReference = firebaseFirestore.collection(NOTES_COLLECTION);


    public RemoteFireStoreRepositoryImpl() {
        notesSourse = new ArrayList<CardNote>();
    }

    public RemoteFireStoreRepositoryImpl init(RemoteFireStoreResponse remoteFireStoreResponse) {
        collectionReference.orderBy(CardNoteMapping.Fields.DATE, Query.Direction.ASCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    notesSourse = new ArrayList<CardNote>();
                    for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                        Map<String, Object> document = queryDocumentSnapshot.getData();
                        String id = queryDocumentSnapshot.getId();
                        notesSourse.add(CardNoteMapping.toCardNote(id, document));
                    }

                }
                remoteFireStoreResponse.initialized(RemoteFireStoreRepositoryImpl.this);
            }
        });
        return this;

    }

    @Override
    public int size() {
        return notesSourse.size();
    }

    @Override
    public List<CardNote> getAllNote() {
        return notesSourse;
    }

    @Override
    public CardNote getCardNote(int position) {
        return notesSourse.get(position);
    }

    @Override
    public void clearAll() {
        notesSourse.clear();
    }

    @Override
    public void addNote(CardNote cardNote) {
        notesSourse.add(cardNote);
        collectionReference.add(CardNoteMapping.toDocument(cardNote));

    }

    @Override
    public void clearNote(int position) {
        notesSourse.remove(position);

    }

    @Override
    public void updateNote(int position, CardNote newCardNote) {
        notesSourse.set(position, newCardNote);
    }
}