package com.esgueva.esguevaordonezrodrigo_centrociclo.Modelo;


public class Usuario {
    private String login, password;

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return login;
    }

}
