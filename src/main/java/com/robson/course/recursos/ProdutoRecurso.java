package com.robson.course.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.course.entidades.Produto;
import com.robson.course.serviços.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {

    @Autowired
    private ProdutoServico servico;

    @GetMapping
    public ResponseEntity<List> buscarTodos(){
        List<Produto> list = servico.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarPeloId(@PathVariable long id){
        Produto produto = servico.buscarPeloId(id);
        return ResponseEntity.ok().body(produto);
    }

}
