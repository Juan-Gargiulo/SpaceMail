package com.SpaceMail.converter;


import com.SpaceMail.entities.Usuario;
import com.SpaceMail.response.UsuarioResponse;

/**
 * Created by juan on 11/20/16.
 */
public interface IUsuarioConverter {

    public UsuarioResponse convert(Usuario u);

}
