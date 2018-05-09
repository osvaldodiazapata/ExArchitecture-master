package com.example.cleanarchitecture;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by osval on 9/05/18.
 */

public class ContactosSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE contactos ("+
            "id     INTEGER PRIMARY KEY AUTOINCREMENT, " +//0
            "nombre     TEXT, "+//1
            "telefono   TEXT, "+//2
            "correo     TEXT)";//3

    public ContactosSQLiteHelper(Context context,
                                 String name,
                                 SQLiteDatabase.CursorFactory factory,
                                 int version) {
        super(context, name, factory, version);
    }

    /*public ContactosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contactos");
        db.execSQL(sqlCreate);
    }
}
