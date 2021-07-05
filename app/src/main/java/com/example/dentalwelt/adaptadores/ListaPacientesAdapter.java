package com.example.dentalwelt.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalwelt.R;
import com.example.dentalwelt.entidades.Pacientes;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ListaPacientesAdapter extends RecyclerView.Adapter<ListaPacientesAdapter.PacienteViewHolder> {

    ArrayList<Pacientes> listaPacientes;

    public ListaPacientesAdapter(ArrayList<Pacientes> listaPacientes){
        this.listaPacientes = listaPacientes;
    }

    @NonNull
    @NotNull
    @Override
    public PacienteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_paciente, null, false);
        return new PacienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListaPacientesAdapter.PacienteViewHolder holder, int position) {
        holder.txtNombre.setText(listaPacientes.get(position).getNombre());
        holder.txtTelefono.setText(listaPacientes.get(position).getTelefono());
        holder.txtEmail.setText(listaPacientes.get(position).getEmail());
        holder.txtMedico.setText(listaPacientes.get(position).getMedico());
    }

    @Override
    public int getItemCount() {
        return listaPacientes.size();
    }

    public class PacienteViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre, txtTelefono, txtEmail, txtMedico;

        public PacienteViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtMedico = itemView.findViewById(R.id.txtEmail);
        }
    }
}
