package com.SpaceMail.services;

import com.SpaceMail.entities.*;
import com.SpaceMail.persistence.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by juan on 11/18/16.
 */
@Service
public class UsuarioService {

    UsuarioDao usuarioDao;

    @Autowired
    public UsuarioService(UsuarioDao dao) {
        this.usuarioDao = dao;
    }

    public Usuario login(String nombreUsuario, String password) throws Exception {
        return usuarioDao.get(nombreUsuario, password);
    }

    public void newUsuario(String nombreUsuario,
                           String password,
                           String nombre,
                           String apellido,
                           String direccion,
                           String telefono,
                           Integer id_ciudad,
                           String emailAlternativo) throws Exception {

        Usuario u = new Usuario();
        u.setNombreUsuario(nombreUsuario);
        u.setPassword(password);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setDireccion(direccion);
        u.setTeléfono(telefono);
        u.setEmailAlternativo(emailAlternativo);
        Ciudad c = new Ciudad();
        c.setId(id_ciudad);
        u.setCiudad(c);
        this.usuarioDao.save(u);
    }

    public Usuario buscarUsuarioRuta(String mail) throws Exception {
        return usuarioDao.getByNombreUsuario(mail);
    }

    public void actualizarUsuario(String nombreUsuario,
                                  String nombre,
                                  String apellido,
                                  String direccion,
                                  String telefono,
                                  String emailAlternativo) throws Exception {
        Usuario u = new Usuario();
        u = buscarUsuarioRuta(nombreUsuario);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setDireccion(direccion);
        u.setTeléfono(telefono);
        u.setEmailAlternativo(emailAlternativo);
        System.out.println(u.getId() + u.getNombreUsuario() + u.getNombre());
        usuarioDao.actualizarUsuario(u);
    }
}
