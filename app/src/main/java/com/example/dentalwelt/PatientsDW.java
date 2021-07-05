package com.example.dentalwelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dentalwelt.db.dbPacientes;

public class PatientsDW extends AppCompatActivity {

    EditText txtNombre, txtApellidoP, txtApellidoM, txtFechaN, txtGenero, txtMedico, txtTelefono, txtEmail;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_dw);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidoP = findViewById(R.id.txtApellidoP);
        txtApellidoM = findViewById(R.id.txtApellidoM);
        txtFechaN = findViewById(R.id.txtFechaN);
        txtGenero = findViewById(R.id.txtGenero);
        txtMedico = findViewById(R.id.txtMedico);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbPacientes dbP = new dbPacientes(PatientsDW.this);
                long id = dbP.insertarP(txtNombre.getText().toString(), txtApellidoP.getText().toString(), txtApellidoM.getText().toString(), txtFechaN.getText().toString(), txtGenero.getText().toString(), txtMedico.getText().toString(), txtTelefono.getText().toString(), txtEmail.getText().toString());
                if (id > 0){
                    Toast.makeText(PatientsDW.this, "REGISTRO GUARDADO CON ÉXITO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else{
                    Toast.makeText(PatientsDW.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar (){
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtFechaN.setText("");
        txtGenero.setText("");
        txtMedico.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }
}