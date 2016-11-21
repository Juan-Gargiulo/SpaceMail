package com.SpaceMail.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by juan on 11/20/16.
 */
public class CiudadResponse {

    @JsonProperty
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
