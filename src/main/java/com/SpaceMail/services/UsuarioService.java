package com.SpaceMail.services;

import com.SpaceMail.entities.Usuario;
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

    public Usuario login(String nombreUsuario, String password) {
        return usuarioDao.get(nombreUsuario,password);
    }
}