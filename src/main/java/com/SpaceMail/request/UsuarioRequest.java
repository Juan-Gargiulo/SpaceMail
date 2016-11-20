package com.SpaceMail.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by User on 20/11/2016.
 */
public class UsuarioRequest {

    @JsonProperty("usr")
    private String nombreUsuario;
    @JsonProperty("pwd")
    private String password;
    @JsonProperty("emailAlt")
    private String emailAlternativo;


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }
}
