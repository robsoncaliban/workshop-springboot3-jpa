package com.robson.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robson.course.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
    
}
