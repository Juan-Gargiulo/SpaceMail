package com.SpaceMail.persistence;

import com.SpaceMail.entities.Mensaje;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by juan on 11/18/16.
 */
@Repository
public class MensajeDao extends AbstractDao<Mensaje> {

    @Autowired
    public MensajeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Mensaje> getOutbox(String mail) {
        Session session = this.sessionFactory.openSession();
        List<Mensaje> lista = session.createQuery("from Mensaje where remitente.nombreUsuario = :usuario").setParameter("usuario", mail).list();

        return lista;
    }

    public List<Mensaje> getInbox(String mail) {

        Session session = this.sessionFactory.openSession();

        Query query = session.createSQLQuery(
                "select m.* from usuarios u " +
                        "inner join mensaje_usuario mu on u.id = mu.id_usuario " +
                        "inner join mensajes m on m.id = mu.id_mensaje " +
                        "where u.nombreUsuario = :usuario")
                .addEntity(Mensaje.class)
                .setParameter("usuario", mail);

        List<Mensaje> result = query.list();
        return result;
    }

    List<Mensaje> getAll() {
        return null;
    }

    Mensaje getById(int id) {
        return null;
    }

    public void save(Mensaje m) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(m);
        t.commit();
        session.close();
    }

    public void delete(Integer idMensaje) {
        Mensaje m = new Mensaje();
        m.setId(idMensaje);
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.delete(m);
        t.commit();
        session.close();
    }
}
