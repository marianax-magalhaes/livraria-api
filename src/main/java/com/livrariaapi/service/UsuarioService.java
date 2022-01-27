package com.livrariaapi.service;

import com.livrariaapi.domain.Usuario;
import com.livrariaapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario saveUser(Usuario user){
        return repository.save(user);
    }

    public Usuario fetchUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public Usuario fetchUserByEmailAndSenha(String email, String senha){
        return repository.findByEmailAndSenha(email,senha);
    }

}


















