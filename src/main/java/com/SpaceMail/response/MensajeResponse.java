package com.SpaceMail.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by juan on 11/20/16.
 */
public class MensajeResponse {

    @JsonProperty
    private int id;
    @JsonProperty
    private UsuarioResponse remitente;
//    @JsonProperty
//    private List<Usuario> recipientes;
    @JsonProperty
    private String asunto;
    @JsonProperty
    private String mensage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioResponse getRemitente() {
        return remitente;
    }

    public void setRemitente(UsuarioResponse remitente) {
        this.remitente = remitente;
    }

//    public List<Usuario> getRecipientes() {
//        return recipientes;
//    }
//
//    public void setRecipientes(List<Usuario> recipientes) {
//        this.recipientes = recipientes;
//    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}
