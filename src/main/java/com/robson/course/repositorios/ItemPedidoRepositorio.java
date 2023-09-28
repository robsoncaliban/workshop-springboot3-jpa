package com.robson.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robson.course.entidades.ItemPedido;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido,Long> {

    
}
