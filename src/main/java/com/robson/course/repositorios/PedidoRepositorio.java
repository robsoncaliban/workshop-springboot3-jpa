package com.robson.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robson.course.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
    
}
