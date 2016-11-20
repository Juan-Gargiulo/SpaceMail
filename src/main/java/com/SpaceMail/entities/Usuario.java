package com.SpaceMail.entities;

import javax.persistence.*;

/**
 * Created by juan on 11/18/16.
 */


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nombreUsuario;
    private String password;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="nombre_usuario", nullable = false, length = 30)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Column(name="password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
