package com.SpaceMail.controller;

import com.SpaceMail.converter.IMensajeConverter;
import com.SpaceMail.converter.IUsuarioConverter;
import com.SpaceMail.entities.Mensaje;
import com.SpaceMail.entities.Usuario;
import com.SpaceMail.request.MensajeRequest;
import com.SpaceMail.response.MensajeResponse;
import com.SpaceMail.services.MensajeService;
import com.SpaceMail.services.UsuarioService;
import com.SpaceMail.util.SessionData;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juan on 11/18/16.
 */

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class MensageController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MensajeService mensajeService;

    @Autowired
    @Qualifier("mensajeConverter")
    IMensajeConverter mensajeConverter;

    @RequestMapping("/{mail}/inbox")
    public
    @ResponseBody
    ResponseEntity<List<MensajeResponse>> getInbox(@PathVariable("mail") String mail,
                                                   @RequestHeader("usuario") String mailHeader) {
        //valido que sea el usuario logueado
        if (!mail.equals(mailHeader)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        List<Mensaje> mensajes = mensajeService.getInbox(mail);
        if (mensajes.size() > 0) {
            return new ResponseEntity<List<MensajeResponse>>(this.convertList(mensajes), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<MensajeResponse>>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping("/{mail}/outbox")
    public
    @ResponseBody
    ResponseEntity<List<MensajeResponse>> getOutbox(@PathVariable("mail") String mail,
                                                    @RequestHeader("usuario") String mailHeader) {

        //valido que sea el usuario logueado
        if (!mail.equals(mailHeader)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        List<Mensaje> mensajes = mensajeService.getOutbox(mail);
        if (mensajes.size() > 0) {
            return new ResponseEntity<List<MensajeResponse>>(this.convertList(mensajes), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<MensajeResponse>>(HttpStatus.NO_CONTENT);
        }
    }

    // Guardar Mensaje nuevo POST
    @RequestMapping(value = "/usuario/{mail}/mensaje", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMensaje(@RequestBody MensajeRequest request, @PathVariable("mail") String mail) {
        try {
            Usuario remitente = usuarioService.buscarUsuarioRuta(mail);
            mensajeService.newMensaje(request.getAsunto(), request.getMensage(), remitente, request.getRecipientes());
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // convierte una lista de mensajes en una lista de mensajes de response.
    private List<MensajeResponse> convertList(List<Mensaje> mensajes) {
        List<MensajeResponse> mensajeResponseList = new ArrayList<MensajeResponse>();
        for (Mensaje m : mensajes) {
            mensajeResponseList.add(mensajeConverter.convert(m));
        }
        return mensajeResponseList;
    }

    // Borrar Mensaje
    @RequestMapping(value = "/usuario/{mail}/mensaje", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMensaje(@RequestBody MensajeRequest request) {
        try {
            mensajeService.deleteMensaje(request.getIdMensaje());
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
