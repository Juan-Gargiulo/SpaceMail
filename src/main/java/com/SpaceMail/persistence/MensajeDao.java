package com.SpaceMail.persistence;

import com.SpaceMail.entities.Mensaje;
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
}
