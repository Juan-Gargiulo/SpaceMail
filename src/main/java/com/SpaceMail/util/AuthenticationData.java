package com.SpaceMail.util;

import com.SpaceMail.entities.Usuario;
import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by juan on 11/18/16.
 */

@Entity
public class AuthenticationData {

    private Usuario usuario;
    private DateTime lastAction;

    public DateTime getLastAction() {
        return lastAction;
    }

    public void setLastAction(DateTime lastAction) {
        this.lastAction = lastAction;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
