package com.SpaceMail.services;

import com.SpaceMail.entities.Mensaje;
import com.SpaceMail.entities.Usuario;
import com.SpaceMail.persistence.MensajeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Mensaje> getInbox(String mail){

        return mensajeDao.getInbox(mail);

    }

    public void newMensaje(String asunto, String mensaje, Integer id_remitente, ArrayList<Integer> recipientes) throws ParseException {

        Mensaje m = new Mensaje();
        m.setAsunto(asunto);
        m.setMensage(mensaje);
        Usuario rem = new Usuario();
        rem.setId(id_remitente);
        m.setRemitente(rem);

        //cargo los recipientes
        ArrayList<Usuario> recipPersist = new ArrayList<Usuario>();
        for (Integer i : recipientes) {
            Usuario rem2 = new Usuario();
            rem2.setId(i);
            recipPersist.add(rem2);
        }
        m.setRecipientes(recipPersist);

        this.mensajeDao.save(m);
    }
}
