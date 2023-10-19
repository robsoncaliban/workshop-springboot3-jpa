package com.robson.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robson.course.entidades.Categoria;
import com.robson.course.entidades.ItemPedido;
import com.robson.course.entidades.Pagamento;
import com.robson.course.entidades.Pedido;
import com.robson.course.entidades.Produto;
import com.robson.course.entidades.Usuario;
import com.robson.course.entidades.enums.PedidoStatus;
import com.robson.course.repositorios.CategoriaRepositorio;
import com.robson.course.repositorios.ItemPedidoRepositorio;
import com.robson.course.repositorios.PedidoRepositorio;
import com.robson.course.repositorios.ProdutoRepositorio;
import com.robson.course.repositorios.UsuarioRepositorio;

import lombok.AllArgsConstructor;


@Configuration
@Profile("test")
@AllArgsConstructor
public class TesteConfig implements CommandLineRunner{
    
    private UsuarioRepositorio usuarioRepositorio;

    private PedidoRepositorio pedidoRepositorio;

    private CategoriaRepositorio categoriaRepositorio;

    private ProdutoRepositorio produtoRepositorio;

    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Override
    public void run(String... args) throws Exception{

        Usuario u1 = new Usuario("Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        Usuario u2 = new Usuario("Alex Green", "alex@gmail.com", "977777777", "123456"); 

        Pedido o1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
        Pedido o2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2); 
        Pedido o3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

        Categoria cat1 = new Categoria("Electronics"); 
        Categoria cat2 = new Categoria("Books"); 
        Categoria cat3 = new Categoria("Computers"); 

        Produto p1 = new   Produto("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
        Produto p2 = new   Produto("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
        Produto p3 = new   Produto("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
        Produto p4 = new   Produto("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
        Produto p5 = new   Produto("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreco()); 
        ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreco()); 
        ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreco());
        ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreco()); 

        Pagamento pag1 = new Pagamento(Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPagamento(pag1);
            
        usuarioRepositorio.saveAll(Arrays.asList(u1,u2));
        pedidoRepositorio.saveAll(Arrays.asList(o1,o2,o3));
        categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3)); 
        produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); 
        itemPedidoRepositorio.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
        

    }



}
