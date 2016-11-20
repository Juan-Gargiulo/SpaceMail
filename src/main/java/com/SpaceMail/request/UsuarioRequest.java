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
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("ciudad")
    private Integer ciudad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCiudad() {
        return ciudad;
    }

    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }


    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }
}
