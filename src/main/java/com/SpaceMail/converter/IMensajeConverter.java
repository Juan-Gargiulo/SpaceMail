package com.SpaceMail.converter;

import com.SpaceMail.entities.Mensaje;
import com.SpaceMail.response.MensajeResponse;

/**
 * Created by juan on 11/20/16.
 */
public interface IMensajeConverter {
    public MensajeResponse convert(Mensaje m);
}
