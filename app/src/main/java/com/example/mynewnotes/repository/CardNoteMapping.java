package com.example.mynewnotes.repository;

import com.google.firebase.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CardNoteMapping {
    public static class Fields{
    public final static String NAME="name";
    public final static String DESCRIPTION = "description";
    public final static String FON="fon";
    public final static String LIKE="like";
    public final static String DATE="date";
    }

    public static CardNote toCardNote(String id, Map<String, Object> doc) {
        long indexPic = (long) doc.get(Fields.FON);
        Timestamp timeStamp = (Timestamp)doc.get(Fields.DATE);
        CardNote answer = new CardNote((String) doc.get(Fields.NAME),
                (String) doc.get(Fields.DESCRIPTION),
                FonIndexConverter.getFonByIndex((int) indexPic),
                (boolean) doc.get(Fields.LIKE),
                timeStamp.toDate());
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(CardNote cardNote){
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.NAME, cardNote.getName());
        answer.put(Fields.DESCRIPTION, cardNote.getDescription());
        answer.put(Fields.FON, FonIndexConverter.getIndexByFon(cardNote.getFon()));
        answer.put(Fields.LIKE, cardNote.isLike());
        answer.put(Fields.DATE, cardNote.getDate());
        return answer;
    }


}
