package com.example.class3;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ilandbt on 02/11/2015.
 */
public class Utils {



    //shared preferences name
    public static final String sharedPrefsName = "Class2SharedPrefs";

    //shared preferences keys
    public static final String userName = "userName";


    //returns shared preferences
    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(sharedPrefsName, Context.MODE_PRIVATE);
    }

    //returns shared preferences editor
    public static SharedPreferences.Editor getSharedPreferencesEditor(Context context){
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.edit();
    }
}