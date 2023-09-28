package com.robson.course.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.course.entidades.Categoria;
import com.robson.course.serviços.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {

    @Autowired
    private CategoriaServico servico;

    @GetMapping
    public ResponseEntity<List> buscarTodos(){
        List<Categoria> list = servico.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarPeloId(@PathVariable long id){
        Categoria categoria = servico.buscarPeloId(id);
        return ResponseEntity.ok().body(categoria);
    }

}
