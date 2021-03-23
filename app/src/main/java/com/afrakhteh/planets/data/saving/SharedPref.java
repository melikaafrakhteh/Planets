package com.afrakhteh.planets.data.saving;

import android.content.Context;
import android.content.SharedPreferences;

import com.afrakhteh.planets.utils.Constants;

public class SharedPref {

    private static SharedPref INSTANCE;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPref(Context context){
        sharedPreferences = context.getSharedPreferences(Constants.SHAERD_KEY,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public static SharedPref getInstance(Context context) {
        if (INSTANCE == null){
            INSTANCE = new SharedPref(context);
        }
        return INSTANCE;
    }

    //check for: Is this the first time this application is installed?

    public void setRunned(){
        editor.putBoolean(Constants.SHAERD_FIRST_KEY,false).apply();
    }
    public boolean getFirstRun(){
        return sharedPreferences.getBoolean(Constants.SHAERD_FIRST_KEY,true);
    }
}
