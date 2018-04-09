package com.esgueva.esguevaordonezrodrigo_centrociclo.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.esgueva.esguevaordonezrodrigo_centrociclo.Controlador.AdaptadorModulos;
import com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo.Ciclo;
import com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo.Modulo;
import com.esgueva.esguevaordonezrodrigo_centrociclo.R;

import java.util.ArrayList;

public class ModulosDetalle extends AppCompatActivity {

    TextView txtNombre, txtTipo, txtDuracion;
    ImageView icono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos_detalle);

        Ciclo ciclo  = getIntent().getParcelableExtra("ciclo");
        ArrayList<Modulo> modulos = ciclo.getModulos();

        String nombreCiclo = ciclo.getNombre();
        String tipo = ciclo.getTipo();
        String duracion = ciclo.getDuracion();
        int imagen = ciclo.getImagen();

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtTipo = (TextView) findViewById(R.id.txtTipo);
        txtDuracion = (TextView) findViewById(R.id.txtDuracion);
        icono = (ImageView) findViewById(R.id.img);

        txtNombre.setText(nombreCiclo);
        txtTipo.setText(tipo);
        txtDuracion.setText(duracion);
        icono.setImageResource(imagen);

        RecyclerView reciclado = (RecyclerView) findViewById(R.id.reciclado);
        reciclado.setLayoutManager(new LinearLayoutManager(this));
        reciclado.setAdapter(new AdaptadorModulos(modulos));
    }
}
