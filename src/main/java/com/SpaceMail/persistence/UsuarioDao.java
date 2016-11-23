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
    public void save(Usuario u) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            session.save(u);
            t.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public Usuario get(String nombreUsuario, String password) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            List<Usuario> list = session.createQuery("FROM Usuario where nombreUsuario = :u and password = :p").setParameter("u", nombreUsuario).setParameter("p", password).list();
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public Usuario getByNombreUsuario(String mail) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            List<Usuario> list = session.createQuery("FROM Usuario where nombreUsuario = :nU").setParameter("nU", mail).list();
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public void actualizarUsuario(Usuario usuario) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            session.update(usuario);
            t.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
