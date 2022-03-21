package com.example.mynewnotes.repository;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class CardNote implements Parcelable {
    private String name;
    private String description;
    private int fon;
    private boolean like;
    private Date date;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    protected CardNote(Parcel in) {
        name = in.readString();
        description = in.readString();
        fon = in.readInt();
        like = in.readByte() != 0;
        date = new Date(in.readLong());
    }

    public static final Creator<CardNote> CREATOR = new Creator<CardNote>() {
        @Override
        public CardNote createFromParcel(Parcel in) {
            return new CardNote(in);
        }

        @Override
        public CardNote[] newArray(int size) {
            return new CardNote[size];
        }
    };

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLike(boolean like) {
        this.like = like;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFon() {
        return fon;
    }

    public boolean isLike() {
        return like;
    }

    public CardNote(String name, String description, int fon, boolean like, Date date) {
        this.name = name;
        this.description = description;
        this.fon = fon;
        this.like = like;
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(fon);
        parcel.writeByte((byte) (like ? 1 : 0));
        parcel.writeLong(date.getTime());
    }
}
