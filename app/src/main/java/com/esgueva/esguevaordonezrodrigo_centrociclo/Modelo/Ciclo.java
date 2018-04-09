package com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Ciclo implements Parcelable {
    private String nombre, tipo;
    private String duracion;
    private int imagen;
    private ArrayList<Modulo> modulos;

    public Ciclo(String nombre, String tipo, String duracion, int imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
        this.imagen = imagen;
        this.modulos = new ArrayList<>();
    }

    private Ciclo(Parcel in) {
        nombre = in.readString();
        tipo = in.readString();
        duracion = in.readString();
        imagen = in.readInt();
        modulos = in.createTypedArrayList(Modulo.CREATOR);
    }

    public static final Creator<Ciclo> CREATOR = new Creator<Ciclo>() {
        @Override
        public Ciclo createFromParcel(Parcel in) {
            return new Ciclo(in);
        }

        @Override
        public Ciclo[] newArray(int size) {
            return new Ciclo[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getImagen() { return imagen; }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void addModulo(String nombre){
        modulos.add(new Modulo(nombre));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(tipo);
        parcel.writeString(duracion);
        parcel.writeInt(imagen);
        parcel.writeTypedList(modulos);
    }
}
