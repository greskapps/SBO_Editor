package com.greskapps.sboeditor;

import com.google.firebase.database.FirebaseDatabase;

public class FBRealtimeDatabaseUtils {

    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase(){
        if(mDatabase == null){
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }
}
// tip from https://stackoverflow.com/questions/37448186/setpersistenceenabledtrue-crashes-app via C.G.