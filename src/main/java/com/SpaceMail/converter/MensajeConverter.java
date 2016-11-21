package com.SpaceMail.converter;

import com.SpaceMail.entities.Mensaje;
import com.SpaceMail.response.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by juan on 11/20/16.
 */
public class MensajeConverter implements IMensajeConverter {

    public MensajeConverter(){}

    @Autowired
    @Qualifier("usuarioConverter")
    IUsuarioConverter usuarioConverter;

    @Override
    public MensajeResponse convert(Mensaje m) {

        MensajeResponse r = new MensajeResponse();
        r.setId( m.getId() );
        r.setAsunto( m.getAsunto() );
        r.setMensage( m.getMensage() );

        r.setRemitente(usuarioConverter.convert(m.getRemitente()));


        return r;
    }
}
