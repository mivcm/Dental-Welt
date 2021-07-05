package com.example.dentalwelt.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dentalwelt.entidades.Pacientes;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

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

    public ArrayList<Pacientes> mostrarPacientes(){
        dbHelper dbH = new dbHelper(context);
        SQLiteDatabase db = dbH.getWritableDatabase();

        ArrayList<Pacientes> listaPacientes = new ArrayList<>();
        Pacientes p = null;
        Cursor cursorPacientes = null;
        cursorPacientes = db.rawQuery("SELECT * FROM " + TABLE_PATIENTS, null);
        if (cursorPacientes.moveToFirst()){
            do {
                p = new Pacientes();
                p.setId(cursorPacientes.getInt(0));
                p.setNombre(cursorPacientes.getString(1));
                p.setTelefono(cursorPacientes.getString(2));
                p.setEmail(cursorPacientes.getString(3));
                p.setMedico(cursorPacientes.getString(4));
                listaPacientes.add(p);
            }while(cursorPacientes.moveToNext());
        }

        cursorPacientes.close();
        return listaPacientes;
    }
}
