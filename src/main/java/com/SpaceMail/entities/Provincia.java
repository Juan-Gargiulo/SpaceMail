package com.SpaceMail.entities;

import javax.persistence.*;

/**
 * Created by User on 20/11/2016.
 */
@Entity
@Table(name = "provincias")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre_provincia", nullable = false, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
