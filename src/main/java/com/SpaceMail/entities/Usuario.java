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

    private String Nombre;
    private String Apellido;
    private String Dirección;
    private String Teléfono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_ciudad")
    private Ciudad ciudad;

    private String emailAlternativo;

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

    @Column(name="nombre", length = 30)
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Column(name="apellido", length = 30)
    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    @Column(name="direccion", length = 30)
    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String dirección) {
        Dirección = dirección;
    }

    @Column(name="telefono", length = 30)
    public String getTeléfono() {
        return Teléfono;
    }

    public void setTeléfono(String teléfono) {
        Teléfono = teléfono;
    }

    @Column(name="ciudad", length = 30)
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        ciudad = ciudad;
    }

    @Column(name="emailAlternativo", nullable = false, length = 30)
    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }
}
