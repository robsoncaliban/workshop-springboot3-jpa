package com.robson.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robson.course.entidades.Pedido;
import com.robson.course.entidades.Usuario;
import com.robson.course.entidades.enums.PedidoStatus;
import com.robson.course.repositorios.PedidoRepositorio;
import com.robson.course.repositorios.UsuarioRepositorio;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Override
    public void run(String... args){

        try{
            Usuario u1 = new Usuario("Maria Brown", "maria@gmail.com", "988888888", "123456"); 
            Usuario u2 = new Usuario("Alex Green", "alex@gmail.com", "977777777", "123456"); 

            Pedido o1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
            Pedido o2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2); 
            Pedido o3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

            usuarioRepositorio.saveAll(Arrays.asList(u1,u2));
            pedidoRepositorio.saveAll(Arrays.asList(o1,o2,o3));
        }catch(Exception e){
            System.out.println("AAAAAAAAAAA");
        }
        
    }



}
