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
    Button btnConectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConectar = findViewById(R.id.btnConectar);

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
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, PatientsDW.class);
        startActivity(intent);
    }
}