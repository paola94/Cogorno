package com.example.paola.cogornonew;

import android.content.Context;
import android.content.SharedPreferences;

public class Sessione {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Sessione(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedIn(boolean loggedIn){
        editor.putBoolean("loggedInMode", loggedIn);
        editor.commit();
    }

    public boolean loggedIn(){
        return prefs.getBoolean("loggedInMode", false);
    }
}
