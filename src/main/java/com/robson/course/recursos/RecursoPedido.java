package com.robson.course.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.course.entidades.Pedido;
import com.robson.course.serviços.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {

    @Autowired
    private ServicoPedido servico;

    @GetMapping
    public ResponseEntity<List> buscarTodos(){
        List<Pedido> list = servico.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarPeloId(@PathVariable long id){
        Pedido usuario = servico.buscarPeloId(id);
        return ResponseEntity.ok().body(usuario);
    }

}
