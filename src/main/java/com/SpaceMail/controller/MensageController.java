package com.SpaceMail.controller;

import com.SpaceMail.request.MensajeRequest;
import com.SpaceMail.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    MensajeService mensajeService;

    @RequestMapping(value = "/mensaje", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMensaje(@RequestBody MensajeRequest request) {
        try {
            mensajeService.newMensaje(request.getAsunto(), request.getMensage(), request.getRemitente(), request.getRecipientes() );
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/mensaje", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMensaje(@RequestBody MensajeRequest request) {
        try {
            //HACER LO QUE CORRESPONDA :P
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
