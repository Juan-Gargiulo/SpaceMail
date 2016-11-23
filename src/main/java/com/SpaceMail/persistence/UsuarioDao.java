package com.SpaceMail.persistence;

import com.SpaceMail.entities.Usuario;
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
public class UsuarioDao extends AbstractDao<Usuario> {

    @Autowired
    public UsuarioDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    List<Usuario> getAll() {
        return null;
    }

    @Override
    Usuario getById(int id) {
        return null;
    }

    @Override
    public void save(Usuario u) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(u);
        t.commit();
        session.close();
    }

    public Usuario get(String nombreUsuario, String password) {

        Session session = this.sessionFactory.openSession();
        List<Usuario> list = session.createQuery("FROM Usuario where nombreUsuario = :u and password = :p").setParameter("u",nombreUsuario).setParameter("p",password).list();
        session.close();
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public Usuario getByNombreUsuario(String mail)
    {
        Session session = this.sessionFactory.openSession();
        List<Usuario> list = session.createQuery("FROM Usuario where nombreUsuario = :nU").setParameter("nU",mail).list();
        session.close();
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public void actualizarUsuario(Usuario usuario){
        Session session = this.sessionFactory.openSession();
        session.update(usuario);
        session.close();
    }
}
