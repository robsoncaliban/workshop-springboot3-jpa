package com.robson.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robson.course.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
}
