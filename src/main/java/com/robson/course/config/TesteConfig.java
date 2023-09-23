package com.robson.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robson.course.entidades.Usuario;
import com.robson.course.repositorios.RepositorioDeUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    
    @Autowired
    private RepositorioDeUsuario repositorioDeUsuario;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario("Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        Usuario u2 = new Usuario("Alex Green", "alex@gmail.com", "977777777", "123456"); 

        repositorioDeUsuario.saveAll(Arrays.asList(u1,u2));
    }



}
