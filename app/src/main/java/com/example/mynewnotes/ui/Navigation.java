package com.example.mynewnotes.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mynewnotes.R;
import com.example.mynewnotes.ui.edit.EditNoteFragment;

public class Navigation {
    private final FragmentManager fragmentManager;


    public Navigation(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void addFragment(Fragment fragment, boolean addBackStack){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list,fragment);
        if (addBackStack){
            fragmentTransaction.addToBackStack("");
        }
        fragmentTransaction.commit();

    }


}
