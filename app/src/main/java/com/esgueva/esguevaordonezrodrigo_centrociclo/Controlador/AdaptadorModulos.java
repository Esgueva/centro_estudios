package com.esgueva.esguevaordonezrodrigo_centrociclo.Controlador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo.Modulo;
import com.esgueva.esguevaordonezrodrigo_centrociclo.R;

import java.util.List;


public class AdaptadorModulos extends RecyclerView.Adapter<AdaptadorModulos.DatosHolder> {

    private List<Modulo> modulos;


    public AdaptadorModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    class DatosHolder extends RecyclerView.ViewHolder {

        TextView nombre;

        DatosHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombre);
        }

        TextView getNombre() {
            return nombre;
        }
    }

    @Override
    public DatosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fila_modulo, parent, false);
        return new DatosHolder(fila);
    }

    @Override
    public void onBindViewHolder(AdaptadorModulos.DatosHolder holder, int position) {
        Modulo modulo = modulos.get(position);
        holder.getNombre().setText(modulo.getNombre());
    }

    @Override
    public int getItemCount() {
        return  modulos.size();
    }
}
