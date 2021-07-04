package com.example.dentalwelt.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final  int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dentalWelt.db";
    public static final String TABLE_PATIENTS = "pacientesDW";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PATIENTS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "apellidoP TEXT NOT NULL," +
                "apellidoM TEXT NOT NULL," +
                "fechaN TEXT NOT NULL," +
                "genero TEXT NOT NULL," +
                "medico TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_PATIENTS);
        onCreate(db);
    }
}
