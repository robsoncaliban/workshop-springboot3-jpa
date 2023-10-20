package com.robson.course.serviços;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.robson.course.entidades.Usuario;
import com.robson.course.repositorios.UsuarioRepositorio;
import com.robson.course.serviços.exceptions.DatabaseException;
import com.robson.course.serviços.exceptions.ResourceNotFoundException;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> buscarTodos(){
        return repositorio.findAll();
    }

    public Usuario buscarPeloId(long id){
        Optional<Usuario> resultado = repositorio.findById(id);
        return resultado.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario addUsuario(Usuario usuario){
        return repositorio.save(usuario);
    }

    public void deleteUsuario(Long id){
        Usuario usuario = buscarPeloId(id);
        try {
            repositorio.delete(usuario);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
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
