package com.project.techaract.amclub.Utils;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceClass {

    private SharedPreferences sharedPreferences;
    private String SharedPrefString;
    private SharedPreferences.Editor editor;

    public static String Login = "Login";
    public static String PackageContainer = "PackageContainer";

    public SharedPreferenceClass(Context context, String SharePref){
        sharedPreferences = context.getSharedPreferences(SharePref,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void SetStringEditor(String Key, String Value){
        editor.putString(Key,Value);

    }
    public void SetIntegerEditor(String Key, int Value){
        editor.putInt(Key,Value);
    }
    public void SetBooleanEditor(String Key, Boolean Value){
        editor.putBoolean(Key,Value);
    }
    public void DoCommit(){
        editor.commit();
    }

    public Boolean getBoolean(String Field){
        return sharedPreferences.getBoolean(Field,false);
    }

    public String getString(String Field){
        return sharedPreferences.getString(Field,"");
    }
    public int getInteger(String Field){
        return sharedPreferences.getInt(Field,-1);
    }

    public void RemoveValue(String Field){
        editor.remove(Field);
    }

    public void ClearData(){
        editor.clear();
    }

}
