package com.SpaceMail.controller;

import com.SpaceMail.converter.IUsuarioConverter;
import com.SpaceMail.entities.Usuario;
import com.SpaceMail.response.UsuarioResponse;
import com.SpaceMail.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juan on 11/18/16.
 */
@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    @Qualifier("usuarioConverter")
    IUsuarioConverter usuarioConverter;

    // busca los datos del usuario a partir del nombre de usuario
    @RequestMapping(value = "/usuario/{mail}", method = RequestMethod.GET)
    public ResponseEntity getUsuario(@RequestBody @PathVariable("mail") String mail) {
        try {
            Usuario auxUsuario = usuarioService.buscarUsuarioRuta(mail);
            return new ResponseEntity<UsuarioResponse>(usuarioConverter.convert(auxUsuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<UsuarioResponse>(HttpStatus.NO_CONTENT);
        }
    }

}