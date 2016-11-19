package com.SpaceMail.services;

import com.SpaceMail.entities.Mensaje;
import com.SpaceMail.persistence.MensajeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by juan on 11/18/16.
 */
@Service
public class MensajeService {

    @Autowired
    MensajeDao mensajeDao;

    @Autowired
    public MensajeService(MensajeDao dao) {
        this.mensajeDao = dao;
    }

    public void newMensaje(String asunto, String mensaje) throws ParseException {
        Mensaje m = new Mensaje();
        m.setAsunto(asunto);
        m.setMensage(mensaje);
        this.mensajeDao.save(m);
    }
}
