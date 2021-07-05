package com.example.dentalwelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.dentalwelt.db.dbHelper;

public class MainActivity extends AppCompatActivity {
    Button btnConectar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConectar = findViewById(R.id.btnConectar);
        btnMostrar = findViewById(R.id.btnMostrar);

        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbH = new dbHelper(MainActivity.this);
                SQLiteDatabase db = dbH.getWritableDatabase();
                if (db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA CON ÉXITO", Toast.LENGTH_LONG).show();
                    nuevoRegistro();
                } else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarPacientes();
            }
        });
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, PatientsDW.class);
        startActivity(intent);
    }

    private void mostrarPacientes (){
        Intent intent = new Intent(this, MostrarPacientes.class);
        startActivity(intent);
    }
}