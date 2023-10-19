package com.robson.course.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.robson.course.entidades.enums.PedidoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido implements Serializable{
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido(Instant momento, PedidoStatus status, Usuario cliente){
        itens = new HashSet<>();
        this.momento = momento;
        setStatus(status);
        this.cliente = cliente;
    }

    public Double getTotal(){
        double soma = 0.0;
        for(ItemPedido i : itens){
            soma += i.getSubTotal();
        }
        return soma;
    }

    public PedidoStatus getStatus(){
        return PedidoStatus.valueOf(status);
    }

    public void setStatus(PedidoStatus status){
        if(status != null){
            this.status = status.getCodigo();
        }
    }

}
