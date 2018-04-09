package com.esgueva.esguevaordonezrodrigo_centrociclo.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo.Usuario;
import com.esgueva.esguevaordonezrodrigo_centrociclo.R;

import java.util.ArrayList;


public class Activity_Inicio extends AppCompatActivity {

    private ArrayList<Usuario> usuarios;

    private Integer tipoUsuario;
    private TextView txtPassword;
    private Integer intentos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button btnAutenticar = (Button)findViewById(R.id.btnAutenticar);
        btnAutenticar.setOnClickListener(pulsarBoton);

        inicializarUsuarios();

        txtPassword = (TextView) findViewById(R.id.txtPassword);

        ArrayAdapter<Usuario> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usuarios);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(pulsacion);
    }

    private View.OnClickListener pulsarBoton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (txtPassword.getText().toString().equalsIgnoreCase(usuarios.get(tipoUsuario).getPassword())){
                Intent intent = new Intent(Activity_Inicio.this, CiclosFormativos.class);
                intent.putExtra(getString(R.string.tipoUsuario),tipoUsuario);
                startActivity(intent);
            }else{
                intentos = intentos+1;
                Toast.makeText(Activity_Inicio.this,getString(R.string.falloAuten) + " " + (3-intentos) + " " + getString(R.string.intentos),Toast.LENGTH_SHORT).show();
                if (intentos == 3){
                    Toast.makeText(Activity_Inicio.this, R.string.apkClose,Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    };

    private AdapterView.OnItemSelectedListener pulsacion = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(Activity_Inicio.this,getString(R.string.seleccion) + usuarios.get(i).getLogin(),Toast.LENGTH_SHORT).show();
            tipoUsuario = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    private void inicializarUsuarios(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(getString(R.string.userInvitado),getString(R.string.passInvitado)));
        usuarios.add(new Usuario(getString(R.string.userAlumno),getString(R.string.passAlumno)));
    }
}
