package com.robson.course.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.course.entidades.Usuario;
import com.robson.course.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorio;

    public List<Usuario> buscarTodos(){
        return repositorio.findAll();
    }

    public Usuario buscarPeloId(long id){
        Optional<Usuario> resultado = repositorio.findById(id);
        return resultado.get();
    }
    

}
