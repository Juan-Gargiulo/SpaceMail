package com.SpaceMail.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by juan on 11/20/16.
 */
public class UsuarioResponse {


    @JsonProperty
    private String nombreUsuario;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String apellido;
    @JsonProperty
    private String dirección;
    @JsonProperty
    private String teléfono;
    @JsonProperty
    private CiudadResponse ciudad;
    @JsonProperty
    private String emailAlternativo;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public CiudadResponse getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadResponse ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }
}
