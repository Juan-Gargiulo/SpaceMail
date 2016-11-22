package com.SpaceMail.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by juan on 11/18/16.
 */
public class MensajeRequest {

    @JsonProperty("remitente")
    private Integer remitente;
    @JsonProperty("asunto")
    private String asunto;
    @JsonProperty("mensaje")
    private String mensage;
    @JsonProperty("recipientes")
    private ArrayList<Integer> recipientes;
    @JsonProperty("id")
    private Integer idMensaje;


    public Integer getRemitente() {
        return remitente;
    }

    public void setRemitente(Integer remitente) {
        this.remitente = remitente;
    }


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


    public ArrayList<Integer> getRecipientes() {
        return recipientes;
    }

    public void setRecipientes(ArrayList<Integer> recipientes) {
        this.recipientes = recipientes;
    }


    public Integer getIdMensaje() {return idMensaje;}

    public void setIdMensaje(Integer idMensaje) {this.idMensaje = idMensaje;}
}
