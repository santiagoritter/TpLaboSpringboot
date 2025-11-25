package com.example.demo.controller;

import com.example.demo.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejemplo")
public class EjController {

    @GetMapping("/hola")
    public String hola(){
        return "hola";
    }
    @GetMapping("/Usuario")
    public ResponseEntity<Usuario> getUsuario(){
        Usuario usuario = new Usuario(1, "mati", "faya", "matifaya@gmail", "123", 17);
        return ResponseEntity.ok(usuario);
    }


}
