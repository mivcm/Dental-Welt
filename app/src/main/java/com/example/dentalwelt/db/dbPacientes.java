package com.example.dentalwelt.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.jetbrains.annotations.Nullable;

public class dbPacientes extends dbHelper {
    Context context;
    public dbPacientes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarP (String nombre, String apellidoP, String apellidoM, String fechaN, String genero, String medico, String telefono, String email) {
        long id = 0;
        try {
            dbHelper dbH = new dbHelper(context);
            SQLiteDatabase db = dbH.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre", nombre);
            values.put("Apellido Paterno", apellidoP);
            values.put("Apellido Materno", apellidoM);
            values.put("Fecha de nacimiento", fechaN);
            values.put("Genero", genero);
            values.put("Medico", medico);
            values.put("Telefono", telefono);
            values.put("Email", email);

            id = db.insert(TABLE_PATIENTS, null, values);
        } catch (Exception exception){
            exception.toString();
        }
        return id;
    }
}
