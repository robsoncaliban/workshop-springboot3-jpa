package com.robson.course.entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.robson.course.entidades.pk.ItemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @EmbeddedId
    private ItemPedidoPK id;

    private Integer quantidade;
    private double preco;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, double preco) {
        id = new ItemPedidoPK();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getSubTotal(){
        return  preco * quantidade;
    }


    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }
    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }
    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

}
