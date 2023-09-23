package com.robson.course.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.course.entidades.Usuario;
import com.robson.course.serviços.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosDeUsuario {

    @Autowired
    private ServicoUsuario servico;

    @GetMapping
    public ResponseEntity<List> buscarTodos(){
        List<Usuario> list = servico.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPeloId(@PathVariable long id){
        Usuario usuario = servico.buscarPeloId(id);
        return ResponseEntity.ok().body(usuario);
    }

}
