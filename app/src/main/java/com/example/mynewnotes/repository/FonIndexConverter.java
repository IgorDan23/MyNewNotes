package com.example.mynewnotes.repository;

import com.example.mynewnotes.R;

import java.util.Random;

public class FonIndexConverter {
    private static Random rnd = new Random();
    private static Object syncObj = new Object();

    private static int[] fonIndex = {
            R.color.one,
            R.color.two,
            R.color.three,
            R.color.four,
            R.color.five,
            R.color.six,
            R.color.seven,
    };

    public static int randomPictureIndex(){
        synchronized (syncObj){
            return rnd.nextInt(fonIndex.length);
        }
    }

    public static int getFonByIndex(int index){
        if (index < 0 || index >= fonIndex.length){
            index = 0;
        }
        return fonIndex[index];
    }

    public static int getIndexByFon(int fon){
        for(int i = 0; i < fonIndex.length; i++){
            if (fonIndex[i] == fon){
                return i;
            }
        }
        return 0;
    }

}