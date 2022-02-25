package com.example.mynewnotes.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewnotes.R;
import com.example.mynewnotes.repository.CardNote;
import com.example.mynewnotes.repository.CardSourse;

public class NotesNameAdapter extends RecyclerView.Adapter<NotesNameAdapter.myViewHolder> {
    private CardSourse cardSourse;
    OnItemClickListener onItemClickListener;

    public void setNotes(CardSourse cardSourse) {
        this.cardSourse = cardSourse;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new myViewHolder(layoutInflater.inflate(R.layout.name_notes_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bindContantWhithView(cardSourse.getCardNote(position));

    }

    @Override
    public int getItemCount() {
        return cardSourse.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewDescription;
        private ImageView imageView;
        private ToggleButton like;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.title);
            textViewDescription = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            like = (ToggleButton) itemView.findViewById(R.id.like);
            textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick();
                    }
                }
            });
        }

        public void bindContantWhithView(CardNote content) {
            textViewName.setText(content.getName());
            textViewDescription.setText(content.getDescription());
            imageView.setBackground(content.getFon());
            like.setChecked(content.isLike());
        }
    }


}


