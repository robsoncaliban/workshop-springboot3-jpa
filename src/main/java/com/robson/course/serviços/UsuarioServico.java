package com.robson.course.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.course.entidades.Usuario;
import com.robson.course.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> buscarTodos(){
        return repositorio.findAll();
    }

    public Usuario buscarPeloId(long id){
        Optional<Usuario> resultado = repositorio.findById(id);
        return resultado.get();
    }

    public Usuario addUsuario(Usuario usuario){
        return repositorio.save(usuario);
    }

    public void deleteUsuario(Long id){
        repositorio.deleteById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuario){
        Usuario entidade = repositorio.getReferenceById(id);
        updateData(entidade, usuario);
        return repositorio.save(entidade);
    }

    private Usuario updateData(Usuario usuarioUpdate, Usuario usuario){
        usuarioUpdate.setNome(usuario.getNome());
        usuarioUpdate.setEmail(usuario.getEmail());
        usuarioUpdate.setTelefone(usuario.getTelefone());
        return usuarioUpdate;
    }
    

}
