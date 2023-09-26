package com.robson.course.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.course.entidades.Categoria;
import com.robson.course.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio repositorio;

    public List<Categoria> buscarTodos(){
        return repositorio.findAll();
    }

    public Categoria buscarPeloId(long id){
        Optional<Categoria> resultado = repositorio.findById(id);
        return resultado.get();
    }
    

}
