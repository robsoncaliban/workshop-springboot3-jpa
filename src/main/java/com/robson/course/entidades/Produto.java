package com.robson.course.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Produto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String imgUrl;

    
    @ManyToMany
    @JoinTable(name = "tb_produto_categoria", 
     joinColumns = @JoinColumn(name = "produto_id"),
     inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens;

    public Produto(String nome, String descricao, double preco, String imgUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.categorias = new HashSet<>();
        this.itens = new HashSet<>();
    }

    @JsonIgnore
    public Set<Pedido> getPedidos(){
        Set<Pedido> pedidos = new HashSet<>();
        for(ItemPedido x : itens){
            pedidos.add(x.getPedido());
        }
        return pedidos;
    }

}
