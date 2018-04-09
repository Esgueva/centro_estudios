package com.esgueva.esguevaordonezrodrigo_centrociclo.Controlador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo.Ciclo;
import com.esgueva.esguevaordonezrodrigo_centrociclo.R;

import java.util.List;


public class AdaptadorCiclos extends RecyclerView.Adapter<AdaptadorCiclos.DatosHolder> {

    private List<Ciclo> ciclos;
    private RecyclerViewOnItemClickListener escucha;

    public AdaptadorCiclos(List<Ciclo> ciclos, RecyclerViewOnItemClickListener escucha) {
        this.ciclos = ciclos;
        this.escucha = escucha;
    }

    class DatosHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nombre;
        TextView tipoModulo;
        TextView duracion;
        ImageView imagen;

        DatosHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombre);
            tipoModulo = itemView.findViewById(R.id.txtTipo);
            duracion = itemView.findViewById(R.id.txtDuracion);
            imagen = itemView.findViewById(R.id.imagen);
            itemView.setOnClickListener(this);
        }

        TextView getNombre() {
            return nombre;
        }
        TextView getTipoModulo() {
            return tipoModulo;
        }
        TextView getDuracion() {
            return duracion;
        }
        ImageView getImagen(){ return imagen; }

        @Override
        public void onClick(View view) {
            escucha.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public DatosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fila_ciclos, parent, false);
        return new DatosHolder(fila);
    }

    @Override
    public void onBindViewHolder(AdaptadorCiclos.DatosHolder holder, int position) {
        Ciclo ciclo = ciclos.get(position);

        holder.getNombre().setText(ciclo.getNombre());
        holder.getTipoModulo().setText(ciclo.getTipo());
        holder.getDuracion().setText(ciclo.getDuracion());
        holder.getImagen().setImageResource(ciclo.getImagen());
    }

    @Override
    public int getItemCount() {
        return  ciclos.size();
    }
}
