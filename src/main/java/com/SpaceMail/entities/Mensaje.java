package com.SpaceMail.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by juan on 11/18/16.
 */
@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario remitente;

    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinTable(name = "mensaje_usuario",
            joinColumns = @JoinColumn(name = "id_mensaje"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> recipientes;
    private String asunto;
    private String mensage;
    //private Date fechaEnvio;
    //private List<String> adjuntos;

    public Mensaje() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public List<Usuario> getRecipientes() {
        return recipientes;
    }

    public void setRecipientes(List<Usuario> recipientes) {
        this.recipientes = recipientes;
    }

    @Column(name = "asunto", nullable = false, length = 20)
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Column(name = "mensage", nullable = false, length = 500)
    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

//    @Column(name="fechaEnvio", nullable = true)
//    public Date getFechaEnvio() {
//        return fechaEnvio;
//    }
//
//    public void setFechaEnvio(Date fechaEnvio) {
//        this.fechaEnvio = fechaEnvio;
//    }


//    public List<String> getAdjuntos() {
//        return adjuntos;
//    }
//
//    public void setAdjuntos(List<String> adjuntos) {
//        this.adjuntos = adjuntos;
//    }

}
