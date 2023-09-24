package com.robson.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robson.course.entidades.Pedido;
import com.robson.course.entidades.Usuario;
import com.robson.course.repositorios.RepositorioPedido;
import com.robson.course.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    
    @Autowired
    private RepositorioUsuario repositorioDeUsuario;

    @Autowired
    private RepositorioPedido repositorioDePedido;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario("Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        Usuario u2 = new Usuario("Alex Green", "alex@gmail.com", "977777777", "123456"); 

        Pedido o1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), u1); 
        Pedido o2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), u2); 
        Pedido o3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), u1);

        repositorioDeUsuario.saveAll(Arrays.asList(u1,u2));
        repositorioDePedido.saveAll(Arrays.asList(o1,o2,o3));
    }



}
