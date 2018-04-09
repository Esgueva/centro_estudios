package com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo;

import android.os.Parcel;
import android.os.Parcelable;


public class Modulo implements Parcelable {
    private String nombre;

    Modulo(String nombre) {
        this.nombre = nombre;
    }

    private Modulo(Parcel in) {
        nombre = in.readString();
    }

    public static final Creator<Modulo> CREATOR = new Creator<Modulo>() {
        @Override
        public Modulo createFromParcel(Parcel in) {
            return new Modulo(in);
        }

        @Override
        public Modulo[] newArray(int size) {
            return new Modulo[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
    }
}
