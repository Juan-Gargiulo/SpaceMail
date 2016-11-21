package com.SpaceMail.converter;

import com.SpaceMail.entities.Usuario;
import com.SpaceMail.response.CiudadResponse;
import com.SpaceMail.response.UsuarioResponse;

/**
 * Created by juan on 11/20/16.
 */
public class UsuarioConverter implements IUsuarioConverter {


    @Override
    public UsuarioResponse convert(Usuario u) {

        UsuarioResponse r = new UsuarioResponse();
        r.setNombreUsuario( u.getNombreUsuario() );
        r.setNombre( u.getNombre() );
        r.setApellido( u.getApellido() );

        // warning! esto esta hardcodeado, faltaria un ciudad converter.
        CiudadResponse c = new CiudadResponse();
        c.setNombre( u.getCiudad().getNombre() );
        r.setCiudad( c );
        //

        r.setDireccion( u.getDireccion() );
        r.setEmailAlternativo( u.getEmailAlternativo() );
        r.setTeléfono( u.getTelefono() );

        return r;
    }
}
