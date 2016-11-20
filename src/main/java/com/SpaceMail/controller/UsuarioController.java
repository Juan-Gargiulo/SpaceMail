package com.SpaceMail.controller;

import com.SpaceMail.entities.Usuario;
import com.SpaceMail.request.UsuarioRequest;
import com.SpaceMail.response.LoginResponseWrapper;
import com.SpaceMail.services.UsuarioService;
import com.SpaceMail.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juan on 11/18/16.
 */
@RestController
@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE
)
public class UsuarioController {

    //Hay que crear esta Clase !!
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    SessionData sessionData;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<LoginResponseWrapper> getById(@RequestParam("user") String nombreUsuario, @RequestParam("pwd") String pwd) {
        System.out.println(nombreUsuario);
        System.out.println(pwd);
        Usuario u = usuarioService.login(nombreUsuario, pwd);

        if (null != u) {
            System.out.println("trajo el user");
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
    public ResponseEntity addUsuario(@RequestParam("usr")
                                             String nombreUsuario,
                                     @RequestParam("pwd")
                                             String password,
                                     @RequestParam("apellido")
                                             String apellido,
                                     @RequestParam("nombre")
                                             String nombre,
                                     @RequestParam("direccion")
                                             String direccion,
                                     @RequestParam("tel")
                                             String telefono,
                                     @RequestParam("ciudad")
                                             Integer ciudad,
                                     @RequestParam("emailAlt")
                                             String emailAlternativo) {
        try {
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
            /*request.getNombreUsuario(),
                    request.getPassword(),
                    request.getApellido(),
                    request.getDireccion(),
                    request.getCiudad(),
                    request.getEmailAlternativo()
            );*/

            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}