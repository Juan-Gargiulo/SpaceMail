package com.SpaceMail.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by juan on 11/18/16.
 */
public class MensajeRequest {


    //private Usuario remitente;
    //private List<Usuario> recipientes;

    @JsonProperty("asunto")
    private String asunto;
    @JsonProperty("mensage")
    private String mensage;


//    public Usuario getRemitente() {
//        return remitente;
//    }
//
//    public void setRemitente(Usuario remitente) {
//        this.remitente = remitente;
//    }
//
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