package com.robson.course.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.course.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosDeUsuarios {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(1L, "maria", "maria@gmail.com", "999999", "1237");
        return ResponseEntity.ok().body(u);
    }

}
