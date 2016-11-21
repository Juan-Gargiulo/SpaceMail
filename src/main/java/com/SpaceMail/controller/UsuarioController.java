package com.SpaceMail.controller;

import com.SpaceMail.converter.IMensajeConverter;
import com.SpaceMail.entities.Mensaje;
import com.SpaceMail.entities.Usuario;
import com.SpaceMail.response.LoginResponseWrapper;
import com.SpaceMail.response.MensajeResponse;
import com.SpaceMail.services.MensajeService;
import com.SpaceMail.services.UsuarioService;
import com.SpaceMail.util.SessionData;
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
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MensajeService mensajeService;

    @Autowired
    SessionData sessionData;

    @Autowired
    @Qualifier("mensajeConverter")
    IMensajeConverter converter;


    @RequestMapping("/api/{id}/inbox")
    public @ResponseBody ResponseEntity<List<MensajeResponse>> getInbox(@PathVariable("id") Integer id) {
        List<Mensaje> mensajes = mensajeService.getInbox(id);
        if (mensajes.size()>0) {
            return new ResponseEntity<List<MensajeResponse>>(this.convertList(mensajes), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<MensajeResponse>>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<LoginResponseWrapper> getById(@RequestParam("user") String nombreUsuario, @RequestParam("pwd") String pwd) {
        Usuario u = usuarioService.login(nombreUsuario, pwd);
        if (null != u) {
            String sessionId = sessionData.addSession(u);
            return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(sessionId), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping("/logout")
    public
    @ResponseBody
    ResponseEntity getById(@RequestHeader("sessionid") String sessionId) {
        sessionData.removeSession(sessionId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/registrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //public ResponseEntity addUsuario(@RequestBody UsuarioRequest request) {
    public ResponseEntity addUsuario(@RequestParam("usr") String nombreUsuario,
                                     @RequestParam("pwd") String password,
                                     @RequestParam("apellido") String apellido,
                                     @RequestParam("nombre") String nombre,
                                     @RequestParam("direccion") String direccion,
                                     @RequestParam("tel") String telefono,
                                     @RequestParam("ciudad") Integer ciudad,
                                     @RequestParam("emailAlt") String emailAlternativo) {
        try {
            System.out.println("controler usuario:" + nombreUsuario);
            usuarioService.newUsuario(
                    nombreUsuario,
                    password,
                    nombre,
                    apellido,
                    direccion,
                    telefono,
                    ciudad,
                    emailAlternativo
            );

            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // convierte una lista de mensajes en una lista de mensajes de response.
    private List<MensajeResponse> convertList(List<Mensaje> mensajes ){
        List<MensajeResponse> mensajeResponseList = new ArrayList<MensajeResponse>();
        for (Mensaje m : mensajes) {
            mensajeResponseList.add(converter.convert(m));
        }
        return mensajeResponseList;
    }


}