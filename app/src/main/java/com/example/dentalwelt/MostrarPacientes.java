package com.example.dentalwelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dentalwelt.adaptadores.ListaPacientesAdapter;
import com.example.dentalwelt.db.dbPacientes;
import com.example.dentalwelt.entidades.Pacientes;

import java.util.ArrayList;

public class MostrarPacientes extends AppCompatActivity {

    RecyclerView listaPacientes;
    ArrayList<Pacientes> listaArrayPacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pacientes);
        listaPacientes = findViewById(R.id.listaPacientes);
        listaPacientes.setLayoutManager(new LinearLayoutManager(this));

        dbPacientes dbPacientes = new dbPacientes(MostrarPacientes.this);
        listaArrayPacientes = new ArrayList<>();
        ListaPacientesAdapter adapter = new ListaPacientesAdapter(dbPacientes.mostrarPacientes());
        listaPacientes.setAdapter(adapter);
    }
}