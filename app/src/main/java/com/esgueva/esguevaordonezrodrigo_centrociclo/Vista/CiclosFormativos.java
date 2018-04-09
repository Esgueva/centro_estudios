package com.esgueva.esguevaordonezrodrigo_centrociclo.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.esgueva.esguevaordonezrodrigo_centrociclo.Controlador.AdaptadorCiclos;
import com.esgueva.esguevaordonezrodrigo_centrociclo.Controlador.RecyclerViewOnItemClickListener;
import com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo.Ciclo;
import com.esgueva.esguevaordonezrodrigo_centrociclo.R;

import java.util.ArrayList;
import java.util.List;

public class CiclosFormativos extends AppCompatActivity {

    private List<Ciclo> ciclos;
    public Integer tipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarCiclos();

        tipoUsuario = getIntent().getIntExtra(getString(R.string.tipoUsuario),0);

        RecyclerView reciclado = (RecyclerView) findViewById(R.id.reciclado);
        reciclado.setLayoutManager(new LinearLayoutManager(this));
        reciclado.setAdapter(new AdaptadorCiclos(ciclos, escucha));
    }

    private RecyclerViewOnItemClickListener escucha = new RecyclerViewOnItemClickListener() {
        @Override
        public void onClick(View v, int posicion) {
            if (tipoUsuario == 1){
                Ciclo ciclo = ciclos.get(posicion);
                Intent intent = new Intent(CiclosFormativos.this, ModulosDetalle.class);
                intent.putExtra(getString(R.string.ciclo),ciclo);
                startActivity(intent);

            }else{
                Toast.makeText(CiclosFormativos.this, R.string.soloAlumnos,Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void inicializarCiclos(){

        ciclos = new ArrayList<>();

        ciclos.add(new Ciclo(getString(R.string.tituloApp),getString(R.string.gSuperior),getString(R.string.horas300),R.drawable.apk));
        ciclos.add(new Ciclo(getString(R.string.tituloWeb),getString(R.string.gSuperior),getString(R.string.horas280),R.drawable.web));
        ciclos.add(new Ciclo(getString(R.string.tituloAdmon),getString(R.string.gMedio),getString(R.string.horas310),R.drawable.admon));
        ciclos.add(new Ciclo(getString(R.string.tituloComercio),getString(R.string.gSuperior),getString(R.string.horas250),R.drawable.comercio));
        ciclos.add(new Ciclo(getString(R.string.tituloMecanizado),getString(R.string.gMedio),getString(R.string.horas260),R.drawable.mecanizado));

        ciclos.get(0).addModulo(getString(R.string.android));
        ciclos.get(0).addModulo(getString(R.string.procesos));
        ciclos.get(0).addModulo(getString(R.string.vBasic));
        ciclos.get(0).addModulo(getString(R.string.acceso));
        ciclos.get(0).addModulo(getString(R.string.sap));
        ciclos.get(0).addModulo(getString(R.string.iEmpred));

        ciclos.get(1).addModulo(getString(R.string.html));
        ciclos.get(1).addModulo(getString(R.string.php));
        ciclos.get(1).addModulo(getString(R.string.css));
        ciclos.get(1).addModulo(getString(R.string.basesDatos));

        ciclos.get(2).addModulo(getString(R.string.empresa));
        ciclos.get(2).addModulo(getString(R.string.marketing));
        ciclos.get(2).addModulo(getString(R.string.excel));
        ciclos.get(2).addModulo(getString(R.string.sap));

        ciclos.get(3).addModulo(getString(R.string.excel));
        ciclos.get(3).addModulo(getString(R.string.iEmpred));
        ciclos.get(3).addModulo(getString(R.string.marketing));
        ciclos.get(3).addModulo(getString(R.string.excel));

        ciclos.get(4).addModulo(getString(R.string.vistas));
        ciclos.get(4).addModulo(getString(R.string.torno));
        ciclos.get(4).addModulo(getString(R.string.prevencion));
    }

}
