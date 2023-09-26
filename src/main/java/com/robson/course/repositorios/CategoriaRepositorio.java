package com.robson.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robson.course.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {

    
}
