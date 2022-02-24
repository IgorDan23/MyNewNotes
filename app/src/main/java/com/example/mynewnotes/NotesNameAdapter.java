package com.example.mynewnotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesNameAdapter extends RecyclerView.Adapter<NotesNameAdapter.myViewHolder> {
    private String[] name;

    public void setName(String[] name) {
        this.name = name;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new myViewHolder(layoutInflater.inflate(R.layout.name_notes_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bindContantWhithView(name[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }

        public void bindContantWhithView(String content) {
            textView.setText(content);
        }
    }


}


