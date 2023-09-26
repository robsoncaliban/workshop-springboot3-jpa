package com.robson.course.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.course.entidades.Produto;
import com.robson.course.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repositorio;

    public List<Produto> buscarTodos(){
        return repositorio.findAll();
    }

    public Produto buscarPeloId(long id){
        Optional<Produto> resultado = repositorio.findById(id);
        return resultado.get();
    }
    

}
