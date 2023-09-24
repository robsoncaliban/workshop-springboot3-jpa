package com.robson.course.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.course.entidades.Pedido;
import com.robson.course.repositorios.RepositorioPedido;

@Service
public class ServicoPedido {

    @Autowired
    private RepositorioPedido repositorio;

    public List<Pedido> buscarTodos(){
        return repositorio.findAll();
    }

    public Pedido buscarPeloId(long id){
        Optional<Pedido> resultado = repositorio.findById(id);
        return resultado.get();
    }
    

}
